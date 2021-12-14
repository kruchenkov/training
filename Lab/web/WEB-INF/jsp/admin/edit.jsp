<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<c:choose>
    <c:when test="${not empty user}">
        <c:set var="title" value="Редактирование пользователя ${user.login}"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Добавление пользователя"/>
    </c:otherwise>
</c:choose>

<u:page title="${title}">
    <c:url var="userSaveUrl" value="/user/save.jsp"/>
    <form action="${userSaveUrl}" method="post">
        <c:if test="${not empty user}">
            <input type="hidden" name="id" value="${user.id}">
        </c:if>
        Имя пользователя:<br>
        <input type="text" name="login" value="${user.login}"><br>
        <br>
        Пароль:<br>
        <input type="text" name="password" value="${user.password}"><br>
        <br>
        Роль:<br>
        <select name="role">
            <c:forEach var="role" items="${roles}">
                <c:choose>
                    <c:when test="${role == user.role}">
                        <c:set var="selected" value="selected"/>
                    </c:when>
                    <c:otherwise>
                        <c:remove var="selected"/>
                    </c:otherwise>
                </c:choose>
                <option value="${role}" ${selected}>${role.name}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <button type="submit">Сохранить</button>
    </form>
</u:page>