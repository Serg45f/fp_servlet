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

    <title>CarRentApp</title>
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
<%--<c:import url="/WEB-INF/parts/navbar.jsp"/>--%>

<br/>
<br/>
<br/>
<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
        <div class="order-group col-bg-12 col-form-label row">
            <h2 class="order-group ml-3">
                <fmt:message key="order.invoice.head" bundle="${rb}"/>
            </h2>
            <h3 class="order-group col-sm-7">
                ${sessionScope.currentOrder.id}
            </h3>
        </div>
        <i>===================================================================================</i>

        <div class="row">
            <div class="col">
                <div class="row" width="800" height="500">
                    <img src="resources/img/${sessionScope.currentOrder.vehicle.carModel.picture}"  alt="...">
                </div>
<!--                ////////////////////////////////////USER//////////////////////////////////////////-->
                <div class="order-group col-bg-12 col-form-label row">
                    <h3>
                        <fmt:message key="user.order.head" bundle="${rb}"/>
                    </h3>

                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="invoice.user.customer" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.user.firstName}  ${sessionScope.currentOrder.user.lastName}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="user.descr.licenseNumb" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.user.licenseNumb}
                    </h4>
                </div>
                <br>

<!--      ***********////////////////////////////////CONFIRM AND PAY////////////////////////////////******************-->
                <div class="order-group col-bg-12 col-form-label">
                    <h3 >
                        <fmt:message key="order.invoice.pay" bundle="${rb}"/>
                    </h3>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="payer" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.user.firstName} ${sessionScope.currentOrder.user.lastName}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="user.descr.cardNumb" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.user.cardNumb}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="reciver" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        C-RENT-C ltd
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="payment.req" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        <fmt:message key="pay.details" bundle="${rb}"/>
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="payment.purpose" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.id}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label">
                    <a class="btn  btn-outline-primary btn-lg btn-block"
                       href="${pageContext.request.contextPath}/success.jsp">
                        <fmt:message key="btn.order.invoice.pay" bundle="${rb}"/>
                    </a>
                </div>

            </div>

            <div class="col">

               <!-- ///////////////////////////////////////AUTO//////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 >
                        <fmt:message key="order.head.car" bundle="${rb}"/>
                    </h3>
                </div>

                    <div class="order-group col-bg-12 col-form-label row">
                        <h5 class="order-group ml-3">
                            <fmt:message key="order.descr.vehicle.model.name" bundle="${rb}"/>
                        </h5>
                        <h4 class="order-group ml-7">
                            ${sessionScope.currentOrder.vehicle.carModel.name}
                        </h4>
                    </div>


                    <div class="order-group col-bg-12 col-form-label row">
                        <h5 class="order-group ml-3">
                            <fmt:message key="order.descr.vehicle.regNumber" bundle="${rb}"/>
                        </h5>
                        <h4 class="order-group ml-7">
                            ${sessionScope.currentOrder.vehicle.regNumber}
                        </h4>
                    </div>
                <br>

<!--                /////////////////////////////////ORDER PARAMS/////////////////////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 >
                        <fmt:message key="order.head.dates" bundle="${rb}"/>
                    </h3>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="order.descr.location" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.location.getAddress()}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="order.descr.start" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.start}
                    </h4>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="order.descr.end" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.end}
                    </h4>
                </div>


                <div class="order-group col-bg-12 col-form-label row">
                    <h5 class="order-group ml-3">
                        <fmt:message key="order.descr.days" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group ml-7">
                        ${sessionScope.currentOrder.days}
                    </h4>
                </div>
                <br/>

 <!--                /////////////////////////////////////////OPTIONS////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h3 class="order-group ml-3">
                        <fmt:message key="order.head.options" bundle="${rb}"/>
                    </h3>
                </div>
                <c:forEach var="option" items="${sessionScope.currentOrder.options}">
                    <div class="order-group row">
                        <h5 class="order-group col-sm-4">
                            <fmt:message key="order.option.name" bundle="${rb}"/>
                        </h5>
                        <h4 class="order-group col-sm-6">
                            ${option.name}
                        </h4>
                        <h4 class="order-group col-sm-1">
                            ${option.price}
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
                        ${sessionScope.currentOrder.pricePeriod}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.price_options" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${sessionScope.currentOrder.priceOptions}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.price_total" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${sessionScope.currentOrder.totalPrice}
                    </h4>
                </div>
                <div class="order-group row">
                    <h5 class="order-group col-sm-4">
                        <fmt:message key="order.descr.deposit" bundle="${rb}"/>
                    </h5>
                    <h4 class="order-group col-sm-7">
                        ${sessionScope.currentOrder.vehicle.carModel.deposit}
                    </h4>
                </div>
        </div>
    </div>
</div>
</body>


</html>