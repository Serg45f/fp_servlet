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
          <form accept-charset="UTF-8" method="post"  action="${pageContext.request.contextPath}/controller?command=order_update" >

              <div class="form-group col-bg-12 col-form-label row">
                  <h3 >
                      <fmt:message key="order.head.dates" bundle="${rb}"/>
                  </h3>
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="form-group col-sm-5">
                      <fmt:message key="order.descr.location" bundle="${rb}"/>
                  </h5>
                  <h4 class="form-group col-sm-7">
                      ${order.location.getAddress()}
                  </h4>
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="order-group col-sm-5">
                      <fmt:message key="order.descr.start" bundle="${rb}"/>
                  </h5>
                  <h4 class="form-group col-sm-7">
                      ${order.start}
                  </h4>
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="form-group col-sm-5">
                      <fmt:message key="order.descr.end" bundle="${rb}"/>
                  </h5>
                  <h4 class="form-group col-sm-7">
                      ${order.end}
                  </h4>
              </div>


              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="form-group col-sm-5">
                      <fmt:message key="order.descr.days" bundle="${rb}"/>
                  </h5>
                  <h4 class="form-group col-sm-7">
                      ${order.days}
                  </h4>
              </div>
              <br/>

              <div class="form-group col-bg-12 col-form-label row">
                   <h5 class="col-sm-5  col-form-label text-success">
                       <fmt:message key="order.descr.realEnd" bundle="${rb}"/>
                   </h5>
                  <h4 class="col-sm-7">
                       <input class="form-control text-success" type="datetime-local"
                              placeholder="Date/time of car return"
                              value="${order.realEnd}" name = "realEnd" />
                  </h4>
              </div>
              <br/>
              <br/>
              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-5  col-form-label text-warning">
                      <fmt:message key="order.descr.damageDescript" bundle="${rb}"/>
                  </h5>
                  <h4 class="col-sm-7" >
                      <input class="form-control" type="text"  placeholder="Damage description"
                             value="${order.damageDescript}" name = "damageDescript" />
                  </h4>
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-5  col-form-label text-warning">
                      <fmt:message key="order.descr.damagePrice" bundle="${rb}"/>
                  </h5>
                  <h4 class="col-sm-7" >
                      <input class="form-control" type="number"  placeholder="Damage price"
                             value="${order.damagePrice}" name = "damagePrice" />
                  </h4>
              </div>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-5  col-form-label text-warning">
                      <fmt:message key="editOrder.isPayed" bundle="${rb}"/>
                  </h5>
                  <h4 class="col-sm-7">
                      <input class="form-control " type="checkbox" name="damageIsPayed"
                             value="true"
                             ${order.damageIsPayed ? 'checked="checked"' : ''}/>

                  </h4>

              </div>

              <br/>

              <div class="form-group col-bg-12 col-form-label row">
                  <h5 class="col-sm-5  col-form-label text-warning">
                      <fmt:message key="order.descr.status" bundle="${rb}"/>
                  </h5>
                  <h4 class="col-sm-7">
                      <select type="text" class="form-control" placeholder="Status"
                              name ="statusOrder" >
                          <c:forEach var="status" items="${orderStatuses}">
                              <option value="${status.name()}"   ${order.status == status ? 'selected="selected"' : ''}>${status.name()}</option>
                          </c:forEach>
                      </select>
                  </h4>

              </div>

                <input  type="hidden" value="${order.id}" name = "orderId" />
                <div class="form-group">
                    <button type="submit" class="btn btn-transparent btn-outline-primary" >Save</button>
                </div>
        </form>
    </div>

</div>

</body>
</html>
