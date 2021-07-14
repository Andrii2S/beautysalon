<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="BeautySalon"/>
    </title>
</head>
<body>
<jsp:include page="/commons/menu.jsp"></jsp:include>

<c:choose>
<c:when test="${empty user.name}">
    <c:if test="${not empty message}">
    <h2>
        <br><fmt:message key="${message}"/>
    </h2>
    </c:if>
<form action="${pageContext.request.contextPath}/action" method="post">
    <input type="hidden" name="command" value="login"/>
    <label>
        <input name="email" type="text" placeholder="<fmt:message key="email"/>"/>
    </label>
    <br>
    <label>
        <input name="password" type="password" placeholder="<fmt:message key="password"/>"/>
    </label>
        <br><br>
    <br>
    <button type="submit"><fmt:message key="login"/> </button>
</form>
</c:when>
    <c:otherwise>
        <fmt:message key="already_logined"/>
        <a href="${pageContext.request.contextPath}/action?command=logout">
            <fmt:message key="logout" />
        </a>

    </c:otherwise>
</c:choose>
</body>
</html>