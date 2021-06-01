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
<%@ include file="parts/navbar.jsp" %>
<%--<c:import url="parts/navbar.jsp"/>--%>

        <div class="order-group col-bg-12 col-form-label row">
            <h2 class="order-group ml-3" type="text" th:text="#{order.invoice.head}"/>
            <h2 class="order-group col-sm-7" type="text" th:text="${session.invoice.order.id}"/>
        </div>
        <i>===================================================================================</i>

        <div class="row">
            <div class="col">
                <div class="row" width="800" height="500">
                    <img th:src="resources/img/${session.invoice.order.vehicle.carModel.picture}"  alt="...">
                </div>
<!--                ////////////////////////////////////USER//////////////////////////////////////////-->
                <div class="order-group col-bg-12 col-form-label row">
                    <h4 class="order-group ml-3" type="text" name="description" th:text="#{user.order.head}"/>

                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-5"  th:text="#{invoice.user.customer}"></p>
                    <h6 class="order-group col-sm-7" type="text"
                        th:text="${session.invoice.order.user.firstName+ ' ' + session.invoice.order.user.lastName}"/>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-5" th:text="#{user.descr.licenseNumb}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="place" th:text="${session.invoice.order.user.licenseNumb}"/>
                </div>
                <br>

<!--      ***********////////////////////////////////CONFIRM AND PAY////////////////////////////////******************-->
                <div class="order-group col-bg-12 col-form-label">
                    <h4 class="order-group ml-3" type="text" name="description" th:text="#{order.invoice.pay}"/>
                </div>

                <div class="order-group row">
                    <p class="order-group col-sm-5" th:text="#{payer}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="card"
                        th:text="${session.invoice.order.user.firstName + ' '+session.invoice.order.user.lastName}"/>
                </div>
                <div class="order-group row">
                    <p class="order-group col-sm-5" th:text="#{user.descr.cardNumb}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="card" th:text="${session.invoice.order.user.cardNumb}"/>
                </div>
                <div class="order-group row">
                    <p class="order-group col-sm-5" th:text="#{reciver}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="card">C-RENT-C ltd</h6>
                </div>
                <div class="order-group row">
                    <p class="order-group col-sm-5" th:text="#{payment.req}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="card" th:text="#{pay.details}"/>
                </div>
                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-5" th:text="#{payment.purpose}"></p>
                    <h6 class="order-group col-sm-7" type="text" name="card" th:text="${session.invoice.order.id}"/>
                </div>
                <div class="order-group col-bg-12 col-form-label">
<!--                    <h3 class="order-group ml-3" type="text" name="description" th:text="#{invoice.pay}"/>-->
                    <a class="btn  btn-outline-primary btn-lg btn-block"
                       th:href="@{/order/invoice/pay}" th:text="#{btn.order.invoice.pay}">Pay</a>
                    <!--                       th:href="@{/order/invoice}" th:text="#{btn.order.invoice}">Confirm</a>-->
                </div>

            </div>


            <div class="col">

               <!-- ///////////////////////////////////////AUTO//////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h4 class="order-group ml-3" type="text" th:text="#{order.head.car}"/>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-4" th:text="#{order.descr.vehicle.model.name}">About name</p>
                    <h5 class="order-group col-sm-7" type="text" name="location" th:text="${session.invoice.order.vehicle.carModel.name}"/>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-4" th:text="#{order.descr.vehicle.regNumber}">About name</p>
                    <h5 class="order-group col-sm-7" type="text" name="location" th:text="${session.invoice.order.vehicle.regNumber}"/>
                </div>
                <br>

<!--                /////////////////////////////////ORDER PARAMS/////////////////////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h4 class="order-group ml-4" type="text" name="description" th:text="#{order.head.dates}"/>
                </div>

                <div class="order-group col-bg-12 col-form-label row">
                    <p class="order-group col-sm-4 " th:text="#{order.descr.location}">About palce</p>
                    <h5 class="order-group col-sm-7" type="text" name="location" th:text="${session.invoice.order.location.getAddress()}"/>
                </div>
                <div class="order-group row">
                    <p class="event-group col-sm-4 " th:text="#{order.descr.start}">About date</p>
                    <h5 class="order-group col-sm-7" type="text" name="start"
                        th:text="${#temporals.format(session.invoice.order.start,'dd.MM.yyyy hh:mm')}"/>
                </div>
                <div class="order-group row">
                    <p class="order-group col-sm-4" th:text="#{order.descr.end}">About time</p>
                    <h5 class="order-group col-sm-7" type="text" name="end"
                        th:text="${#temporals.format(session.invoice.order.end,'dd.MM.yyyy hh:mm')}"/>
                </div>
                <div class="order-group row">
                    <p class="order-group col-sm-4" th:text="#{order.descr.days}">About language</p>
                    <h5 class="order-group col-sm-7" type="text" name="lang" th:text="${session.invoice.order.days}"/>
                </div>
                <br/>

<!--                /////////////////////////////////////////OPTIONS////////////////////////////////////-->

                <div class="order-group col-bg-12 col-form-label row">
                    <h4 class="order-group ml-3" type="text" th:text="#{order.head.options}"/>

                </div>
            <div th:each = option:${options}>
                <div class="order-group row">
                    <p class="order-group col-sm-4" th:text="#{order.option.name}">About language</p>
                    <h5 class="order-group col-sm-7" type="text"  th:text="${session.invoice.order.option.name}"/>
                </div>
            </div>
                <br>

<!--                ///////////////////////////////////////TO PAY/////////////////////////////////////-->
            <div class="order-group col-bg-12 col-form-label">
                <h4 class="order-group ml-3" type="text" th:text="#{order.head.toPay}"/>
            </div>

            <div class="order-group row">
                <p class="order-group col-sm-4" th:text="#{order.descr.price_car}">About price</p>
                                    <h5 class="order-group col-sm-7" type="text" name="price1"
                                        th:text="${#numbers.formatDecimal(session.invoice.order.pricePeriod,2,2)}"/>
            </div>
            <div class="order-group row">
                <p class="order-group col-sm-4" th:text="#{order.descr.price_options}">About price</p>
                                    <h5 class="order-group col-sm-7" type="text" name="price2"
                                        th:text="${#numbers.formatDecimal(session.invoice.order.priceOptions,2,2)}"/>
            </div>
            <div class="order-group row">
                <p class="order-group col-sm-4" th:text="#{order.descr.price_total}">About price</p>
                                    <h5 class="order-group col-sm-7" type="text" name="price3"
                                        th:text="${#numbers.formatDecimal(session.invoice.order.totalPrice,2,2)}"/>
            </div>
            <div class="order-group row">
                <p class="order-group col-sm-4" th:text="#{order.descr.deposit}">About price</p>
                                    <h5 class="order-group col-sm-7" type="text" name="price4"
                                        th:text="${#numbers.formatDecimal(session.invoice.order.vehicle.carModel.deposit,2,2)}"/>
            </div>
            </div>
        </div>
    </div>
</body>


</html>