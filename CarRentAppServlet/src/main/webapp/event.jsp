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

<div class="container  text-white mt-6" style="background-image: url(resources/img/FONE_PB_GRAD.png);">

    <br/>
    <br/>
    <br/>

    <div class="event-group">
        <img src="resources/img/${event.picture}" class="event-group card-img-top" width="1200" height="400" alt="...">
    </div>

    <form class="event-group" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/tickets}" >
        <div class="col-lg-12 ml-6 event-group row" >
            <div class="event-group col-form-label row" >

                <h2 class="col-lg-6 text-transparent" type="text" name="description">
                    Tickets left: ${ticketsLeft}
                </h2>


                <h2 class="col-lg-4 col-form-label text-white">
                    Buy some:
                </h2>
                <input type="number" class="col-sm-2 event-group rounded" name="quantity" min="1"/>
            </div>
                <input type="hidden" class = "form-control" name="eventId" value="${event.id}"/>
            <%--
                <input type="hidden" class = "form-control" name="user" value="${ticket.user}" />
                <input type="hidden" class = "form-control" name="code" value="${ticket.code}" />
                <input type="hidden" class = "form-control" name="status" value="${ticket.status}" />
                <input type="hidden" class = "form-control" name="discount" value="${ticket.discount}" />
            --%>

                <a class="col-sm-2 mt-2 event-group" rounded>
                    <button type="submit" class="btn btn-primary">Reserve</button>
                </a>
            </div>
    </form>


    <div class="event-group col-bg-12 col-form-label">

        <h3 class="event-group ml-3" type="text" name="description" >
                ${event.description}

        </h3>

    </div>
    <div class="event-group col-bg-12 col-form-label row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.name" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.name}
        </h4>
    </div>
    <div class="event-group col-bg-12 col-form-label row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.place" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.place}
        </h4>
    </div>
    <div class="event-group row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.date" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.date}
        </h4>
    </div>
    <div class="event-group row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.time" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.time}
        </h4>
    </div>
    <div class="event-group row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.language" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.language}
        </h4>
    </div>
    <div class="event-group row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.price" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.price}
        </h4>
    </div>
    <div class="event-group row">
        <a class="event-group col-sm-3 mr-1">
            <fmt:message key="card.descr.description" bundle="${rb}"/>
        </a>
        <h4 class="event-group col-sm-7">
            ${event.description}
        </h4>
    </div>

    <div class="table-responsive-sm  table-hover mt-3">
        <table class="table text-white">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Theme</th>
                    <th scope="col">Lector</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lecture" items="${event.lectures}">
                    <tr>
                        <th>${lecture.name}</th>
                        <th>${lecture.theme}</th>
                        <th>${lecture.lector}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Add</button>
    </div>
</div>

</body>


</html>