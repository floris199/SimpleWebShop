<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Shop</title>
    <style><%@include file="/WEB-INF/userStyle.css"%></style>
</head>
<body>
<center>
    <h1>
        Select the type of product
    </h1>
    <form method="post" action="SelectProduct">
        <br>
        <table>
            <tr>
                <c:forEach var="productType" items="${productTypes}">
                    <td>
                        <button class="tab" type="submit" name="productSelected" value="${productType.code}">
                                ${productType.description}
                        </button>
                    </td>
                </c:forEach>
            </tr>
        </table>

    </form>
</center>


<div class="footer">
    <p>I'm a Footer, I don't do too much :(</p>
</div>
</body>
</html>