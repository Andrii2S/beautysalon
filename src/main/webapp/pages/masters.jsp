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
        <th><fmt:message key="master.name" /></th>
        <th><fmt:message key="master.description" /></th>
        <th><fmt:message key="master.rating" /></th>
    </tr>
    <c:forEach var="item" items="${masters}">
        <tr>
            <th>${item.name}</th>
            <th>${item.information}</th>
            <th>${item.rating}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
