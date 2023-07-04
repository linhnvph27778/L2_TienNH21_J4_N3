<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<body>
<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên</th>

        <th>Trạng Thái</th>

        <th colspan="2">Action</th>
    </tr>

        <c:forEach items="${data}" var="d">
    <tr>
            <td>${d.ma}</td>
            <td>${d.ten}</td>
            <td>${d.trangThai}</td>

            <td><a href="/MauSac/edit/${d.id}">Update</a></td>
            <td><a href="/MauSac/delete/${d.id}">Delete</a></td>
    </tr>
        </c:forEach>

</table>
<div>
    <button><a href="/MauSac/create">Thêm mới</a></button>
</div>
</body>
</html>