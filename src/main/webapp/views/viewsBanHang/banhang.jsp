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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="col-10 offset-1 mt-3">
        <div class="col-10 offset-1">
            <div class="row">
                <c:if test="${ not empty sessionScope.message }">
                    <div class="alert alert-success text-center">${sessionScope.message}</div>
                    <c:remove var="message" scope="session"/>
                </c:if>
            </div>
            <div>
                <nav class="navbar navbar-expand-lg " style="background-color: #e3f2fd;">
                    <a class="btn" href="/mua-hang/cart">
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                             class="bi bi-person-add" viewBox="0 0 16 16">
                            <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z"/>
                            <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z"/>
                        </svg>
                    </a>
                    <div class="collapse navbar-collapse shop__sidebar__size">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <c:forEach items="${listHoaDon}" var="hd">
                                <li class="nav-item">
                                    <label class="text-center mr-3">
                                        <a class="btn btn-outline-dark" href="/mua-hang/cart/hoadon/${hd.id}">
                                                ${hd.ma}
                                        </a>
                                    </label>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>

        <%--        Modal chọn san pham--%>
        <% boolean modalFullSP = (Boolean) request.getAttribute("modalFullSP"); %>
        <% if (modalFullSP) { %>
        <div class="modal fade" id="chonSanPham" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <form method="get" action="/mua-hang/cart/view/timKiem">
                        <div class="row">
                            <div class="col-8">
                                <div class="row m-3">
                                    <div class="col-8">
                                        <label>Giày</label>
                                        <input name="keyword" class="form-control" type="text" placeholder="Tên hoặc mã"
                                               aria-label="Tên hoặc mã">
                                    </div>
                                    <div class="col-2">
                                        <label>Giá Min</label>
                                        <input name="giaMin" class="form-control" type="number">
                                    </div>
                                    <div class="col-2">
                                        <label>Giá Max</label>
                                        <input name="giaMax" class="form-control" type="number">
                                    </div>
                                </div>
                            </div>
                            <div class="col-4 mt-5">
                                <button type="submit" class="btn btn-primary" style="float:left">Search</button>
                                <a href="/mua-hang/cart/view" class="btn btn-dark mr-3" style="float:right">
                                    Back
                                </a>
                            </div>
                        </div>
                        <div class="col-8 offset-2 mt-2">
                            <div class="row">
                                <div class="col-4">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <label class="form-label me-2">Hãng : </label>
                                        </div>
                                        <div>
                                            <nav class="navbar navbar-expand-lg navbar-light">
                                                <ul class="navbar-nav">
                                                    <li class="nav-item dropdown">
                                                        <a class="nav-link dropdown-toggle text-info" href="#" id="navbarDropdownHang"
                                                           role="button" data-toggle="dropdown" aria-haspopup="true"
                                                           aria-expanded="false">
                                                            Tất cả
                                                        </a>
                                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownHang">
                                                            <c:forEach items="${hang}" var="kh">
                                                                <a class="dropdown-item" href="/mua-hang/cart/view/findByBrand/${kh.id}">${kh.ten}</a>
                                                            </c:forEach>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <label class="form-label me-2">Màu sắc</label>
                                        </div>
                                        <div>
                                            <nav class="navbar navbar-expand-lg navbar-light">
                                                <ul class="navbar-nav">
                                                    <li class="nav-item dropdown">
                                                        <a class="nav-link dropdown-toggle text-info" href="#" id="navbarDropdownMauSac"
                                                           role="button" data-toggle="dropdown" aria-haspopup="true"
                                                           aria-expanded="false">
                                                            Tất cả
                                                        </a>
                                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMauSac">
                                                            <c:forEach items="${mauSac}" var="kh">
                                                                <a class="dropdown-item" href="/mua-hang/cart/view/findByColor/${kh.id}">${kh.ten}</a>
                                                            </c:forEach>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="d-flex align-items-center">
                                        <div>
                                            <label class="form-label me-2">Size :</label>
                                        </div>
                                        <div>
                                            <nav class="navbar navbar-expand-lg navbar-light">
                                                <ul class="navbar-nav">
                                                    <li class="nav-item dropdown">
                                                        <a class="nav-link dropdown-toggle text-info" href="#" id="navbarDropdownSize"
                                                           role="button" data-toggle="dropdown" aria-haspopup="true"
                                                           aria-expanded="false">
                                                            Tất cả
                                                        </a>
                                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownSize">
                                                            <c:forEach items="${size}" var="kh">
                                                                <a class="dropdown-item" href="/mua-hang/cart/view/findBySize/${kh.id}">${kh.soSize}</a>
                                                            </c:forEach>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="modal-body">
                        <table class="table mt-3 text-center">
                            <thead class="">
                            <tr>
                                <th>Ảnh</th>
                                <th></th>
                                <th>Mã</th>
                                <th>Tên</th>
                                <th>Tổng kho</th>
                                <th>Giá thấp nhất</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${not empty sessionScope.checkList}">
                                <div class="error-message text-center text-dark">${sessionScope.checkList}</div>
                                <c:remove var="checkList" scope="session"/>
                            </c:if>
                            <c:forEach items="${listChonSanPham}" var="kh">
                                <tr>
                                    <td>
                                        <img src="/img/imgsProducts/${kh.hinhAnh.urlImg0}" alt="" height="90"
                                             width="100"/>
                                    <td>
                                    <td>${kh.giay.ma}</td>
                                    <td>${kh.giay.ten}</td>
                                    <td>${kh.remindProducts}</td>
                                    <td>${kh.minPrice}</td>
                                    <td>
                                        <a href="/mua-hang/cart/view/chonSize/${kh.giay.id}"
                                           class="btn btn-outline-warning m-3">
                                            Chọn</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <%--       END Modal chọn san pham--%>

        <%--        Modal chọn size--%>
        <% boolean modalSize = (Boolean) request.getAttribute("modalSize"); %>
        <% if (modalSize) { %>
        <div class="modal fade" id="chonSize" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"
             data-bs-backdrop="static" data-bs-keyboard="false">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Danh sách sản phẩm</h5>
                        <a href="/mua-hang/cart/view" class="btn btn-primary">
                            Back
                        </a>
                    </div>
                    <div class="modal-body">
                        <div class="row m-3">
                            <div class="col-6">
                                <img src="/img/imgsProducts/${giayDistinct.hinhAnh.urlImg0}" alt="" height="400"
                                     width="300">
                            </div>
                            <div class="col-6">
                                <div class="container">
                                    <div class="row">
                                        <div class="text-left fs-2 fw-bolder">
                                            <label>${giayDistinct.giay.ten}</label>
                                        </div>
                                        <div class="text-left ">
                                            <label>Mã giày: ${giayDistinct.giay.ma}</label>
                                        </div>
                                        <div class="text-left ">
                                            <label>Thương hiệu: ${giayDistinct.nameBrand}</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="product__details__option">
                                            <div class="product__details__option__size">
                                                <span>Size :</span>
                                                <c:forEach items="${listSize}" var="size">
                                                    <a href="/mua-hang/cart/view/chonSize/${giayDistinct.giay.id}/${size.id}"
                                                       class="btn btn-light">${size.soSize}</a>
                                                </c:forEach>
                                            </div>
                                            <div class="mt-3">
                                                <form action="/mua-hang/cart/add" method="get">
                                                    <div class="product__details__option__color">
                                                        <span class="">Color :</span>
                                                        <c:forEach items="${listColor}" var="color">
                                                            <input type="button" class="m-2 color-option"
                                                                   style="background-color: ${color.mauSac.ten};
                                                                           width: 40px; height: 30px; display: inline-block; color: transparent;"/>
                                                            <input type="hidden" name="idChiTietGiay"
                                                                   value="${color.id}">
                                                        </c:forEach>
                                                    </div>
                                                    <div class="">
                                                        <span>Số lượng</span>
                                                        <input type="number" name="soLuong" value="1"
                                                               class="form-control"/>
                                                    </div>
                                                    <div class="mt-2">
                                                        <span>Có ${giayDistinct.remindProducts}</span>
                                                        <span>Sản phẩm có sẵn</span>
                                                    </div>

                                                    <button type="submit" class="btn btn-secondary btn-center mt-3">Thêm
                                                        giỏ hàng
                                                    </button>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        <%--       END Modal chọn size--%>


        <div class="col-10 offset-1 mt-3" style="background-color: #e5e5e5;">
            <div class="row mt-3">
                <div>
                    <a class="btn btn-secondary m-3" href="/mua-hang/cart/treo-hoa-don">Treo HĐ</a>
                    <a href="/" class="btn btn-success m-3" style="float:right">
                        Quet ma
                    </a>
                    <a class="btn btn-primary m-3" style="float: right" href="/mua-hang/cart/view/fullSP">
                        Thêm sản phẩm
                    </a>
                </div>
            </div>
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
                    <c:if test="${not empty sessionScope.error}">
                        <div class="error-message text-center text-dark">${sessionScope.error}</div>
                        <c:remove var="error" scope="session"/>
                    </c:if>
                    <c:forEach items="${gioHangChiTiet}" var="gh">
                        <tr>
                            <td>
                                <div class="row p-0">
                                    <div class="col-6">
                                        <img src="/img/imgsProducts/${gh.hinhAnh}" alt="" height="150" width="150">
                                    </div>
                                    <div class="col-6">
                                        <div class="fs-2 fw-bolder">${gh.tenGiay}</div>
                                        <div class="text-danger text-">${gh.giaBan} đ</div>
                                        <div class="">Size ${gh.size}</div>
                                    </div>
                                </div>
                            </td>
                            <td>${gh.soLuong}</td>
                            <td>${gh.soLuong * gh.giaBan}</td>
                            <td>
                                <a onclick="xacNhan(event)" class="btn"
                                   href="/mua-hang/cart/view/xoaGioHang/${gh.idChiTietGiay}">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" color="red" fill="currentColor"
                                         class="bi bi-archive-fill" viewBox="0 0 16 16">
                                        <path d="M12.643 15C13.979 15 15 13.845 15 12.5V5H1v7.5C1 13.845 2.021 15 3.357 15h9.286zM5.5 7h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1zM.8 1a.8.8 0 0 0-.8.8V3a.8.8 0 0 0 .8.8h14.4A.8.8 0 0 0 16 3V1.8a.8.8 0 0 0-.8-.8H.8z"/>
                                    </svg>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbdoy>
            </table>
            <hr class="bg-dark"/>
            <div class="text-dark m-3">Tổng tiền :${tongTien}</div>
        </div>

        <div class="col-10 offset-1 mt-3" style="background-color: #e5e5e5;">
            <div>
                <label class="fw-bold fs-3 m-3">Tài khoản</label>
                <button type="button" class="btn btn-primary m-3" style="float: right" data-bs-toggle="modal"
                        data-bs-target="#chonTaiKhoan">
                    Chọn tài khoan
                </button>
            </div>

            <div class="row m-3">
                <div class="">Tên Khách hang: ${khachHang.hoTen}</div>
                <div class="">SDT: ${khachHang.sdt}</div>
<%--                <div class="">Email: ${khachHang.email}</div>--%>
            </div>

            <%--modal chọn khách hàng--%>
            <div class="modal fade" id="chonTaiKhoan" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-body">
                            <form method="get" action="/mua-hang/cart/view/khach-hang">
                                <div class="row">
                                    <div class="col-4">
                                        <input name="keyword" class="form-control" type="text" placeholder="Tên hoặc SDT">
                                    </div>
                                    <div class="col-3">
                                        <button type="submit" class="btn btn-dark">Search</button>
                                    </div>
                                    <div class="col-2 offset-3" style="float:right">
                                        <a class="btn" href="/mua-hang/cart/view/khach-hang/viewAdd">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-add" viewBox="0 0 16 16">
                                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7Zm.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0Zm-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z"/>
                                                <path d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z"/>
                                            </svg>
                                        </a>
                                    </div>
                                </div>
                            </form>

                            <table class="table mt-3 text-center">
                                <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Họ tên</th>
                                    <th>SDT</th>
                                    <th>Trạng thái</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                </thead>
                                <tbdoy>
                                    <c:forEach items="${listkh}" var="kh">
                                        <tr>
                                            <td>${kh.ma}</td>
                                            <td>${kh.hoTen}</td>
                                            <td>${kh.sdt}</td>
                                            <td>${kh.trangThai==1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                                            <td>
                                                <a href="/mua-hang/chon-tai-khoan/${kh.id}"
                                                   class="btn btn-primary">Chọn</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbdoy>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <%--            END Moddal chọn kh--%>

            <%--        Modal chọn modalKhachHang--%>
            <% boolean modalKhachHang = (Boolean) request.getAttribute("modalKhachHang"); %>
            <% if (modalKhachHang) { %>
            <div class="modal fade" id="modalKhachHang" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"
                 data-bs-backdrop="static" data-bs-keyboard="false">
                <div class="modal-dialog modal-md" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Thêm khách hàng</h5>
                            <a href="/mua-hang/cart/view" class="btn btn-primary">
                                Back
                            </a>
                        </div>
                        <div class="modal-body">
                            <form:form action="/mua-hang/cart/view/khach-hang/addKhachHang" method="post" modelAttribute="kh">
                                <div class="row">
                                    <div class="col-6 offset-3">
                                        <div class="mt-3">
                                            <label>Tên</label>
                                            <form:input path="hoTen" class="form-control" type="text" name="tenKhachHang" placeholder="Nhập tên" />
                                            <form:errors element="hoTen" path="hoTen" cssClass="text-danger"/>
                                        </div>
                                        <div class="mt-3">
                                            <label>SĐT</label>
                                            <form:input path="sdt" class="form-control" type="text" name="sdtKhachHang" placeholder="Nhập sdt"/>
                                            <form:errors element="sdt" path="sdt" cssClass="text-danger"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-3 text-center">
                                    <button type="submit" class="btn btn-dark">Save</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
            <%--       END Modal chọn modalKhachHang--%>
        </div>

        <div class="col-10 offset-1 mt-3" style="background-color: #e5e5e5;">
            <div class="row">
                <label class="fw-bold fs-3 m-3">Thông tin thanh toán</label>
            </div>
            <hr class="bg-dark">
            <div class="row">
                <div class="col-7">

                </div>
                <div class="col-5">
                    <div>
                        <label>Hóa đơn: ${idHoaDon}</label>
                    </div>
                    <div>
                        <label>Tiền hàng: ${tongTien} đ</label>
                    </div>
                    <div>
                        <label>Giảm giá: 0 đ</label>
                    </div>
                    <div>
                        <label>Tổng tiền: ${tongTien} đ</label>
                    </div>
                    <div>
                        <a class="btn btn-dark mt-3" href="/mua-hang/cart/thanhtoan">Thanh toán</a>
                        <a class="btn btn-dark mt-3" href="">In hóa đơn</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
<script>
    // Kích hoạt modal khi trang được tải
    $(document).ready(function () {
        $('#chonSize').modal('show');
    });
</script>

<script>
    // Kích hoạt modal khi trang được tải
    $(document).ready(function () {
        $('#chonSanPham').modal('show');
    });
</script>

<script>
    // Kích hoạt modal khi trang được tải
    $(document).ready(function () {
        $('#modalKhachHang').modal('show');
    });
</script>
<script>
    function xacNhan(event) {
        var mes = confirm("Ban có chắc muốn xóa không");
        if (!mes) {
            event.preventDefault();
        }
    }
</script>
<style>
    /* Đặt chiều cao tối đa cho phần thân của modal */
    .modal-xl .modal-content {
        max-height: 650px; /* Bạn có thể điều chỉnh giá trị theo sở thích của mình */
    }

    /* Kích hoạt cuộn dọc cho phần thân của modal */
    .modal-xl .modal-body {
        overflow-y: auto;
    }
</style>
</body>
</html>
