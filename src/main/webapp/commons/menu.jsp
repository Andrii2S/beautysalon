<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" scope="session" value="${not empty sessionScope.language ? sessionScope.language : 'en'}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>
<h4>
    <a href="${pageContext.request.contextPath}/index.jsp">
        <fmt:message key="home"/>
    </a>
    <a href="${pageContext.request.contextPath}/action?command=listServices">
        <fmt:message key="services"/>
    </a>
    <a href="${pageContext.request.contextPath}/action?command=listMasters">
        <fmt:message key="masters"/>
    </a>
    <a href="${pageContext.request.contextPath}/action?command=loadSchedule">
        <fmt:message key="schedule"/>
    </a>
    <c:choose>
        <c:when test="${empty user.name}">
            <a href="${pageContext.request.contextPath}/pages/login.jsp">
                <fmt:message key="login"/>
            </a>
            <a href="${pageContext.request.contextPath}/pages/registration.jsp">
                <fmt:message key="registration"/>
            </a>
        </c:when>
        <c:otherwise>
            <fmt:message key="welcome"/>
            ${user.name}
            <a href="${pageContext.request.contextPath}/action?command=logout">
                <fmt:message key="logout"/>
            </a>
        </c:otherwise>
    </c:choose>
    <a href="${pageContext.request.contextPath}/action?command=changeLanguage&language=uk">
        UA
    </a>
    <a href="${pageContext.request.contextPath}/action?command=changeLanguage&language=en">
        EN
    </a>

</h4>