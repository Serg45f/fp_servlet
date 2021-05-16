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
<br/>
<br/>

<c:if class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
<!--    <div class="bg-gradient-info" layout:fragment = "replace_fragment_main">-->
    <br/>
        <c:if test="${session.currentOrder != null}">
            <p>${session.currentOrder.id}</p>
            <p>${session.currentOrder.start}</p>
            <p>${session.currentOrder.end}</p>
            <p>${session.currentOrder.vehicle}</p>
        </c:if>
        <c:if test="${session.orderStage != null}">
            <p>${session.orderStage}</p>
        </c:if>
    <br/>
    <br/>
        <c:if id="optionsTable" class="table-responsive-sm  table-hover mt-3">
            <table class="table table-responsive-sm  table-hover mt-3 round">
                <thead>
                <tr>
                    <th scope="col">
                        <fmt:message key="options.th.cheque" bundle="${rb}"/>
                    </th>
                    <th scope="col">
                        <fmt:message key="options.th.picture" bundle="${rb}"/>
                    </th>
                    <th scope="col">
                        <fmt:message key="options.th.option" bundle="${rb}"/>
                    </th>
                    <th scope="col">
                        <fmt:message key="options.th.price" bundle="${rb}"/>
                    </th>
                    <c:if test = "${userRoles.contains(roles[\"ADMIN\"])}">
                        <th scope="col">
                            <fmt:message key="options.th.edit" bundle="${rb}"/>
                        </th>
                        <th scope="col">
                            <fmt:message key="options.th.delete" bundle="${rb}"/>
                        </th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                    <form action="/order/order" method="post">
                        <c:forEach var="option" items="${options}">
                            <tr>
                                <td>
    <!--                                <form th:action="@{/order/} + ${option.id}">-->
    <!--                                    <input type="checkbox" name="my-checkbox" onclick="submit();" th:checked="${option.isChosen} ? 'checked'">-->
    <!--                                </form>-->
                                </td>
                                </td>
                                <td>
                                    <img src="resources/pic/${option.picture}" class="card-img-top" alt="...">
                                </td>
                                <td>
                                    <p>${option.name}</p>
                                    <p>${option.description}</p>
                                </td>
                                <td>${option.price}</td>
                                <c:if test = "${loggedUserRoles.contains(roles['ADMIN'])}">
                                    <td>
                                        <a class="text-success" href="${pageContext.request.contextPath}/options/edit/${option.id}">Edit</a>
                                    </td>
                                    <td>
                                        <a class="text-danger" href="${pageContext.request.contextPath}/options/delete/${option.id}">Delete</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        <c:if test = "${loggedUserRoles.contains(roles['ADMIN'])}">
                                                <a class="text-success" to="4" href="${pageContext.request.contextPath}/options/add">
                                                    Add
                                                </a>
                        </c:if>

                        <input type="hidden" value="${order}" name="order">
                        <button type="submit" class="text-success" to="4">Submit</button>
                    </form>
                </tbody>

                <a>   </a>
            </table>
        </div>
    </div>
</body>
</html>