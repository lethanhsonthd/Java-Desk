/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author son
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private final String SEARCH_MOBILE_BY_NAME_SERVLET = "SearchMobileByNameServlet";
    private final String DELETE_MOBILE_SERVLET = "DeleteMobileServlet";
    private final String UPDATE_MOBILE_SERVLET = "UpdateMobileServlet";
    private final String CREATE_MOBILE_SERVLET = "CreateMobileServlet";
    private final String SEARCH_MOBILE_BY_PRICE_SERVLET = "SearchMobileByPriceServlet";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String CHECK_OUT_SERVLET = "CheckoutServlet";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String button = request.getParameter("btAction");
        String url = "";
        try {
            if (button.equals("search by name")) {
                url = SEARCH_MOBILE_BY_NAME_SERVLET;
            } else if (button.equals("delete mobile")) {
                url = DELETE_MOBILE_SERVLET;
            } else if (button.equals("update mobile")) {
                url = UPDATE_MOBILE_SERVLET;
            } else if (button.equals("create mobile")) {
                url = CREATE_MOBILE_SERVLET;
            } else if (button.equals("search by price")) {
                url = SEARCH_MOBILE_BY_PRICE_SERVLET;
            } else if (button.equals("login")) {
                url = LOGIN_SERVLET;
            } else if (button.equals("add to cart")) {
                url = ADD_TO_CART_SERVLET;
            } else if (button.equals("check out")){
                url = CHECK_OUT_SERVLET;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
