/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbl_mobile.MobileDAO;
import tbl_mobile.MobileDTO;

/**
 *
 * @author son
 */
@WebServlet(name = "SearchMobileByPriceServlet", urlPatterns = {"/SearchMobileByPriceServlet"})
public class SearchMobileByPriceServlet extends HttpServlet {

    private final String ERR_PAGE = "errPage.html";

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
        String urlRewriting = "searchMobileByPrice.jsp";
        String tempMinPrice = request.getParameter("txtMinPrice");
        String tempMaxPrice = request.getParameter("txtMaxPrice");
        int minPrice = 0, maxPrice = 0;
        if (tempMaxPrice == null) {
            minPrice = 0;
        } else if (tempMaxPrice.equals("")) {
            maxPrice = Integer.MAX_VALUE;
        } else {
            maxPrice = Integer.parseInt(tempMaxPrice);
        }
        if (tempMinPrice == null) {
            minPrice = 0;
        } else if (tempMinPrice.equals("")) {
            minPrice = Integer.MIN_VALUE;
        } else {
            minPrice = Integer.parseInt(tempMinPrice);
        }
        try {
            MobileDAO dao = new MobileDAO();
            Vector<MobileDTO> res = dao.searchByPrice(minPrice, maxPrice);
            if (res != null) {
                request.setAttribute("SEARCHRESULT", res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchMobileByPriceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchMobileByPriceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(urlRewriting);
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
