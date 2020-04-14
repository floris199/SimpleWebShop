<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cart Page</title>
    <style><%@include file="/WEB-INF/userStyle.css"%></style>
</head>
<body>
<center>
    <table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>Option</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Sub Total</th>
        </tr>
        <c:set var="total" value="0"></c:set>
        <c:forEach var="item" items="${sessionScope.cart}">
            <c:set var="total" value="${total + item.product.price * item.quantity}"></c:set>
            <tr>
                <td align="center">
                    <a href="${pageContext.request.contextPath }/Cart?action=remove&id=${item.product.id }"
                       onclick="return confirm('Are you sure?')">Remove</a>
                </td>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="right">Total</td>
            <td>${total}</td>
        </tr>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/">Continue Shopping</a>
</center>

<div class="footer">
    <p>I'm a Footer, I don't do too much :(</p>
</div>
</body>
</html>