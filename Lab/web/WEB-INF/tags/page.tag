<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="false" rtexprvalue="true" type="java.lang.String" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Отель<c:if test="${not empty title}"> :: ${title}</c:if></title>
</head>
<body>
    <div>
    <c:if test="${not empty title}"><h1 style="background: yellowgreen">${title}</h1></c:if>
    <jsp:doBody/>
    </div>
</body>
</html>