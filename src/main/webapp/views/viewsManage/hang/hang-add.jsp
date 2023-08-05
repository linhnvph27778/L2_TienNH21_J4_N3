<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form modelAttribute="hang" method="post" action="/viewsManage/hang/add">
    <p>Mã:
        <form:input path="Ma"/>
    </p>
    <p>Tên:
        <form:input path="Ten"/>
    </p>
    <p>
        Trạng thái:
        <form:radiobuttons path="TrangThai" items="${dsTrangThai}"/>
    </p>
    ${message}
    <button>Add</button>
</form:form>