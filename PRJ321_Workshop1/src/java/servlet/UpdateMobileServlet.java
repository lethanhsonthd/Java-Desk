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
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "UpdateMobileServlet", urlPatterns = {"/UpdateMobileServlet"})
public class UpdateMobileServlet extends HttpServlet {

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
        String txtSearchValue = request.getParameter("txtSearchValue");
        String urlRewriting = "DispatchServlet?btAction=search by name&txtSearchValue=" + txtSearchValue;
        String txtMobileId = request.getParameter("txtMobileId");
        String txtDescription = request.getParameter("txtDescription");
        String txtPrice = request.getParameter("txtPrice");
        float price = 0;
        int year = 0;
        int quantity = 0;
        try {
            price = Float.parseFloat(txtPrice);
        } catch (Exception e) {
            urlRewriting = "errPage.html";
        }
        String txtName = request.getParameter("txtName");
        String txtYear = request.getParameter("txtYear");
        try {
            year = Integer.parseInt(txtYear);
        } catch (Exception e) {
            urlRewriting = "errPage.html";
            log(e.getMessage());
        }
        String txtQuantity = request.getParameter("txtQuantity");
        try {
            quantity = Integer.parseInt(txtQuantity);
        } catch (Exception e) {
            urlRewriting = "errPage.html";
            log(e.getMessage());
        }
        boolean notSale = false;
        String[] chkSale = request.getParameterValues("chkSale");
        if (chkSale != null){
            for (String x : chkSale) {
                if (x.equals(txtMobileId)) {
                    notSale = true;
                    break;
                }
            }
        }
        try {
            MobileDAO dao = new MobileDAO();
            boolean res = dao.updateMobile(txtMobileId, txtDescription, price, txtName, year, quantity, notSale);
            if (!res) {
                urlRewriting = "errPage.html";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateMobileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
