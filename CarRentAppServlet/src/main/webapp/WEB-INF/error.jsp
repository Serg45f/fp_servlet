<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" isErrorPage="true"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CarRentApp</title>
</head>
    <body>
        <h2>
           Error Page<br/>
            <i>Error <%= exception %></i>
        </h2>

        <%-- this way we get the error information (error 404)--%>
        <c:set var="code" value="${requestScope['javax.servlet.error.status_code']}"/>
        <c:set var="message" value="${requestScope['javax.servlet.error.message']}"/>

        <%-- this way we get the exception --%>
        <c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>

        <c:if test="${not empty code}">
            <h3>Error code: ${code}</h3>
        </c:if>

        <c:if test="${not empty message}">
            <h3>Message: ${message}</h3>
        </c:if>

        <%-- if get this page using forward --%>
        <c:if test="${not empty errorMessage and empty exception and empty code}">
            <h3>Error message: ${errorMessage}</h3>
        </c:if>

        <%-- this way we print exception stack trace --%>
        <c:if test="${not empty exception}">
            <hr/>
            <h3>Stack trace:</h3>
            <c:forEach var="stackTraceElement" items="${exception.stackTrace}">
                ${stackTraceElement}
            </c:forEach>
        </c:if>


        <br>

    </body>
</html>