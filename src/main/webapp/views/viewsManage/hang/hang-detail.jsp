<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div>
    <p>Id: ${hangDetail.id}</p>
    <p>Mã: ${hangDetail.ma}</p>
    <p>Tên: ${hangDetail.ten}</p>
    <p>Trạng thái:
        <c:if test="${hangDetail.trangThai == 1}">Hoạt động</c:if>
        <c:if test="${hangDetail.trangThai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/viewsManage/hang/index">Back</a>
</div>