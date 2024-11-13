<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/13/2024
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới danh sách</title>
</head>
<body>
<h1>Tạo mới khách thuê</h1>

<form method="post" action="/?action=add">
    <fieldset>
        <legend>Thông tin</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>SDT:</td>
                <td><input type="text" name="phone" id="phone"></td>
            </tr>
            <tr>
                <td>Ngày thuê:</td>
                <td><input type="date" name="date" id="date"></td>
            </tr>
            <tr>
                <td>Hình thức thanh toán:</td>
                <td>
                    <select name="payment" id="payment" required>
                        <option>Theo tháng</option>
                        <option>Theo quý</option>
                        <option>Theo năm</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Ghi chú:</td>
                <td><input type="text" name="note" id="note"></td>
            </tr>
            <tr>
                <td>
                    <a href="/">Back to customer list</a>
                </td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
