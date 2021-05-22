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
<c:import url="navbar.jsp"/>
<br/>

 <div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
     <br/>
     <br/>
    <h1 class="text-color mt-2"  >
        <fmt:message key="greeting1" bundle="${rb}"/>
    </h1>
    <h1 class="text-color mt-2"  >
        <fmt:message key="greeting2" bundle="${rb}"/>
    </h1>
        <br>
        <br>
    <c:if test="${sessionScope.orderStage!=null && sessionScope.orderStage!=-1}">
        <a class="btn  btn-outline-warning my-8 text-center" to="1" href="${pageContext.request.contextPath}/setPeriod">
            <fmt:message key="btn.startHere" bundle="${rb}"/>START HERE</a>
    </c:if>
    <br>

     <i>${pageContext.request.contextPath}</i>
     <i>${session.orderStage}</i>

        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner rounded-lg">

                <div class="carousel-item  active">
                    <img src="resources/img/tr-carousel-Ford-Focus-1.png" class="d-block w-100 h-100 rounded" alt="..." >
                    <div class="carousel-caption mt-8 ml-2" style="text-align: left;">
                        <h3 class="carousel-item-header">
                            <fmt:message key="carousel.h.1" bundle="${rb}"/>
                        </h3>
                        <h3> </h3>
                        <h3>
                            <fmt:message key="carousel.p.1" bundle="${rb}"/>
                        </h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="resources/img/tr-carousel-Hyundai-Accent-2.png" class="d-block w-100 h-100 rounded" alt="..." >
                    <div class="carousel-caption" style="text-align: right;">
                        <h3 class="carousel-item-header">
                            <fmt:message key="carousel.h.2" bundle="${rb}"/>
                        </h3>
                        <h3> </h3>
                        <h3>
                            <fmt:message key="carousel.p.2" bundle="${rb}"/>
                        </h3>
                    </div>
                </div>

                <div class="carousel-item" style="text-align: right;">
                    <img src="resources/img/tr-carousel-Kia-Rio-3.png" class="d-block w-100 h-100 rounded" alt="..." >
                    <div class="carousel-caption" style="text-align: right;">
                        <h3 class="carousel-item-header">
                            <fmt:message key="carousel.h.3" bundle="${rb}"/>
                        </h3>
                        <h3> </h3>
                        <h3>
                            <fmt:message key="carousel.p.3" bundle="${rb}"/>
                        </h3>
                    </div>
                </div>

            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>

</body>
</html>