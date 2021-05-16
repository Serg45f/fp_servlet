<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>

<%--
String getFormattedDate(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return sdf.format(new Date());
}
--%>


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
<br/>
    <c:if test = "${userRoles.contains(roles['ADMIN'])}">

            <a class="btn btn-transparent btn-outline-primary"  data-toggle="collapse" href="#collapseEvents" role="button" aria-expanded="false" aria-controls="collapseExample">
                Add new event
            </a>
            <div class="collapse" id="collapseEvents">
                <div class="form-group mt-3">
                    <form  method="post" enctype="multipart/form-data"  action="@{/events}" object = "${event}">


                        <div class="form-group">
                            <input  type="text" class="form-control bg-transparent" name="name" placeholder="Name"
                            field ="${event.name}" />

                        </div>
<%--
                        <div each="theme : ${themes}">
                            <label><input type="checkbox" name="${theme}" text = "${theme.getTheme()}"
                                  checked="${event.themes!=null ? java.util.Set.contains(event.themes(),theme) : false}">,  </label>
                        </div>
--%>

                        <div class="form-group">
                            <select type="text" class="form-control bg-transparent" name="place" placeholder="Place"
                                    field ="${event.place}">
                                <div each ="place:${places}">
                                    <option class="form-control bg-transparent"
                                            value="${place}">Place</option>
                                </div>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control bg-transparent" name="date" placeholder="Data"
                            value="${event.date}" field ="${event.date}"/>
                        </div>

                        <div class="form-group">
                            <input type="time" class="form-control bg-transparent" name="time" placeholder="Time"
                                   value="${event.time}"       field ="${event.time}"/>


                        </div>

                        <div class="form-group">
                            <select type="text" class="form-control bg-transparent" name="language" placeholder="Language"
                                    field ="${event.language}">
                                <div each ="language:${languages}" >
                                    <option class="form-control bg-transparent"
                                            value="${language}" >Language</option>

                                </div>

                            </select>
                        </div>
                        <div class="form-group">
                            <input type="number" class="form-control bg-transparent" name="price" placeholder="Price"
                                   field ="${event.price}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control bg-transparent" name="description" placeholder="Description"
                                   field ="${event.description}"/>
                        </div>

                        <div class="form-group">
                            <div class="custom-pict">
                                <input type="file" class="form-control-file bg-transparent" name="file" id="customPict" >
                                <label class="custom-file-label text-white" for="customPict">Choose picture</label>
                            </div>
                        </div>

                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                       <%-- <input type="hidden" name="statusEvent" value="${event.statusEvent}"/> --%>
                        <div class="form-group">
                            <button type="submit" class="btn btn-transparent btn-outline-primary" >Add</button>
                        </div>
                    </form>

                </div>
            </div>

    </c:if>

    <br>
    <br>
    <div class="container">

        <h2 class="mt-3" >
            <fmt:message key="events.header" bundle="${rb}" />
        </h2>

        <br>
        <br>


        <div class="card-columns" id="each">

            <c:forEach var="event" items="${events}">
                <div class="card bg-transparent text-white  mb-3 "  >
                    <div class="row no-gutters">
                        <img src="resources/img/${event.picture}" class="card-img-top" width="300" height="187" alt="...">
                        <div class="col-md-12">
                            <div class="card-body">
                                <h5 class="card-title">
                                    <fmt:message key="card.descr.name" bundle="${rb}"/>
                                    ${event.name}
                                </h5>

                                <p class="card-text"  type="date">
                                    <fmt:message key="card.descr.date" bundle="${rb}"/>
                                    <small>${event.date}</small>
                                </p>
                                <p class="card-text" type="time">
                                    <fmt:message key="card.descr.time" bundle="${rb}"/>
                                    <small>${event.time}</small>
                                </p>
                                <p class="card-text">
                                    <fmt:message key="card.descr.language" bundle="${rb}"/>
                                    <small>${event.language}</small>
                                </p>
                                <p class="card-text text-sm">
                                    <fmt:message key="card.descr.description" bundle="${rb}"/>
                                    <small>${event.description}</small>
                                </p>
                                <div class="card-footer">
                                    <fmt:message key="card.descr.price" bundle="${rb}"/>
                                    <b>${event.price}</b>
                                </div>

                                <a href="${pageContext.request.contextPath}/event?eventId=${event.id}" class="btn btn-transparent btn-outline-primary" >Open</a>

                                <c:if test = "${userRoles.contains(roles['ADMIN'])}">
                                    <a  href="${pageContext.request.contextPath}/events/edit?eventId=${event.id}" class="btn btn-transparent btn-outline-success" >Edit</a>
                                    <a  href="${pageContext.request.contextPath}/events/delete?eventId=${event.id}" class="btn btn-transparent btn-outline-danger" >Delete</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
      <c:import url="pagination.jsp"/>
    </div>
</div>
</body>





</html>