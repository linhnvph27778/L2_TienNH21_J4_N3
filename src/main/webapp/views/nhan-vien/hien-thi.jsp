<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <h4 class="text-center mt-5 mb-5">Nhan Vien</h4>
</header>
<main>
    <form action="/nhan-vien/add" method="post">
        <div class="mb-3 row">
            <label for="inputtext" class="col-sm-2 col-form-label">ma</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext" name="ma" value="${nhanVien.ma}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext1" class="col-sm-2 col-form-label">ho ten</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext1" name="hoTen" value="${nhanVien.hoTen}">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">gioi tinh</label>
            <div class="col-sm-10">
                <input checked type="radio" name="gioiTinh" value="true" ${nhanVien.gioiTinh == true ? "checked" : ""}> Nam
                <input type="radio" name="gioiTinh" value="false" ${nhanVien.gioiTinh == false ? "checked" : ""}> Nu
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext2" class="col-sm-2 col-form-label">ngay sinh</label>
            <div class="col-sm-10">
                <fmt:formatDate value="${nhanVien.ngaySinh}" pattern="yyyy-MM-dd" var="formatDate"/>
                <input type="date" class="form-control" id="inputtext2" name="ngaySinh" value="${formatDate}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext3" class="col-sm-2 col-form-label">email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputtext3" name="email" value="${nhanVien.email}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext4" class="col-sm-2 col-form-label">sdt</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext4" name="sdt" value="${nhanVien.sdt}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext5" class="col-sm-2 col-form-label">dia chi</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext5" name="diaChi" value="${nhanVien.diaChi}">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">trang thai</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="trangThai">
                    <option selected value="1" ${nhanVien.trangThai == 1 ? "selected" : ""}>hoat dong</option>
                    <option value="0" ${nhanVien.trangThai == 0 ? "selected" : ""}>khong hoat dong</option>
                </select>
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext7" class="col-sm-2 col-form-label">mat khau</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputtext7" name="matKhau" value="${nhanVien.pass}">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">ma chuc vu</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="chucVu">
                    <c:forEach items="${listChucVu}"  var="cv">
                        <option value="${cv.id}" ${cv.id == nhanVien.chucVu.id ? "selected" : ""}>${cv.ma}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-success mt-5 mb-5">add</button>
    </form>

    <form action="/nhan-vien/search" method="get">
        <div class="mb-3 row">
            <label for="inputtext" class="col-sm-2 col-form-label">ma or hoTen</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext" name="keyWord">
            </div>
        </div>

        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">ma chuc vu</label>
            <div class="col-sm-10">
                <select class="form-select" aria-label="Default select example" name="chucVu">
                    <c:forEach items="${listChucVu}"  var="cv">
                        <option value="${cv.id}">${cv.ma}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <button type="submit" class="btn btn-success mt-5 mb-5">search</button>
    </form>
</main>

<table class="table table-bordered">
    <tr>
        <th>ma</th>
        <th>ho ten</th>
        <th>gioi tinh</th>
        <th>ngay sinh</th>
        <th>email</th>
        <th>sdt</th>
        <th>dia chi</th>
        <th>trang thai</th>
        <th>mat khau</th>
        <th>ma chuc vu</th>
    </tr>

    <c:forEach items="${listNhanVien}" var="nv">
        <tr>
            <td>${nv.ma}</td>
            <td>${nv.hoTen}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.email}</td>
            <td>${nv.sdt}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.trangThai}</td>
            <td>${nv.pass}</td>
            <td>${nv.chucVu.ma}</td>
            <td>
                <a href="/nhan-vien/detail?id=${nv.id}">detail</a>
                <a href="/nhan-vien/delete?id=${nv.id}">delete</a>
                <a href="/nhan-vien/view-update?id=${nv.id}">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>