<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<body>
<table border="1">
    <tr>

        <th>Trạng Thái</th>
        <th>Tên SP giày</th>
        <th>Tên Khuyến Mãi</th>
        <th colspan="2">Action</th>
    </tr>

        <c:forEach items="${data}" var="d">
            <tr>
            <td>${d.trangThai}</td>
            <td>${d.chiTietGiay.ten}</td>
            <td>${d.dotKhuyenMai.tenKhuyenMai}</td>
            <td><a href="/KhuyenMaiChiTiet/edit/${d.id}">Update</a></td>
            <td><a href="/KhuyenMaiChiTiet/delete/${d.id}">Delete</a></td>
    </tr>>
        </c:forEach>

</table>
<div>
    <button><a href="/KhuyenMaiChiTiet/create">Thêm mới</a></button>
</div>
</body>
</html>