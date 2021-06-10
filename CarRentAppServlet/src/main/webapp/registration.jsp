<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>


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
<c:import url="/WEB-INF/parts/navbar.jsp"/>
<br/>
<br/>
<br/>

<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7);

height:100vh;">
        <div class= "mx-auto my-auto">
            <h2 class="form-signing-hiding" >
                <fmt:message key="registration.order.head" bundle="${rb}"/>
            </h2>

            <form class = "mt-2 needs-validation" novalidate accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/controller?command=registration" >
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.firstName" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control bg-transparent" placeholder="First name"
                               name="firstName" pattern="[.[^@\s:;,]]+" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.lastName" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control bg-transparent" placeholder="Last name"
                               name="lastName" pattern="[.[^@\s:;,]]+" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.email" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control bg-transparent"  placeholder="some@some.com"
                               pattern="([.[^@\s]]+)@([.[^@\s]]+)\.([a-z]+)" name="email" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.password" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="password" class="form-control bg-transparent"  placeholder="Password"
                                pattern="\d+" name="password" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.phone" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input type="tel" class="form-control "  placeholder="+380*********"
                               name="phone" pattern="\+380\d{9}" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.country" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="text" class="form-control "  placeholder="Country"
                                name="country" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.passport" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="text" class="form-control "  placeholder="Passport #"
                                name="passportNumb" pattern=".*" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.expireDate" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="date" class="form-control "  placeholder="Date of expire"
                                name="passDateExp" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.license" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="text" class="form-control "  placeholder="Driver license #"
                                name="licenseNumb" pattern=".*" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">
                        <fmt:message key="registration.card" bundle="${rb}"/>
                    </label>
                    <div class="col-sm-6">
                        <input  type="text" class="form-control "  placeholder="****************"
                                name="cardNumb" pattern="\d{16}" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3 col-form-label"></label>
                    <a class="col-sm-4">
                        <button class="btn btn-lg btn-transparent btn-outline-primary btn-lg btn-block"
                                type="submit">
                            <fmt:message key="btn.registration.submit" bundle="${rb}"/>
                        </button>

                    </a>
                </div>

            </form>

            <script>

(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to

    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission

    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>

        </div>
    </div>

</body>
</html>
