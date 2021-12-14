<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>
<u:page title="Список админов">
    <c:url var="adminDeleteUrl" value="/user/delete.jsp"/>
    <form action="${adminDeleteUrl}" method="post">
        <ul>
            <c:forEach var="admin" items="${admins}">
                <c:url var="editAdminUrl" value="/user/edit.jsp">
                    <c:param name="id" value="${admin.id}"/>
                </c:url>
                <li><input type="checkbox" name="id" value="${admin.id}"><a href="${editAdminUrl}">${admin.lastName}</a><a href="${editAdminUrl}">${admin.id}</a></li>
            </c:forEach>
        </ul>
        <c:url var="editAdminUrl" value="/user/edit.jsp"/>
        <a href="${editUserUrl}">Добавить нового пользователя</a><br>
        <button type="submit">Удалить пользователя</button>
    </form>
</u:page>

