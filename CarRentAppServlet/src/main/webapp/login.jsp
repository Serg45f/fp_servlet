<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>

<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>

<html lang="${sessionScope.lang}" xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>CarRentApp</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<c:import url="/WEB-INF/parts/navbar.jsp"/>
<div class="container col-sm-8 mx-auto my-auto" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
    <br>
    <br>
    <br>
    <br>
<form class = "mt-2 needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/controller?command=login">
    <h2 class="form-signing-hiding">
        <fmt:message key="login.head" bundle="${rb}"/>
    </h2>
    <br>
    <c:if test="${session.chequeEmail==1}">
        <a  href="mailto:${session.user.email}">Go to ${session.user.email} to confirm your email</a>
    </c:if>
    <h3 class="form-signing-hiding" >${message}</h3>
    <br>
    <br>
    <div class="form-group row">
        <label class="col-sm-2  col-form-label">
            <fmt:message key="login.name" bundle="${rb}"/>
        </label>
        <div class="col-sm-6 px-0">
            <input type="email" name="name" class="form-control bg-transparent" placeholder="some@some.com"
                   pattern="([.[^@\s]]+)@([.[^@\s]]+)\.([a-z]+)" required/>
            <div class="invalid-feedback">
                Please provide a valid username.
            </div>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2  col-form-label">
            <fmt:message key="login.pass" bundle="${rb}"/>
        </label>
        <div class="col-sm-6 px-0">
            <input type="password" name="pass" class="form-control bg-transparent" placeholder="Password"
                   pattern="\d+" required/>
            <div class="invalid-feedback">
                Please provide a valid password.
            </div>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2  col-form-label"></label>
        <a class="col-sm-3 px-0">
            <button class="btn btn-lg btn-transparent btn-block btn-outline-primary" type="submit">
                <fmt:message key="btn.login" bundle="${rb}"/>
            </button>
            <a class="btn btn-lg btn-transparent btn-outline-primary col-sm-3 px-0"  href="${pageContext.request.contextPath}/registration.jsp">
                <fmt:message key="btn.registration" bundle="${rb}"/>
            </a>

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
</body>
</html>


