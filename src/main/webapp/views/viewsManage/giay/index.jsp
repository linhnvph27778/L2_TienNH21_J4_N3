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
<div class="col-6 offset-3 mt-3">
    <div>
        <c:if test="${ not empty sessionScope.message }">
            <div class="alert alert-success text-center">${sessionScope.message}</div>
            <c:remove var="message" scope="session"/>
        </c:if>
    </div>
    <div class="col-4 offset-4 mt-4">
        <form action="/giay/search" method="get">
            <div class="mt-2">
                <label>Tìm kiếm</label>
                <input name="keyword" class="form-control" type="text" placeholder="Tên hoặc mã" aria-label="Tên hoặc mã">
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Search</button>
                <a class="btn btn-success" href="/giay/viewAdd">Add</a>
            </div>
        </form>
    </div>


    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
            <td>Mã</td>
            <td>Tên</td>
            <td>Trạng thái</td>
            <td colspan="2">Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list.content}" var="nv" >
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>${nv.trangThai}</td>
                    <td>
                        <a onclick="xacNhan(event)" href="/giay/delete/${nv.id}" class="btn btn-danger">Xoa</a>
                        <a href="/giay/viewUpdate/${nv.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
    <div class="mt-3">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                    <li class="page-item">
                        <a class="page-link" href="/giay/hien-thi?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count }
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>

</body>

<script>
    function xacNhan(event){
        var mes= confirm("Ban có chắc muốn xóa không");
        if (!mes){
            event.preventDefault();
        }
    }
</script>
</html>
