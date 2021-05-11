<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>


<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>CONFERENCEHUB#1</title>
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
    <br>
    <br>
    <div class="container">
        <div class= "mx-auto my-auto" style="color:#ffffff;">
            <h2 class="mt-6 form-signing-hiding" >Registration</h2>

            <form accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/registration" >
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">First Name: </label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control bg-transparent text-white" placeholder="First name"
                               name="firstName">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Second Name: </label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control bg-transparent text-white" placeholder="Last name"
                               name="lastName">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Email: </label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control bg-transparent text-white"  placeholder="some@some.com"
                               name="email" >
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Password: </label>
                    <div class="col-sm-6">
                        <input  type="password" class="form-control bg-transparent text-white"  placeholder="Password"
                                name="password">
                    </div>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"></label>
                    <a class="col-sm-4">
                        <button class="btn btn-lg btn-transparent btn-outline-primary btn-lg btn-block"
                                type="submit">Submit</button>

                    </a>
                </div>

            </form>
        </div>
    </div>

</body>
</html>
