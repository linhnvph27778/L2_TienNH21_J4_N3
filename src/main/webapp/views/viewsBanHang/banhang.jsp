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

    <div class="col-8 offset-2  " style="background-color: #e5e5e5; border: #007bff 10px">
        <table class="table mt-3 text-center">
            <thead class="">
                <tr>
                    <th>Sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbdoy>
                <c:forEach items="${gioHangChiTiet}" var="gh">
                    <tr>
                        <td>
                            <div class="row p-0">
                                <div class="col-6">
                                    <img src="/images/imgChiTietGiay/${gh.hinhAnh}" alt="" height="80" width="100">
                                </div>
                                <div class="col-6">
                                    <div class="fs-2 fw-bold">${gh.tenGiay}</div>
                                    <div class="text-danger text-">${gh.giaBan} đ</div>
                                    <div class="">Size ${gh.size}</div>
                                </div>
                            </div>
                        </td>
                        <td>${gh.soLuong}</td>
                        <td>${gh.soLuong * gh.giaBan}</td>
                        <td>
                            <a class="btn btn-danger" href="/hien-thi">Xóa khỏi giỏ</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbdoy>
        </table>
        <hr/>
        <div class="text-center">Tổng tiền :${tongTien}</div>

    </div>
    <div class="col-8 offset-2 mt-5" style="background-color: #e5e5e5 ">
        <table class="table mt-3 text-center">
            <thead>
            <tr>
                <th>Mã</th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>Email</th>
                <th>SDT</th>
                <th>Trạng thái</th>
                <th>Loại khách hàng</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbdoy>
                <c:forEach items="${listkh}" var="kh">
                    <tr>
                        <td>${kh.ma}</td>
                        <td>${kh.hoTen}</td>
                        <td><f:formatDate value="${kh.ngaySinh}" pattern="dd-MM-yyyy"/></td>
                        <td>${kh.email}</td>
                        <td>${kh.sdt}</td>
                        <td>${kh.trangThai==1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                        <td>${kh.loaiKhachHang.ten}</td>
                        <td>
                            <a href="/khach-hang/datail/${kh.id}" class="btn btn-primary">Chọn</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbdoy>
        </table>
    </div>
    <div></div>
</div>

</body>
</html>
