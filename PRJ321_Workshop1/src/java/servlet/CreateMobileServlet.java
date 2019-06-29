/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbl_mobile.MobileDAO;

/**
 *
 * @author son
 */
@WebServlet(name = "CreateMobileServlet", urlPatterns = {"/CreateMobileServlet"})
public class CreateMobileServlet extends HttpServlet {

    private final String ERR_PAGE = "errPage.html";
    private final String CREATE_SUCCESSFULLY_PAGE = "createMobileSuccessfullyPage.html";

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
        float price = 0;
        int year = 0, quantity = 0;
        boolean notSale = false;
        String urlRewriting = CREATE_SUCCESSFULLY_PAGE;
        PrintWriter out = response.getWriter();
        String id = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        String description = request.getParameter("txtDescription");
        String tempYear = request.getParameter("txtYearOfProduction");
        String tempQuantity = request.getParameter("txtQuantity");
        String tempPrice = request.getParameter("txtPrice");
        String[] chkNotSale = request.getParameterValues("chkNotSale");

        try {
            year = Integer.parseInt(tempYear);
            quantity = Integer.parseInt(tempQuantity);
            price = Float.parseFloat(tempPrice);
        } catch (Exception e) {
            urlRewriting = ERR_PAGE;
        }
        if (chkNotSale != null){
            notSale = true;
        }
        try {
            MobileDAO dao = new MobileDAO();
            boolean res = dao.createMobile(id, description, price, name, year, quantity, notSale);
            if (!res) {
                urlRewriting = ERR_PAGE;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(urlRewriting);
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
