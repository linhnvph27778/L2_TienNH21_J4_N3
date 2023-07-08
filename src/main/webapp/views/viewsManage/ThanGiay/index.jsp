<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>QLTG</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">QUẢN LÍ Thân GIÀY</h1>
<div class="container">
    <div>
        <a class="btn btn-primary" href="/than-giay/create">Them Moi</a>
    </div>
    <br>
    <table class="table table-bordered">
        <thead>
        <tr style="background-color: aqua">
            <td>Mã</td>
            <td>Tên</td>
            <td>Trạng Thái</td>
            <td colspan="2">Thao tác</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${QLTG}" var="tg">
            <tr>
                <td>${tg.ma}</td>
                <td>${tg.ten}</td>
                <td>${tg.trangThai == 0 ? "Còn Hàng" : "Hết Hàng"}</td>
                <td><a class="btn btn-danger" href="/than-giay/delete/${tg.id}">Xóa</a></td>
                <td><a class="btn btn-info" href="/than-giay/edit/${tg.id}">Sửa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
</body>
</html>