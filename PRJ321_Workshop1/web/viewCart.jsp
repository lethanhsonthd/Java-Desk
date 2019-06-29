<%-- 
    Document   : viewCart
    Created on : Jun 29, 2019, 8:39:56 PM
    Author     : son
--%>

<%@page import="javafx.util.Pair"%>
<%@page import="java.util.Map"%>
<%@page import="cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View your cart</title>
    </head>
    <body>
        <h1>View cart</h1>
        <%
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart != null) {
                int count = 0;
        %>
        <form action="DispatchServlet" method="POST">

            <table border="1">
                <thead>
                    <tr>
                        <th>No.1</th>
                        <th>Name</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Map<String, Pair<String, Integer>> items = cart.getItems();
                        for (Map.Entry entry : items.entrySet()) {
                            Pair t = (Pair) entry.getValue();
                            int quantity = (int) t.getValue();
                            String name = (String) t.getKey();
                    %>
                    <tr>
                        <td><%= ++count%></td>
                        <td><%= name%></td>
                        <td><%= quantity%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table> <br>
            <input type="submit" value="check out" name="btAction" />
            <%
                }
            %>
        </form>
    </body>
</html>
