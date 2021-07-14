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
<h2>
    500
    <br>
    <fmt:message key="error.500" />
</h2>
</body>
</html>
