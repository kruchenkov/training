<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>
<u:page title="Список пользователей">
    <c:url var="userDeleteUrl" value="/user/delete.jsp"/>
    <form action="${userDeleteUrl}" method="post">
        <ul>
            <c:forEach var="user" items="${users}">
                <c:url var="editUserUrl" value="/user/edit.jsp">
                    <c:param name="id" value="${user.id}"/>
                </c:url>
                <li><input type="checkbox" name="id" value="${user.id}"><a href="${editUserUrl}">${user.login}</a> [${user.role.name}]</li>
            </c:forEach>
        </ul>
        <c:url var="editUserUrl" value="/user/edit.jsp"/>
        <a href="${editUserUrl}">Добавить нового пользователя</a><br>
        <button type="submit">Удалить пользователя</button>
    </form>
</u:page>

