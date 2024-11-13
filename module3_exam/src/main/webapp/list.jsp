<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2024
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách phòng trọ</title>
</head>
<body>
<h1>Danh sách phòng trọ</h1>
<p>
    <a href="/?action=add">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>STT</td>
        <td>Mã phòng trọ</td>
        <td>Tên người thuê</td>
        <td>Sô điện thoại</td>
        <td>Ngày bắt đầu thuê</td>
        <td>Hình thức thanh toán</td>
        <td>Ghi chú</td>
    </tr>
    <c:forEach items='${requestScope["rooms"]}' var="r" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>PT-${r.id}</td>
            <td><a href="/customers?action=view&id=${r.getId()}">${r.getName()}</a></td>
            <td>${r.getPhoneNumber()}</td>
            <td>${r.getFirstDate()}</td>
            <td>${r.payment.paymentName}</td>
            <td>${r.note}</td>
            <td><a href="/customers?action=delete&id=${r.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
