<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*, java.lang.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>


<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>CONFERENCEHUB#1</title>
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
<c:import url="navbar.jsp"/>
<div class="container mt-6">
    <br/>
    <br/>
    <br/>





<br>
<br>
<div class="container">

    <h2 class="mt-3" >
        <fmt:message key="tickets.header" bundle="${rb}" />
    </h2>

    <br>
    <br>


    <div class="card-columns" >

        <c:forEach var="ticket" items="${tickets}">
            <div class="card bg-transparent text-white  mb-3 "  >
                <div class="row no-gutters">
                    <img src="resources/img/${event.picture}" class="card-img-top" width="300" height="187" alt="...">
                    <div class="col-md-12">
                        <div class="card-body">
                            <h5 class="card-title">
                                <fmt:message key="card.descr.name" bundle="${rb}"/>
                                ${ticket.event.name}
                            </h5>
                            <p class="card-text">
                                <fmt:message key="card.descr.code" bundle="${rb}"/>
                                <small>${ticket.code}</small>
                            </p>
                            <p class="card-text">
                                <fmt:message key="card.descr.place" bundle="${rb}"/>
                                <small>${ticket.event.place}</small>
                            </p>
                            <p class="card-text"  type="date">
                                <fmt:message key="card.descr.date" bundle="${rb}"/>
                                <small>${ticket.event.date}</small>
                            </p>
                            <p class="card-text" type="time">
                                <fmt:message key="card.descr.time" bundle="${rb}"/>
                                <small>${ticket.event.time}</small>
                            </p>
                            <p class="card-text">
                                <fmt:message key="card.descr.language" bundle="${rb}"/>
                                <small>${ticket.event.language}</small>
                            </p>
                            <p class="card-text text-sm">
                                <fmt:message key="card.descr.user.firstName" bundle="${rb}"/>
                                <small>${ticket.user.firstName}</small>
                            </p>
                            <p class="card-text text-sm">
                                <fmt:message key="card.descr.user.lastName" bundle="${rb}"/>
                                <small>${ticket.user.lastName}</small>
                            </p>
                            <div class="card-footer">
                                <fmt:message key="card.descr.price" bundle="${rb}"/>
                                <b>${ticket.event.price}</b>
                            </div>

                            <a href="/events/${event.id}" class="btn btn-transparent btn-outline-primary" >Open</a>

                            <c:if test = "${userRoles.contains(roles[\"USER\"])}">
                            <a  href="/tickets/buy/${event.id}" class="btn btn-transparent btn-outline-success" >Buy</a>
                            <a  href="/tickets/delete/${event.id}" class="btn btn-transparent btn-outline-danger" >Delete</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:import url="pagination.jsp"/>
</div>
</div>
</body>
</html>
