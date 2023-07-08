<%@ page pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<header>
    <title>Loại khach hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</header>
<body>
<div class="container">
    <div class="col-4 offset-4 mt-3">
        <sf:form action="${action}" method="post" modelAttribute="khachHang">
            <div class="mt-3">
                <label>Mã KH</label>
                <sf:input path="ma" cssClass="form-control"/>
                <sf:errors cssClass="text-danger" path="ma" element="span"/>
                <span class="text-danger">${maTrung}</span>
            </div>
            <div class="mt-3">
                <label>Tên</label>
                <sf:input path="hoTen" cssClass="form-control"/>
                <sf:errors cssClass="text-danger" path="hoTen" element="span"/>
            </div>
            <div class="mt-3">
                <label>Ngày sinh</label>
                <sf:input path="ngaySinh" cssClass="form-control" type="Date"/>
                <sf:errors cssClass="text-danger" path="ngaySinh" element="span"/>
            </div>
            <div class="mt-3">
                <label>email</label>
                <sf:input path="email" cssClass="form-control" type="Email" />
                <sf:errors cssClass="text-danger" path="email" element="span"/>
            </div>
            <div class="mt-3">
                <label>sdt</label>
                <sf:input path="sdt" cssClass="form-control"/>
                <sf:errors cssClass="text-danger" path="sdt" element="span"/>
            </div>
            <div class="mt-3">
                <label>Trang Thai</label>
                <sf:radiobutton path="trangThai" value="1" checked="true"/>Đang sử dụng
                <sf:radiobutton path="trangThai" value="0"/>Hết hạn
                <sf:errors cssClass="text-danger" path="trangThai" element="span"/>
            </div>
            <div class="mt-3">
                <label>pass</label>
                <sf:input path="pass" cssClass="form-control"/>
                <sf:errors cssClass="text-danger" path="pass" element="span"/>
            </div>
            <div class="mt-3">
                <label>Số lần mua</label>
                <sf:input path="soLanMua" cssClass="form-control"/>
                <sf:errors cssClass="text-danger" path="soLanMua" element="span"/>
            </div>
            <div class="mt-3">
                <label>Loại khách hàng</label>
                <sf:select path="loaiKhachHang.id" cssClass="form-select">
                    <c:forEach items="${listLKH}" var="kh">
                        <sf:option value="${kh.id}">${kh.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>

            <div class="mt-3 offset-4">
                <button type="submit" class="btn btn-success">Add</button>
            </div>
        </sf:form>
    </div>

</div>
</body>
</html>