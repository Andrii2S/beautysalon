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
<table>
    <tr>
        <th><fmt:message key="service.name"/></th>
        <th><fmt:message key="service.description"/></th>
        <th><fmt:message key="service.time_taken"/></th>
    </tr>
    <c:forEach var="item" items="${services}">
        <tr>
            <th>${item.name}</th>
            <th>${item.description}</th>
            <th>${item.time}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>