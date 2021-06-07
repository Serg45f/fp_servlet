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
<br/>
<br/>
<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
        <br>
        <h2 class="mt-4">
            Edit order
        </h2>
        <br>
     <div class="form-group mt-3">
          <form accept-charset="UTF-8" method="post"  action="${pageContext.request.contextPath}/controller?command=order_save" >

              <div class="order-group col-bg-12 col-form-label row">
                  <h4 >
                      <fmt:message key="order.head.dates" bundle="${rb}"/>
                  </h4>
              </div>

              <div class="order-group col-bg-12 col-form-label row">
                  <p class="order-group ml-3">
                      <fmt:message key="order.descr.location" bundle="${rb}"/>
                  </p>
                  <h6 class="order-group ml-7">
                      ${order.location.getAddress()}
                  </h6>
              </div>

              <div class="order-group col-bg-12 col-form-label row">
                  <p class="order-group ml-3">
                      <fmt:message key="order.descr.start" bundle="${rb}"/>
                  </p>
                  <h6 class="order-group ml-7">
                      ${order.start}
                  </h6>
              </div>

              <div class="order-group col-bg-12 col-form-label row">
                  <p class="order-group ml-3">
                      <fmt:message key="order.descr.end" bundle="${rb}"/>
                  </p>
                  <h6 class="order-group ml-7">
                      ${order.end}
                  </h6>
              </div>


              <div class="order-group col-bg-12 col-form-label row">
                  <p class="order-group ml-3">
                      <fmt:message key="order.descr.days" bundle="${rb}"/>
                  </p>
                  <h6 class="order-group ml-7">
                      ${order.days}
                  </h6>
              </div>
              <br/>
<%--
              <div class="form-group col-bg-12 col-form-label row">
                   <h5 class="col-sm-4  col-form-label text-success" th:text="#{order.descr.realEnd}">real end</h5>
                   <input class="col-sm-6 form-control text-success bg-transparent" type="datetime-local"
                          placeholder="Date/time of car return"
                          th:field ="*{realEnd}" />
              </div>
              <br/>
              <br/>
              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-4  col-form-label text-warning" th:text="#{order.descr.damageDescript}">Damage descript</h5>
                  <input class="col-sm-6 form-control text-warning bg-transparent" type="text"  placeholder="Damage description"
                              th:field ="*{damageDescript}" />
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-4  col-form-label text-warning" th:text="#{order.descr.damagePrice}">Damage price</h5>
                  <input class="col-sm-6 form-control text-warning bg-transparent" type="number"  placeholder="Damage price"
                              th:field ="*{damagePrice}" />
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-4  col-form-label text-warning" th:text = "#{editOrder.isPayed}">Damage isPayed</h5>
                  <input class="col-sm-6 form-control text-warning" type="checkbox" name="damageIsPayed"
                                th:checked="${order.damageIsPayed} ? true : false "
                                th:value="${true}"/>
              </div>
              <br/>
              <br/>
              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-4  col-form-label text-danger" th:text="#{order.descr.status}">Status</h5>
                  <select class="col-sm-6 form-control text-danger bg-transparent"  type="text" placeholder="Status"
                          th:field ="*{status}">
                      <div th:each ="status:${statuses}">
                          <option class="form-control bg-transparent"
                                  th:value="${{status}}" th:text="${status.name()}">Status</option>
                      </div>
                  </select>
              </div>
--%>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-transparent btn-outline-primary" >Save</button>
                </div>
        </form>
    </div>

</div>

</body>
</html>
