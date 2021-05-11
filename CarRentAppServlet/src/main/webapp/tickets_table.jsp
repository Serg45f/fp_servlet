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

    <br/>
    <br/>
    <br/>

<div class="container-md">
    <h2 class="mt-3 mb-3" >
        <fmt:message key="tickets.header" bundle="${rb}" />
    </h2>

    <br>
    <br>


    <div id="lectureTable" class="text-white ml-6  mb-3 mt-3">
        <table class="table table-bordered bg-transparent mt-3 round text-white" >
            <thead style="color: rgb(255,200,150); vertical-align: bottom;horizontal-align: center;">
            <tr>

                <th scope="col">
                    <fmt:message key="tickets.event.name" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.place" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.date" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.time" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.language" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.participant" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.price" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.quantity" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.totalSum" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.edit" bundle="${rb}" />
                </th>
                <th scope="col">
                    <fmt:message key="tickets.event.delete" bundle="${rb}" />
                </th>
            </tr>
            </thead >
            <tbody style="color: #ffffff; vertical-align: center;horizontal-align: right;">
            <c:forEach var="ticketsCount" items="${ticketsCounts}">
            <tr>
                <td>${ticketsCount.eventName}</td>
                <td>${ticketsCount.eventPlace}</td>
                <td>${ticketsCount.eventDate}</td>
                <td>${ticketsCount.eventTime}</td>
                <td>${ticketsCount.eventLanguage}</td>
                <td>
                    ${ticketsCount.userFirstName} ${ticketsCount.userLastName}
                </td>
                <td>${ticketsCount.eventPrice}</td>
                <td>${ticketsCount.tQuantity}</td>
                <td>${ticketsCount.eSum}</td>
                <td>
                    <a  class="text-success" href="/tickets/edit?eventId=${ticketsCount.eventId}">Edit</a>
                    <a>   </a>
                </td>

                <td><a class="text-danger" href="/tickets/delete?eventId=${ticketsCount.eventId}">Delete</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>