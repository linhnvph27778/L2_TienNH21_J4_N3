<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<style>
    body {
        background-color: #edf1f5;
        margin-top: 20px;
    }

    .card {
        margin-bottom: 30px;
    }

    .card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 0 solid transparent;
        border-radius: 0;
    }

    .card .card-subtitle {
        font-weight: 300;
        margin-bottom: 10px;
        color: #8898aa;
    }

    .table-product.table-striped tbody tr:nth-of-type(odd) {
        background-color: #f3f8fa !important
    }

    .table-product td {
        border-top: 0px solid #dee2e6 !important;
        color: #728299 !important;
    }
</style>
<div class="container">
    <div class="card">
        <div class="card-body">
            <h3 align="center" class="card-title">${ctgiayDetail.giay.ten}</h3>
            <h6 align="center" class="card-subtitle">Mã: ${ctgiayDetail.giay.ma}</h6>
            <div class="row">
                <div class="col-lg-5 col-md-5 col-sm-6">
                    <div class="white-box text-center"><img src="/img/imgsProducts/${ctgiayDetail.hinhAnh.urlImg0}"
                                                            class="img-responsive"></div>
                    <br>
                    <div align="center">
                        <a href="/chi-tiet-giay/viewUpdate/${kh.id}" class="btn btn-warning">Update</a>
                    </div>
                </div>
                <div class="col-lg-7 col-md-7 col-sm-6">
                    <h4 class="box-title mt-5">Product description</h4>
                    <p>${ctgiayDetail.giay.moTa}</p>
                    <h2 class="mt-5">
                        ${ctgiayDetail.giaBan} VNĐ<small class="text-success"></small>
                    </h2>
                    <%--<h3 class="box-title mt-5">Key Highlights</h3>
                    <ul class="list-unstyled">
                        <li><i class="fa fa-check text-success"></i>Sturdy structure</li>
                        <li><i class="fa fa-check text-success"></i>Designed to foster easy portability</li>
                        <li><i class="fa fa-check text-success"></i>Perfect furniture to flaunt your wonderful
                            collectibles
                        </li>
                    </ul>--%>
                    <h3 class="box-title mt-5">General Info</h3>
                    <div class="table-responsive">
                        <table class="table table-striped table-product">
                            <tbody>
                            <tr>
                                <td width="390">Hãng</td>
                                <td>${ctgiayDetail.hang.ten}</td>
                            </tr>
                            <tr>
                                <td>Màu Sắc</td>
                                <td>${ctgiayDetail.mauSac.ten}</td>
                            </tr>
                            <tr>
                                <td>Size</td>
                                <td>${ctgiayDetail.size.soSize}</td>
                            </tr>
                            <tr>
                                <td>Chất Liệu Thân Giày</td>
                                <td>${ctgiayDetail.chatLieuThanGiay.ten}</td>
                            </tr>
                            <tr>
                                <td>Chất Liệu Đế Giày</td>
                                <td>${ctgiayDetail.chatLieuDeGiay.ten}</td>
                            </tr>
                            <tr>
                                <td>Trọng Lượng</td>
                                <td>${ctgiayDetail.trongLuong}</td>
                            </tr>
                            <tr>
                                <td>Giá Nhập</td>
                                <td>${ctgiayDetail.giaNhap}</td>
                            </tr>
                            <tr>
                                <td>Năm Sản Xuất</td>
                                <td>${ctgiayDetail.namSanXuat}</td>
                            </tr>
                            <tr>
                                <td>Năm Bảo Hành</td>
                                <td>${ctgiayDetail.namBaoHanh}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>