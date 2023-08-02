<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
    <p>Id: ${hinhAnhDetail.id}</p>
    <p>Đường dẫn 0: ${hinhAnhDetail.urlImg0}</p>
    <p>Đường dẫn 1: ${hinhAnhDetail.urlImg1}</p>
    <p>Đường dẫn 2: ${hinhAnhDetail.urlImg2}</p>
    <p>Đường dẫn 3: ${hinhAnhDetail.urlImg3}</p>
    <p>Trạng thái:
        <c:if test="${hinhAnhDetail.trangThai == 1}">Hoạt động</c:if>
        <c:if test="${hinhAnhDetail.trangThai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/viewsManage/hinhanh/index">Back</a>
</div>