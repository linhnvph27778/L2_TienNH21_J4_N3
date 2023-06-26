<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<div class="container">
    <div class="col-4 offset-3">
        <form method="get" action="">
            <div class="mt-3">
                <input name="keyword">
                <button type="submit">Search</button>
            </div>
        </form>

    </div>
    <div class="mt-3">
        <table>
            <thead>
            <tr>
                <%--                        <th>Mã phiếu giao</th>--%>
                <th>Người nhận</th>
                <th> SDT người nhận</th>
                <th>Ngày nhận</th>
                <th>Phí giao hàng</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="phieu">
                <tr>
                    <td>${phieu.ma}</td>
                    <td>${phieu.trangThai}</td>


                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
</body>
</html>