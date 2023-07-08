<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<html>
<body>
<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Ngày BĐ</th>
        <th>Ngày KT</th>
        <th>Trạng Thái</th>
        <th>Số Lượng</th>
        <th>Phần trăm</th>
        <th>Giá tiền giảm</th>
        <th>Loài KM</th>
        <th>Mô tả</th>
        <th colspan="2">Action</th>
    </tr>

        <c:forEach items="${data}" var="d">
    <tr>
            <td>${d.maKhuyenMai}</td>
            <td>${d.tenKhuyenMai}</td>
            <td>${d.ngayBatDau}</td>
            <td>${d.ngayKetThuc}</td>
            <td>${d.trangThai}</td>
            <td>${d.soLuong}</td>
            <td>${d.phanTram}</td>
            <td>${d.giaTienGiam}</td>
            <td>${d.loaiKhuyenMai}</td>
            <td>${d.moTa}</td>
            <td><a href="/DotKhuyenMai/edit/${d.id}">Update</a></td>
            <td><a href="/DotKhuyenMai/delete/${d.id}">Delete</a></td>
    </tr>
        </c:forEach>

</table>
<div>
    <button><a href="/DotKhuyenMai/create">Thêm mới</a></button>
</div>
</body>
</html>