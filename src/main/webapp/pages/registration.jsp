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
        <form id="signup_form" action="${pageContext.request.contextPath}/action" method="post">
            <input type="hidden" name="command" value="registration"/>
            <table>
                <tr>
                    <td><fmt:message key="email"/></td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="password"/></td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="name"/></td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td><fmt:message key="phone"/></td>
                    <td><input type="text" name="phone"/></td>
                </tr>
            </table>
            <button type="submit">
                <fmt:message key="registrate"/>
            </button>
        </form>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/action?command=logout">
            <fmt:message key="logout"/>
        </a>
    </c:otherwise>
</c:choose>
<div class="container signin">
    <p>
        <fmt:message key="haveaccount"/>
        <a href="${pageContext.request.contextPath}/pages/login.jsp"><fmt:message key="login"/></a>.
    </p>
</div>

</body>
</html>