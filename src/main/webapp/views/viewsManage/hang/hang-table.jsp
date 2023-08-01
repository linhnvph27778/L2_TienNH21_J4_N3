<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--<a href="/phieugiaohang/sort">Sort</a>--%>
<table border="1" style="width:100%">
    <tr>
        <th>Id</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.ma}</td>
            <td>${item.ten}</td>
            <td>
                <c:if test="${item.trangThai == 0}">Không hoạt động</c:if>
                <c:if test="${item.trangThai == 1}">Hoạt động</c:if>
            </td>
            <td>
                <a href="javascript:remove('${item.id}')">Remove</a>
                <a href="/viewsManage/hang/view-update/${item.id}">Update</a>
                <a href="/viewsManage/hang/detail/${item.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    <%--    <c:if test="${page.totalElements == 0}">--%>
    <%--        <td colspan="7">Không có bản ghi nào</td>--%>
    <%--    </c:if>--%>
</table>
<%--<a href="/phieugiaohang/index?p=0&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">First</a>--%>
<%--<a href="/phieugiaohang/index?p=${page.number-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Prev</a>--%>
<%--<a href="/phieugiaohang/index?p=${page.number+1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Next</a>--%>
<%--<a href="/phieugiaohang/index?p=${page.totalPages-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Last</a>--%>
<%--<div>Trang hiện tại: ${page.number}</div>--%>
<%--<div>Tổng số trang: ${page.totalPages}</div>--%>
<%--<div>Tổng số bản ghi:${page.totalElements}</div>--%>
<script>
    function remove(id) {
        if (confirm('Bạn có muốn xóa?')) {
            location.href = "/viewsManage/hang/remove/" + id;
        }
    }
</script>