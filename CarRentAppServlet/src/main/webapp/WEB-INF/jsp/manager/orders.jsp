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

    <title>CarRentLtd</title>
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
    <br>
    <br>
    <br>
<div class="container-flex" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">

                        <div id="ordersTable" class="table-responsive-sm  table-hover mt-3">
                            <table class="table table-responsive-sm  table-hover mt-3 round" >
                                <thead>
                                <tr>
                                    <th scope="col">
                                        <fmt:message key="orders.th.id" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.picture" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.carName" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.carId" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.regNumb" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.start" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.finish" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.realFinish" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.status" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.damage" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.damagePrice" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.damagePayed" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.edit" bundle="${rb}" />
                                    </th>
                                    <th scope="col">
                                        <fmt:message key="orders.th.delete" bundle="${rb}" />
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="order" items="${orders}">
                                    <tr>
                                        <td>${order.id}</td>
                                        <td>
                                            <img src="resources/img/${order.vehicle.carModel.picture}" width="80" hight="50"  alt="...">
                                        </td>
                                        <td>${order.vehicle.carModel.name}</td>
                                        <td>${order.vehicle.id}</td>
                                        <td>${order.vehicle.regNumber}</td>
                                        <td>${order.start}</td>
                                        <td>${order.end}</td>
                                        <td>${order.realEnd}</td>
                                        <td>${order.status}</td>
                                        <td>${order.damageDescript}</td>
                                        <td>${order.damagePrice}</td>
                                        <td>${order.damageIsPayed}</td>
                                        <td>
                                            <a class="btn btn btn-transparent btn-outline-primary" href="${pageContext.request.contextPath}/controller?command=order_edit&orderId=${order.id}">Process</a>
                                            <a>   </a>
                                        </td>
                                        <td><a class="btn btn-transparent btn-outline-danger" href="${pageContext.request.contextPath}/controller?command=order_delete&orderId=${order.id}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                </div>
            <c:if test="${orders != null}" >
                <c:import url="/WEB-INF/parts/pagination.jsp"/>
            </c:if>
        </div>
    </div>
    </div>
</div>
</body>
</html>