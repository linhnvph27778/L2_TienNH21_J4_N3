<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <p:form action="${action}" method="post" modelAttribute="d">
        <div>
            Mã:
            <p:input path="maKhuyenMai" />
        </div>
        <div>
            Tên:
            <p:input path="tenKhuyenMai" />
        </div>
        <div>
            Ngày BĐ:
            <p:input type="date" path="ngayBatDau" />
        </div>
        <div>
            Ngày KT:
            <p:input type="date" path="ngayKetThuc" />
        </div>
        <div>
            Trạng Thái:
            <p:input type="number" path="trangThai" />
        </div>
        <div>
            Số lượng:
            <p:input type="number" path="soLuong" />
        </div>
        <div>
            Phần Trăm:
            <p:input type="number" path="phanTram" />
        </div>
        <div>
            Giá tiền giảm:
            <p:input type="number" path="giaTienGiam" />
        </div>
        <div>
            loại khuyến mãi:
            <p:input path="loaiKhuyenMai" />
        </div>
        <div>
            Mô tả:
            <p:input path="moTa" />
        </div>
        <div><button type="submit">Submit</button></div>
    </p:form>
</body>
</html>