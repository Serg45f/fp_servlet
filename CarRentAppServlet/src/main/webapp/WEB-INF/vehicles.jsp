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

<c:import url="/WEB-INF/parts/navbar.jsp"/>
<br/>
<%--
    <div class="form-row">
        <div class="form-group mt-2 col-md-6">
            <form method="get" action="${pageContext.request.contextPath}/vehicles" class="form-inline">
                <input type="text" name="filter" class="form-control bg-transparent" value="${filter?:''}" placeholder="Find by date" >
                <button type="submit" class="btn btn-transparent btn-outline-primary ml-2" >Find</button>
            </form>
        </div>
    </div>

        <br/>

--%>
        <br/>
        <div class="container">
            <h2 class="mt-3 " >
                <fmt:message key="vehicles.header" bundle="${rb}"/>
            </h2>

            <c:if test = "${loggedUserRoles.contains(roles['ADMIN'])}">
                <p>
                    <a href="${pageContext.request.contextPath}/controller?command=vehicle_add" class="btn btn-transparent btn-outline-success col-sm-12 px-0">
                        <fmt:message key="btn.new" bundle="${rb}"/>
                    </a>
                </p>
            </c:if>

            <div class="card-rows" id="each">
                <c:forEach var="vehicle" items="${vehicles}">

                    <div class="card  mb-3 " style="background-color: rgba(255,255,255,0.6);max-width: 1200px;">
                        <div class="row g-0">
                            <div class="col-md-4">
                                <img src="resources/img/${vehicle.carModel.picture}" class="card-img-top" alt="...">  <!--class="card-img-top"  width="200" height="150"-->
                            </div>
                            <div class="col-md-8">
                                <div class="card-body row">
                                    <div class="col-md-8">
                                        <h4 class="card-title">
                                            ${vehicle.carModel.name}
                                        </h4>
                                        <p class="card-text">
                                            <fmt:message key="card.model.descr.seats" bundle="${rb}"/>
                                            <small>${vehicle.carModel.seatsNumb}</small>
                                        </p>
                                        <p class="card-text">
                                            <fmt:message key="card.model.descr.doors" bundle="${rb}"/>
                                            <small>${vehicle.carModel.doorsNumb}</small>
                                        </p>
                                        <p class="card-text">
                                            <fmt:message key="card.model.descr.type" bundle="${rb}"/>
                                            <small>${vehicle.carModel.type}</small>
                                        </p>
                                        <p class="card-text">
                                            <fmt:message key="card.model.descr.status" bundle="${rb}"/>
                                            <small>${vehicle.carModel.status}</small>
                                        </p>
                                        <p class="card-text">
                                            <fmt:message key="card.vehicle.descr.color" bundle="${rb}"/>
                                            <small>${vehicle.color}</small>
                                        </p>
                                        <p class="card-text">
                                            <fmt:message key="card.vehicle.descr.transmission" bundle="${rb}"/>
                                            <small>${vehicle.transmission}</small>
                                        </p>
                                    </div>
                                    <div class="col-md-4">
                                        <h4 class="card-title" style="color: rgba(51,51,51,0.9);">
                                            <fmt:message key="card.descr.price" bundle="${rb}"/>
                                            <b>${vehicle.carModel.price * (100 - vehicle.discount)/100}</b>
                                        </h4>
                                        <p>
                                            <a href="${pageContext.request.contextPath}/controller?command=setOptions&vehicleId=${vehicle.id}" to="3" class="btn btn-transparent btn-outline-primary col-sm-12 px-0" >Choose</a>
                                        </p>
                                        <c:if test = "${loggedUserRoles.contains(roles['ADMIN'])}">
                                            <p>
                                                <a href="${pageContext.request.contextPath}/controller?command=vehicle_edit&vehicleId=${vehicle.id}" class="btn btn-transparent btn-outline-success col-sm-12 px-0" >Edit</a>
                                            </p>
                                            <p>
                                                <a  href="${pageContext.request.contextPath}/controller?command=vehicle_delete&vehicleId=${vehicle.id}" class="btn btn-transparent btn-outline-danger col-sm-12 px-0" >Delete</a>
                                            </p>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>

                    <c:if test="${vehicles != null}" >
                        <%@ include file="/WEB-INF/parts/pagination.jsp" %>
                        <%--<c:import url="pagination.jsp"/>--%>
                    </c:if>
            </div>
            </div>
        </div>
</body>





</html>