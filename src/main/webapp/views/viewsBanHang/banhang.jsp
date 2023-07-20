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

        <a class="btn btn-primary" href="/mua-hang/cart">Tạo hóa đơn</a>
        <%--        Modal chọn san pham--%>
        <div class="modal fade" id="chonSanPham" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <table class="table mt-3 text-center">
                            <thead class="">
                            <tr>
                                <td>Ảnh</td>
                                <td></td>
                                <td>Tên</td>
                                <td>Tổng kho</td>
                                <td>Giá thấp nhất</td>
                                <td colspan="2">Action</td>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listChonSanPham}" var="kh">
                                    <tr>
                                        <td><img src="/img/imgsProducts/${kh.hinhAnh.urlImg0}" alt="" height="90"
                                                 width="100"><td>
                                        <td>${kh.giay.ten}</td>
                                        <td>${kh.remindProducts}</td>
                                        <td>${kh.minPrice}</td>
                                         <td>
                                             <a href="/mua-hang/cart/view/chonSize/${kh.giay.id}" class="btn btn-primary m-3">
                                            Chọn</a>
                                             </c:forEach>

                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%--       END Modal chọn san pham--%>

        <%--        Modal chọn size--%>
        <% boolean modalSize = (Boolean) request.getAttribute("modalSize"); %>
        <% if (modalSize) { %>
        <div class="modal fade" id="chonSize" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="static" data-bs-keyboard="false">
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Danh sách sản phẩm</h5>
                        <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
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


        <div class="col-8 offset-2" style="background-color: #e5e5e5; border: #007bff 10px">
            <div>
                <button type="button" class="btn btn-primary m-3" data-bs-toggle="modal"
                        data-bs-target="#chonSanPham">
                    Thêm sản phẩm
                </button>
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
            <hr/>
            <div class=pull-right">Tổng tiền :${tongTien}</div>
        </div>

        <div class="col-8 offset-2 mt-5" style="background-color: #e5e5e5 ">
            <div>
                <button type="button" class="btn btn-primary m-3" data-bs-toggle="modal"
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
    $(document).ready(function() {
        $('#chonSize').modal('show');
    });
</script>
</body>
</html>
