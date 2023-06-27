<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form modelAttribute="hinhanh" method="post" action="/hinhanh/update/${hinhanh.id}">
    <p>Tên:
        <form:input path="Ten"/>
    </p>
    <p>Đường dẫn:
        <form:input path="DuongDan"/>
    </p>
    <p>
        Trạng thái:
        <form:radiobuttons path="TrangThai" items="${dsTrangThai}"/>
    </p>
    ${message}
    <button>Update</button>
</form:form>