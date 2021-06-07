<!DOCTYPE html>


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>

<%--
String getFormattedDate(){
SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
return sdf.format(new Date());
}
--%>


<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}">
<head>

    <title>ConferenceHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/css/style.css" type="text/css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/WEB-INF/parts/navbar.jsp" %>
<%--<c:import url="parts/navbar.jsp"/>--%>

<div class="container mt-6">
    <br/>
    <br/>
    <br/>
    <br>
    <H3>User editor</H3>

<form action="${pageContext.request.contextPath}/controller?command=user_save" method = "post">
    <input type="text" value="${editedUser.email}" name="email"/>
    <input type="text" value="${editedUser.firstName}" name="firstName"/>
    <input type="text" value="${editedUser.lastName}" name="lastName"/>
    <c:forEach var="role" items="${allRoles}">
        <div>
            <label>
                <input type="checkbox" value="${role.name()}" name="checkedRoles"
                     ${editedUser.roles.contains(role) ? 'checked="checked"' : ''}/>
                ${role.name()}  Role
             </label>
        </div>
    </c:forEach>

    <input type="hidden" value="${editedUser.getId()}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type = "submit">Save</button>
</form>


</div>
</body>
</html>



