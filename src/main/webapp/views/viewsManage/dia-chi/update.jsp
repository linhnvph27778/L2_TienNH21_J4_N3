<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body class="container">
<header>
    <h4 class="text-center mt-5 mb-5"></h4>
</header>
<main>
    <form action="/dia-chi/update" method="post">
        <input type="hidden" class="form-control" id="inputtext7" name="id" value="${diaChi.id}">
        <div class="mb-3 row">
            <label for="inputtext" class="col-sm-2 col-form-label">xa</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext" name="xa" value="${diaChi.xa}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext1" class="col-sm-2 col-form-label">huyen</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext1" name="huyen" value="${diaChi.huyen}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext2" class="col-sm-2 col-form-label">thanh pho</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext2" name="thanhPho" value="${diaChi.thanhPho}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext3" class="col-sm-2 col-form-label">quoc gia</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext3" name="quocGia" value="${diaChi.quocGia}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext4" class="col-sm-2 col-form-label">ghi chu</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext4" name="ghiChu" value="${diaChi.ghiChu}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext5" class="col-sm-2 col-form-label">ten nguoi nhan</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext5" name="tenNguoiNhan" value="${diaChi.tenNguoiNhan}">
            </div>
        </div>

        <div class="mb-3 row">
            <label for="inputtext6" class="col-sm-2 col-form-label">sdt nhan</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputtext6" name="sdtNhan" value="${diaChi.sdtNhan}">
            </div>
        </div>

        <button type="submit" class="btn btn-success mt-5 mb-5">update</button>
    </form>
</main>
</body>
</html>