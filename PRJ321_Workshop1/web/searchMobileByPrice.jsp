<%-- 
    Document   : searchMobileByPrice
    Created on : Jun 29, 2019, 7:05:03 PM
    Author     : son
--%>

<%@page import="java.util.Vector"%>
<%@page import="tbl_mobile.MobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Mobile By Price</title>
    </head>
    <body>
        <h1>Search Mobile By Price</h1>
        <form action="DispatchServlet" method="POST">
            Min: <input type="text" name="txtMinPrice" value="" /><br>
            Max: <input type="text" name="txtMaxPrice" value="" /><br>
            <input type="submit" value="search by price" name="btAction" />
        </form>
        <%
            Vector<MobileDTO> res = (Vector<MobileDTO>) request.getAttribute("SEARCHRESULT");
            if (res != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Name</th>
                    <th>Year Of Production</th>
                    <th>quantity</th>
                    <th>Not Sale</th>
                    <th>Add to cart</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (MobileDTO dto : res) {
                        String urlRewriting = "DispatchServlet?"
                                + "btAction=add to cart&"
                                + "pk="
                                + dto.getMobileId()
                                + "&txtMinPrice="
                                + request.getParameter("txtMinPrice")
                                + "&txtMaxPrice="
                                + request.getParameter("txtMaxPrice");
                %>
            <form action="DispatchServlet" method="POST">
                <tr>
                    <td> <%= ++count%></td>
                    <td>
                        <%= dto.getDescription()%>
                    </td>
                    <td>
                        <%= dto.getPrice()%>
                    </td>
                    <td>
                        <%= dto.getMobileName()%>
                    </td>
                    <td>
                        <%= dto.getYearOfProduction()%>
                    </td>
                    <td>
                        <%= dto.getQuantity()%>
                    </td>
                    <td>
                        <input disabled="true" type="checkbox" name="chkSale" value="<%= dto.getMobileId()%>"
                               <% if (dto.isNotSale()) {
                               %> checked = "checked" <%
                                   }%>
                               />
                    </td>
                    <td>
                        <input type="submit" value="add to cart" name="btAction" />
                    </td>
                <input type="hidden" name="item" value="<%= dto.getMobileName()%>" />
                <input type="hidden" name="itemID" value="<%= dto.getMobileId() %>" />
                <input type="hidden" name="txtMinPrice" value="<%= request.getParameter("txtMinPrice") %>" />
                <input type="hidden" name="txtMaxPrice" value="<%= request.getParameter("txtMaxPrice") %>" />
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        }
    %>
</body>
</html>
