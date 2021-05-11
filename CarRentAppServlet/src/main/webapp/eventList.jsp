<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Events List</title>
</head>
    <body>
        <h2>
            Events list <br/>
        </h2>
        <table>
        <tr>
            <th>Name</th>
<!--            <th>Language</th>-->
<!--            <th>Place</th>-->
            <th>Description</th>
            <th>Date</th>
            <th>Time</th>
            <th>Price</th>
        </tr>
        <c:forEach var="i" items="${events}">
            <tr>
                <td>${i.name}</td>
<!--                <td>${i.language}</td>-->
<!--                <td>${i.place}</td>-->
                <td>${i.description}</td>
                <td>${i.date}</td>
                <td>${i.time}</td>
                <td>${i.price}</td>

        </c:forEach>
        </table>
        <br>
        <br>
<!--        <%=request.getAttribute("events")%>-->
        <br>
<!--        <c:out value="${events}"/>-->



        <br/>
        <a href="./index.jsp">index</a>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">index</a>
    </body>
</html>
