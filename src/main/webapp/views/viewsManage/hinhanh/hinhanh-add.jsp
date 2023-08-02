<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<form:form modelAttribute="hinhanh" method="post" action="/viewsManage/hinhanh/add">
    <p>Đường dẫn 0: <form:input path="urlImg0" class="form-control form-control-sm" id="formFileSm" type="file"/>
    </p>
    <p>Đường dẫn 1: <form:input path="urlImg1" class="form-control form-control-sm" id="formFileSm" type="file"/>
    </p>
    <p>Đường dẫn 2: <form:input path="urlImg2" class="form-control form-control-sm" id="formFileSm" type="file"/>
    </p>
    <p>Đường dẫn 3: <form:input path="urlImg3" class="form-control form-control-sm" id="formFileSm" type="file"/>
    </p>
    <p>
        Trạng thái:
        <form:radiobuttons path="TrangThai" items="${dsTrangThai}"/>
    </p>
    ${message}
    <button>Add</button>
</form:form>