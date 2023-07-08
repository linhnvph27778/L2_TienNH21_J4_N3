<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="col-10 offset-1 mt-3">
    <div>
        <c:if test="${ not empty sessionScope.message }">
            <div class="alert alert-success text-center">${sessionScope.message}</div>
            <c:remove var="message" scope="session"/>
        </c:if>
    </div>
    <div class="col-4 offset-4 mt-4">
        <form action="/khach-hang/search" method="get">
            <div class="mt-2">
                <label>Tìm kiếm</label>
                <input name="keyword" class="form-control" type="text" placeholder="Tên hoặc mã" aria-label="Tên hoặc mã">
            </div>
            <div class="mt-3">
                <label>Loại khách hàng</label>
                <select name="loaiKH" class="form-select">
                    <c:forEach items="${listLKH}" var="kh">
                        <option value="${kh.id}">${kh.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Search</button>
                <a class="btn btn-success" href="/khach-hang/viewAdd">Add</a>
            </div>
        </form>
    </div>


    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
            <td>Mã</td>
            <td>Họ tên</td>
            <td>Ngày sinh</td>
            <td>Email</td>
            <td>SDT</td>
            <td>Trạng thái</td>
            <td>Pass</td>
            <td>Số lần mua</td>
            <td>Loại khách hàng</td>
<%--            <td>Địa chỉ</td>--%>
            <td colspan="2">Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list.content}" var="kh" >
                <tr>
                    <td>${kh.ma}</td>
                    <td>${kh.hoTen}</td>
                    <td>${kh.ngaySinh}</td>
                    <td>${kh.email}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.trangThai}</td>
                    <td>${kh.pass}</td>
                    <td>${kh.soLanMua}</td>
                    <td>${kh.loaiKhachHang.ten}</td>
                    <td>
                        <a onclick="xacNhan(event)" href="/khach-hang/delete/${kh.id}" class="btn btn-danger">Xoa</a>
                        <a href="/khach-hang/viewUpdate/${kh.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
    <div class="mt-3">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/khach-hang/hien-thi?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>

</body>

<script>
    function xacNhan(event){
        var mes= confirm("Ban có chắc muốn xóa không");
        if (!mes){
            event.preventDefault();
        }
    }
</script>
</html>
