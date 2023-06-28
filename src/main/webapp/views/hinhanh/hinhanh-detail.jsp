<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
    <p>Id: ${hinhAnhDetail.id}</p>
    <p>Tên: ${hinhAnhDetail.ten}</p>
    <p>Đường dẫn: ${hinhAnhDetail.duongDan}</p>
    <p>Trạng thái:
        <c:if test="${hinhAnhDetail.trangThai == 1}">Hoạt động</c:if>
        <c:if test="${hinhAnhDetail.trangThai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/hinhanh/index">Back</a>
</div>