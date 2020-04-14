<%@ page import ="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<style><%@include file="/WEB-INF/userStyle.css"%></style>

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

    <h1>
        Available Products
    </h1>

    <table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Buy</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price }</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/Cart?&action=buy&id=${product.id}">Add to cart</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</center>

<div class="footer">
    <p>I'm a Footer, I don't do too much :(</p>
</div>
</body>
</html>