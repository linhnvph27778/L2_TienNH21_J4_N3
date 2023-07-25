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
            <nav class="navbar navbar-expand-lg " style="background-color: #e3f2fd;">
                <a class="btn" href="/mua-hang/cart">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
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
                                    <a href="/mua-hang/cart/hoadon/${hd.id}" >
                                            ${hd.ma}
                                    </a>
                                </label>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>
        </div>

        <%--        Modal chọn san pham--%>
        <% boolean modalFullSP = (Boolean) request.getAttribute("modalFullSP"); %>
        <% if (modalFullSP) { %>
        <div class="modal fade" id="chonSanPham" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <form method="get" action="/mua-hang/cart/view/timKiem">
                        <div class="row">
                        <div class="col-6">
                            <div class="row">
                                <div class="col-6">
                                    <label>Giày</label>
                                    <input name="keyword" class="form-control" type="text" placeholder="Tên hoặc mã" aria-label="Tên hoặc mã">
                                </div>
                                <div class="col-3">
                                    <label>giá min</label>
                                    <input name="giaMin" class="form-control" type="number">
                                </div>
                                <div class="col-3">
                                    <label>giá max</label>
                                    <input name="giaMax" class="form-control" type="number">
                                </div>
                            </div>
                        </div>
                        <div class="col-6 mt-4">
                            <button type="submit" class="btn btn-primary" style="float:left">Search</button>
                            <a href="/mua-hang/cart/view" class="btn btn-primary " style="float:right">
                                Back
                            </a>
                        </div>
                        </div>
                    </form>
                    <div class="modal-body">
                        <table class="table mt-3 text-center">
                            <thead class="">
                            <tr>
                                <td>Ảnh</td>
                                <td></td>
                                <td>Mã</td>
                                <td>Tên</td>
                                <td>Tổng kho</td>
                                <td>Giá thấp nhất</td>
                                <td>Action</td>
                            </tr>
                            </thead>
                            <tbody>
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
                                           class="btn btn-primary m-3">
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
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Danh sách sản phẩm</h5>
                        <a href="/mua-hang/cart/view" class="btn btn-primary">
                            Back
                        </a>
                    </div>
                    <div class="modal-body">
                        <table class="table mt-3 text-center">
                            <thead class="">
                            <tr>
                                <td>Sản phẩm</td>
                                <td>Size</td>
                                <td>Tên</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listSize}" var="kh">
                                <tr>
                                    <td><img src="/img/imgsProducts/${kh.hinhAnh.urlImg0}" alt="" height="100"
                                             width="100"></td>
                                    <td>${kh.size.soSize}</td>
                                    <td>${kh.giay.ten}</td>
                                    <td>
                                        <a href="/mua-hang/cart/add?idChiTietGiay=${kh.id}"
                                           class="btn btn-secondary">Thêm giỏ hàng</a>
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
        <%--       END Modal chọn size--%>


        <div class="col-10 offset-1 mt-3" style="background-color: #e5e5e5;">
            <div>
                <c:if test="${ not empty sessionScope.message }">
                    <div class="alert alert-success text-center">${sessionScope.message}</div>
                    <c:remove var="message" scope="session"/>
                </c:if>
            </div>
            <div class="row mt-3">
                <div>
                    <a class="btn btn-secondary m-3" href="/mua-hang/cart/treo-hoa-don">Treo HĐ</a>
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
                                <a class="btn btn-danger" href="/">Xóa khỏi giỏ</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbdoy>
            </table>
            <hr class="bg-dark"/>
            <div class="text-dark m-3">Tổng tiền :${tongTien}</div>
        </div>

        <div class="col-10 offset-1 mt-3" style="background-color: #e5e5e5 ">
            <div>
                <label class="fw-bold fs-3 m-3">Tài khoản</label>
                <button type="button" class="btn btn-primary m-3" style="float: right" data-bs-toggle="modal"
                        data-bs-target="#chonTaiKhoan">
                    Chọn tài khoan
                </button>
            </div>

            <div class="row m-3">
                <div class="">Tên Khách hang: ${hoTen}</div>
                <div class="">SDT: ${sdt}</div>
                <div class="">Email: ${email}</div>
            </div>

            <%--modal chọn khách hàng--%>
            <div class="modal fade" id="chonTaiKhoan" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-body">
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

<style>
    /* Đặt chiều cao tối đa cho phần thân của modal */
    .modal-xl .modal-content {
        max-height: 600px; /* Bạn có thể điều chỉnh giá trị theo sở thích của mình */
    }

    /* Kích hoạt cuộn dọc cho phần thân của modal */
    .modal-xl .modal-body {
        overflow-y: auto;
    }
</style>
</body>
</html>
