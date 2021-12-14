<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:page title="Авторизация">
    <c:if test="${not empty param.message}">
    <p style="color: red;">${param.message}</p>
    </c:if>
    <c:url var="loginUrl" value="/login.jsp"/>
    <form action="${loginUrl}" method="post">
        Имя пользователя:<br>
        <input type="text" name="login"><br>
        <br>
        Пароль:<br>
        <input type="password" name="password"><br>
        <br>
        <button type="submit">Войти</button>
    </form>
</u:page>