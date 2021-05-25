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

<fmt:setLocale value="${sessionScope.lang}" scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}">
<head>

    <title>CarRentApp</title>
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
<!--    <div class="bg-gradient-info" layout:fragment = "replace_fragment_main">-->
<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
        <div class="order-group col-bg-12 col-form-label row">
            <h2 class="order-group ml-3">
                <fmt:message key="order.head" bundle="${rb}"/>
            </h2>

        </div>
        <i>===================================================================================</i>

        <div class="row">
            <div class="col">
                <div class="row" width="800" height="500">
                    <img src="resources/img/${session.currentOrder.vehicle.carModel.picture}"  alt="...">
                </div>
<!--                ////////////////////////////////////USER//////////////////////////////////////////-->
                <div class="order-group col-bg-12 col-form-label row">
                    <h3 class="order-group ml-3">
                        <fmt:message key="user.order.head" bundle="${rb}"/>
                    </h3>
                    <a class="nav-link" href="${pageContext.request.contextPath}/userEdit">
                        <fmt:message key="btn.edit" bundle="${rb}"/>
                    </a>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.firstName" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.firstName}
                    </h4>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.lastName" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.lastName}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.email" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.email}
                    </h4>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.phone" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.phone}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.country" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.country}
                    </h4>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.passportNumber" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.passportNumb}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.passDateExp" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7" type="date">
                       ${session.currentOrder.user.passDateExp}"
                    </h4>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.licenseNumb" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.licenseNumb}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-5">
                        <fmt:message key="user.descr.cardNumb" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.user.cardNumb}
                    </h4>
                </div>
                <br>

<!--      ***********////////////////////////////////CONFIRM AND PAY////////////////////////////////******************-->
                <div class="order-group col-bg-12 col-form-label">
                    <h3 class="order-group ml-3">
                        <fmt:message key="order.confirm" bundle="${rb}"/>
                    </h3>
                    <a class="btn  btn-outline-primary btn-lg btn-block"
                       href="${pageContext.request.contextPath}/order/create">
                        <fmt:message key="btn.order.invoice" bundle="${rb}"/>
                    </a>
   <%--                 <!--                       th:href="@{/order/invoice}" th:text="#{btn.order.invoice}">Confirm</a>--> --%>
                </div>

            </div>


            <div class="col">

               <!-- ///////////////////////////////////////AUTO//////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 class="order-group ml-3">
                        <fmt:message key="order.head.car" bundle="${rb}"/>
                    </h3>
                    <a class="nav-link" href="${pageContext.request.contextPath}/vehicles">
                        <fmt:message key="btn.edit" bundle="${rb}"/>
                    </a>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.vehicle.model.name" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.vehicle.carModel.name}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.vehicle.issueDate" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7" type="date">
                        ${session.currentOrder.vehicle.yearIssue}"
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.vehicle.regNumber" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.vehicle.regNumber}
                    </h4>
                </div>
                <br>

<!--                /////////////////////////////////ORDER PARAMS/////////////////////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 class="order-group ml-4">
                        <fmt:message key="order.head.dates" bundle="${rb}"/>
                    </h3>
                    <a class="nav-link" href="${pageContext.request.contextPath}/period">
                        <fmt:message key="btn.edit" bundle="${rb}"/>
                    </a>
                </div>

<!--                private LocalDateTime realEnd;-->
<!--                private Vehicle vehicle;-->
<!--                private Integer discount;-->
<!--                private User user;-->
<!--                private Manager manager;-->
<!--                private StatusOrder status;-->
<!--                private File qrcode;-->
<!--                private Double price;-->
<!--                private Double priceAdd;-->
<!--                private Double deposit;-->
<!--                List<Option> options;-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.location" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.location.getAddress()}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="event-group col-sm-4">
                        <fmt:message key="order.descr.start" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.start}"
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.end" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.end}"
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.days" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${session.currentOrder.days}
                    </h4>
                </div>
                <br/>

<!--                /////////////////////////////////////////OPTIONS////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 class="order-group ml-3">
                        <fmt:message key="order.head.options" bundle="${rb}"/>
                    </h3>
                    <a class="nav-link" href="${pageContext.request.contextPath}/btn.edit">
                        <fmt:message key="btn.edit" bundle="${rb}"/>
                    </a>
                </div>
                <c:forEach var="option" items="${options}">
                    <div class="order-group row">
                        <h5 class="order-group col-sm-4">
                            <fmt:message key="order.option.name" bundle="${rb}"/>
                        </h5>
                        <h4 class="order-group col-sm-7">
                            ${session.currentOrder.option.name}
                        </h4>
                    </div>
                </c:forEach>
                <br>

<!--                ///////////////////////////////////////TO PAY/////////////////////////////////////-->
            <div class="order-group col-bg-12 col-form-label">
                <h3 class="order-group ml-3">
                    <fmt:message key="order.head.toPay" bundle="${rb}"/>
                </h3>
            </div>

            <div class="order-group row">
                <h5 class="order-group col-sm-4">
                    <fmt:message key="order.descr.price_car" bundle="${rb}"/>
                </h5>
                <h4 class="order-group col-sm-7">
                    ${session.currentOrder.pricePeriod}
                </h4>
            </div>
            <div class="order-group row">
                <h5 class="order-group col-sm-4">
                    <fmt:message key="order.descr.price_options" bundle="${rb}"/>
                </h5>
                <h4 class="order-group col-sm-7">
                    th:text="${session.currentOrder.priceOptions}
                </h4>
            </div>
            <div class="order-group row">
                <h5 class="order-group col-sm-4">
                    <fmt:message key="order.descr.price_total" bundle="${rb}"/>
                </h5>
                <h4 class="order-group col-sm-7">
                    ${session.currentOrder.totalPrice}
                </h4>
            </div>
            <div class="order-group row">
                <h5 class="order-group col-sm-4">
                    <fmt:message key="order.descr.deposit" bundle="${rb}"/>
                </h5>
                <h4 class="order-group col-sm-7">
                    ${session.currentOrder.vehicle.carModel.deposit}"
                </h4>
            </div>
           </div>
        </div>
</div>
</body>


</html>