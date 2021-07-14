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
<form action="${pageContext.request.contextPath}/action" method="post">
    <input type="hidden" name="command" value="listSchedule"/>
    <label>
        <input name="date" type="date" placeholder="<fmt:message key="schedule.date"/>" required
               min="<%=java.time.LocalDate.now()%>" max="<%=java.time.LocalDate.now().plusDays(7)%>"/>
    </label>
        <label>
            <fmt:message key="schedule.choose_master"/>
        <select name="masterId" >
            </option>
            <c:forEach var="item1" items="${masters}">
            <option value=${item1.id} >${item1.name}</option>
            </c:forEach>
        </select>
        </label>

        <label>
            <fmt:message key="schedule.choose_service"/>
        <select name="serviceId" >
            </option>
            <c:forEach var="item2" items="${services}">
                <option value=${item2.id}>${item2.name}</option>
            </c:forEach>
        </select>
        </label>
    <button type="submit"><fmt:message key="Enter"/></button>
</form>
<c:if test="${not empty message}">
    <fmt:message key="${message}"/>
</c:if>
<form>
<c:if test="${not empty schedule}">
    <table>
        <thead>
        <tr>
            <td><fmt:message key="schedule.time" /></td>
            <td><fmt:message key="master.name" /></td>
            <td><fmt:message key="service.name" /></td>
            <td></td>
        </tr>
        </thead>

        <c:forEach var="item3" items="${schedule}">
            <tr>
                <td>${item3.time}</td>
                <td>${item3.masterName}</td>
                <td>${item3.serviceName}</td>
                <c:if test="${not empty user.id}">
                <td>
                    <form action="${pageContext.request.contextPath}/action" method="post">
                        <input type="hidden" name="command" value="bookAppointment"/>
                        <input type="hidden" name="scheduleId" value=${item3.id} />
                        <button type="submit"><fmt:message
                                key="schedule.reserve"/></button>
                    </form>
                </td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</c:if>
</form>

</body>
</html>
