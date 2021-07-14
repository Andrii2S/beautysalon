<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="Manager"/>
    </title>
</head>
<body>
<c:choose>
    <c:when test="${empty admin}">
        <a href="pages/login.jsp">
            <fmt:message key="login" />
        </a>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/action?command=logout">
            <fmt:message key="logout" />
        </a>

    </c:otherwise>
</c:choose>
<form action="${pageContext.request.contextPath}/action" method="post">
    <button type="submit" name="language" value="en">EN</button>
    <button type="submit" name="language" value="uk">UA</button>
    <input type="hidden" name="command" value="changeLanguage"/>
</form>
</body>
</html>
