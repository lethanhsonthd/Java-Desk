<%-- 
    Document   : createNewMobile
    Created on : Jun 29, 2019, 6:10:41 PM
    Author     : son
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Mobile</title>
    </head>
    <body>
        <h1>Create New Mobile</h1>
        <form action="DispatchServlet" method="POST">
            <c:set var="errors" value="${requestScope.ERR}"></c:set>
                ID: <input type="text" name="txtID" value="" /> <br>
                Name: <input type="text" name="txtName" value="" /><br>
            <c:if test="${not empty errors.getMobileNameLengthErr}">
                <div>${errors.getMobileNameLengthErr}</div>
            </c:if>
            Description:  <input type="text" name="txtDescription" value="" /><br>
            <c:if test="${not empty errors.getDescriptionLengthErr}">
                <div>${errors.getDescriptionLengthErr}</div>
            </c:if>
            Price: <input type="text" name="txtPrice" value="" /><br>
            Year of production: <input type="text" name="txtYearOfProduction" value="" /><br>
            Quantity: <input type="text" name="txtQuantity" value="" /><br>
            Not sale: <input type="checkbox" name="chkNotSale" value="ON" /> <br>
            <input type="submit" value="create mobile" name="btAction" />
        </form>
    </body>
</html>
