<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <p:form action="${action}" method="post" modelAttribute="d">
        <div>
            Mã:
            <p:input path="ma" />
        </div>
        <div>
            Tên:
            <p:input path="ten" />
        </div>

        <div>
            Trạng Thái:
            <p:input type="number" path="trangThai" />
        </div>

        <div><button type="submit">Submit</button></div>
    </p:form>
</body>
</html>