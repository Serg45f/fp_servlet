<!DOCTYPE html>


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>

<%!
String getFormattedDate(){
SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
return sdf.format(new Date());
}
%>

<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}">
<head>

    <title>ConferenceHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="resources/style.css" type="text/css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="parts/navbar.jsp"/>
<div class="container mt-6">

    <h2 class="mt-3" >
        <fmt:message key="users.header" bundle="${rb}" />
    </h2>
<table class="table table-striped table-bordered table-responsive-sm  table-hover mt-3 round">
    <tr>
        <th>
            <fmt:message key="users.th.login" bundle="${rb}" />
        </th>
        <th>
            <fmt:message key="users.th.name" bundle="${rb}" />
        </th>
        <th>
            <fmt:message key="users.th.lastName" bundle="${rb}" />
        </th>
        <th>
            <fmt:message key="users.th.roles" bundle="${rb}" />
        </th>
        <th>
            <fmt:message key="users.th.edit" bundle="${rb}" />
        </th>
        <th>
            <fmt:message key="users.th.delete" bundle="${rb}" />
        </th>

    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    <p>${role.getRole()}</p>
                </c:forEach>
            </td>
            <td>
                <a class="text-success" href="${pageContext.request.contextPath}/user_edit?id=${user.id}">Edit</a>
            </td>
            <td>
                <a class="text-danger" href="${pageContext.request.contextPath}/user_delete?id=${user.id}">Delete</a>
            </td>


    </c:forEach>
</table>
<br>
<br/>
<c:import url="pagination.jsp"/>
</div>
</body>
</html>

