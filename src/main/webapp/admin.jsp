<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html>
<head>
    <title>
        <fmt:message key="Admin"/>
    </title>
</head>
<body>
<c:choose>
    <c:when test="${empty admin}">
        <form action="${pageContext.request.contextPath}/action" method="post">
            <input type="hidden" name="command" value="adminLogin"/>
            <label>
                <input name="login" type="text" placeholder="<fmt:message key="login"/>"/>
            </label>
            <br>
            <label>
                <input name="password" type="password" placeholder="<fmt:message key="password"/>"/>
            </label>
            <br>${message}
            <br><br>
            <br>
            <button type="submit"><fmt:message key="login"/> </button>
        </form>
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
