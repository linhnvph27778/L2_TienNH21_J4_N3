<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <p:form action="${action}" method="post" modelAttribute="d">

        <div>
            Trạng Thái:
            <p:input type="number" path="trangThai" />
        </div>

        <div>
            <p:select path="dotKhuyenMai">
                <c:forEach items="${dskm}" var="a">
                    <p:option value="${a.id}">${a.tenKhuyenMai}</p:option>
                </c:forEach>
            </p:select>
        </div>
        <div>
            <p:select path="chiTietGiay">
                <c:forEach items="${dsgiay}" var="a">
                    <p:option value="${a.id}">${a.ten}</p:option>
                </c:forEach>
            </p:select>
        </div>
        <div><button type="submit">Submit</button></div>
    </p:form>
</body>
</html>