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
<%@ include file="/WEB-INF/parts/navbar.jsp" %>
<%--<c:import url="${pageContext.request.contextPath}/parts/navbar.jsp"/>--%>
    <br/>
    <br/>
    <br/>
<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">

            <form class = "mt-2"   action="${pageContext.request.contextPath}/controller?command=setVehicle" method="post">
                <h2 class="form-signing-hiding">Period and Location</h2>

                <br>
                <br>
                <div class="form-group row">
                    <label class="col-sm-2  col-form-label">Location :</label>
                    <div class="col-sm-6 px-0">
                        <select type="text" class="form-control bg-transparent  is-valid"  placeholder="Location"
                                 name ="location">
                            <c:forEach var="location" items="${locations}" >
                                <option class="form-control bg-transparent"
                                        value="${location}" ${item.key == selectedlocation ? 'selected="selected"' : ''}>
                                    ${location.getAddress()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  col-form-label">Start: </label>
                    <div class="col-sm-6 px-0">
                        <input type="datetime-local" name="start" class="form-control is-valid" placeholder="Start date"
                               value="${order.start}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2  col-form-label">End: </label>
                    <div class="col-sm-6 px-0">
                        <input type="datetime-local" name="end" class="form-control is-valid" placeholder="End date"
                               value = "${order.end}"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3  col-form-label"></label>
                    <div class="my-4 col-sm-4  text-center">
                        <button id="btn_order" to="2" class="btn btn-lg  btn-block btn-outline-primary" type="submit">Sign in</button>
                    </div>
                </div>
            </form>
       </div>

</body>
</html>


