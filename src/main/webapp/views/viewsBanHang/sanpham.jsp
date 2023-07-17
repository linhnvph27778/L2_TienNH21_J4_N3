<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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

<div class="container">
    <div class="col-8 offset-2">
        <table class="table mt-3 text-center">
            <thead class="">
            <tr>
                <td>Ảnh</td>
                <td>Mã</td>
                <td>Tên</td>
                <td>Đơn giá</td>

                <td colspan="2">Action</td>
            </tr>
            </thead>
            <tbdoy>
                <c:forEach items="${list}" var="kh" >
                    <tr>
                        <td><img src="/img/imgsProducts/${kh.hinhAnh.urlImg0}" alt="" height="80" width="120"></td>
                        <td>${kh.giay.ma}</td>
                        <td>${kh.giay.ten}</td>
                        <td>${kh.giaBan}</td>
                        <td>
                            <a href="/mua-hang/cart/add?idChiTietGiay=${kh.id}" class="btn btn-secondary">Thêm giỏ hàng</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbdoy>
        </table>
    </div>
</div>

</body>
</html>
