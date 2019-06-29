<%-- 
    Document   : searchMobile
    Created on : Jun 29, 2019, 2:47:27 PM
    Author     : son
--%>

<%@page import="java.util.Vector"%>
<%@page import="tbl_mobile.MobileDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Mobile By Name</title>
    </head>
    <body>
        <h1>Search Mobile By Name</h1>
        <form action="DispatchServlet">
            Search Value: <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="search by name" name="btAction" />
        </form>
        <%
            Vector<MobileDTO> searchResult = (Vector<MobileDTO>) request.getAttribute("SEARCHRESULT");
            if (searchResult != null) {
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
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (MobileDTO dto : searchResult) {
                        String urlRewriting = "DispatchServlet?"
                                + "btAction=delete mobile&"
                                + "pk="
                                + dto.getMobileId()
                                + "&lastSearchValue="
                                + request.getParameter("txtSearchValue");
                %>
            <form action="DispatchServlet" method="POST">
                <tr>
                <input type="hidden" name="txtMobileId" value="<%= dto.getMobileId()%>" />
                <td>
                    <%= ++count%>
                </td>
                <td>
                    <input type="text" name="txtDescription" value="<%= dto.getDescription()%>" />
                </td>
                <td>
                    <input type="text" name="txtPrice" value="<%= dto.getPrice()%>" />
                </td>
                <td>
                    <input type="text" name="txtName" value="<%= dto.getMobileName()%>" />
                </td>
                <td>
                    <input type="text" name="txtYear" value="<%= dto.getYearOfProduction()%>" />
                </td>
                <td>
                    <input type="text" name="txtQuantity" value="<%= dto.getQuantity()%>" />
                </td>
                <td>
                    <input type="checkbox" name="chkSale" value="<%= dto.getMobileId() %>"
                           <% if (dto.isNotSale()) {
                           %> checked = "checked" <%
                               }%>
                           />
                </td>
                <td>
                    <a href="<%= urlRewriting%>">Delete</a>
                </td>
                <input type="hidden" name="txtSearchValue" value="<%= request.getParameter("txtSearchValue") %>" />
                <td>
                    <input type="submit" value="update mobile" name="btAction" />
                </td>
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
