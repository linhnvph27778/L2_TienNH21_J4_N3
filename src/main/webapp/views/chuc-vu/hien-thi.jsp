<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body class="container">
<header>
    <h4 class="text-center mt-5 mb-5">Chuc vu</h4>
</header>
<main>
    <form action="/chuc-vu/add" method="post">
        <div class="mb-3 row">
            <label for="inputtext" class="col-sm-2 col-form-label">ma</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext" name="ma" value="${chucVu.ma}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext1" class="col-sm-2 col-form-label">ten</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext1" name="ten" value="${chucVu.ten}">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">trang thai</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="trangThai">
                    <option selected value="1" ${chucVu.trangThai == 0 ? "selected" : ""}>hoat dong</option>
                    <option value="0" ${chucVu.trangThai == 1 ? "selected" : ""}>khong hoat dong</option>

                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-success mt-5 mb-5">add</button>
    </form>
</main>
<table class="table table-bordered">
    <tr>
        <th>id</th>
        <th>ma</th>
        <th>ten</th>
        <th>trang thai</th>
        <th>action</th>
    </tr>

    <c:forEach items="${listChucVu}" var="cv">
        <tr>
            <td>${cv.id}</td>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>
            <td>${cv.trangThai}</td>

            <td>
                <a href="/chuc-vu/detail?id=${cv.id}">detail</a>
                <a href="/chuc-vu/delete?id=${cv.id}">delete</a>
                <a href="/chuc-vu/view-update?id=${cv.id}">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>