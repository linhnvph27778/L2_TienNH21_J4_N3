<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<header>
    <title>Chi Tiet Giay</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</header>
<body>
<div class="container">
    <div class="col-8 offset-2 mt-3">
        <sf:form action="${action}" method="post" modelAttribute="chiTietGiay">
            <div class="row">
                <div class="col-6 mt-3">
                    <div class="mt-3">
                        <label>Năm Bảo hành</label>
                        <sf:input path="namBaoHanh" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="namBaoHanh" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>Năm sản xuất</label>
                        <sf:input path="namSanXuat" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="namSanXuat" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>Trọng lượng</label>
                        <sf:input path="trongLuong" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="trongLuong" element="span"/>
                    </div>

                </div>
                <div class="col-6 mt-3">
                    <div class="mt-3">
                        <label>Giá nhập</label>
                        <sf:input path="giaNhap" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="giaNhap" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>Giá bán</label>
                        <sf:input path="giaBan" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="giaBan" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>soLuongTon</label>
                        <sf:input path="soLuongTon" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="soLuongTon" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>Mô tả</label>
                        <sf:input path="moTa" cssClass="form-control"/>
                        <sf:errors cssClass="text-danger" path="moTa" element="span"/>
                    </div>
                    <div class="mt-3">
                        <label>Trạng thái</label>
                        <sf:radiobutton path="trangThai" value="1" cssClass="form-check-input"/>Đang bán
                        <sf:radiobutton path="trangThai" value="0" cssClass="form-check-input"/>Ngừng bán
                        <sf:errors cssClass="text-danger" path="trangThai" element="span"/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="mt-3">
                    <label>Giày</label>
                    <sf:select path="giay.id" cssClass="form-select">
                        <c:forEach items="${giay}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Hình ảnh</label>
                    <sf:select path="hinhAnh.id" cssClass="form-select">
                        <c:forEach items="${hinhAnh}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Chất liệu đế giày</label>
                    <sf:select path="chatLieuDeGiay.id" cssClass="form-select">
                        <c:forEach items="${chatLieuDeGiay}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Chất liệu thân giày</label>
                    <sf:select path="chatLieuThanGiay.id" cssClass="form-select">
                        <c:forEach items="${chatLieuThanGiay}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Hãng</label>
                    <sf:select path="hang.id" cssClass="form-select">
                        <c:forEach items="${hang}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Màu sắc</label>
                    <sf:select path="mauSac.id" cssClass="form-select">
                        <c:forEach items="${mauSac}" var="kh">
                            <sf:option value="${kh.id}">${kh.ten}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
                <div class="mt-3">
                    <label>Size</label>
                    <sf:select path="size.id" cssClass="form-select">
                        <c:forEach items="${size}" var="kh">
                            <sf:option value="${kh.id}">${kh.soSize}</sf:option>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>

            <div class="mt-3 offset-4">
                <button type="submit" class="btn btn-success">Add</button>
            </div>
        </sf:form>
    </div>

</div>
</body>
</html>