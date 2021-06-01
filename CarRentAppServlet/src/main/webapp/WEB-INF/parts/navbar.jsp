<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%> --%>
<%@ page import="java.util.*, java.text.*, java.lang.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>


<fmt:setLocale value = "${sessionScope.lang}"  scope="session"/>
<fmt:setBundle basename="messages" var="rb"/>
<html lang = "${sessionScope.lang}">
<nav id="navb" class="navbar navbar-expand-lg navbar-light  fixed-top">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
        <img src="resources/img/logo-1.png" alt="" width="30" height="30" class="d-inline-block align-top">
        C-RENT-C
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:if test="${sessionScope.orderStage >= 1}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/period" >
                        <fmt:message key="nav.step.1" bundle="${rb}" />
                    </a>
                </li>
            </c:if>

            <c:if test="${sessionScope.orderStage >= 2}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/vehicles" >
                        <fmt:message key="nav.step.2" bundle="${rb}" />
                    </a>
                </li>
            </c:if>

            <c:if test="${sessionScope.orderStage >= 3}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/options" >
                        <fmt:message key="nav.step.3" bundle="${rb}" />
                    </a>
                </li>
            </c:if>


            <c:if test = "${loggedUserRoles.contains(roles['USER'])}">
                <c:if test="${sessionScope.orderStage >= 4}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/order" >
                            <fmt:message key="nav.step.4" bundle="${rb}" />
                        </a>
                    </li>
                </c:if>

                <c:if test="${session.orderStage == -1}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/invoice">
                            <fmt:message key="nav.step.5" bundle="${rb}" />
                        </a>
                    </li>
                </c:if>
            </c:if>

           <c:if test = "${!loggedUserRoles.contains(roles['USER']) && !userRoles.contains(roles['MANAGER']) && !userRoles.contains(roles['ADMIN'])}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">
                        <fmt:message key="nav.2" bundle="${rb}" />
                    </a>
                </li>
            </c:if>


            <c:if test = "${loggedUserRoles.contains(roles['ADMIN'])}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/carModels" >
                        <fmt:message key="nav.4" bundle="${rb}" />
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/vehicles">
                        <fmt:message key="nav.1" bundle="${rb}" />
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/users">
                        <fmt:message key="nav.6" bundle="${rb}" />
                    </a>
                </li>
            </c:if>

        </ul>


        <a class="navbar-text mr-3">
            ${loggedUserName}

        </a>

        <c:if test = "${loggedUserName != null}">
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button class="btn btn-sm mt-1 btn-transparent" type="submit">LogOut</button>
            </form>
        </c:if>


             <span>
                 <fmt:message key="lang.change" bundle="${rb}" />
             </span>:
             <select class="form-control bg-transparent col-sm-1" id="locales"
             >
             <option value="${lang}"  selected>${lang}</option>
                 <option value="en" >
                     <a href="?sessionLocale=en">
                         <fmt:message key="lang.eng" bundle="${rb}" /></a>
                 </option>
                 <option value="ru" >
                     <a href="?sessionLocale=ru">
                         <fmt:message key="lang.ru" bundle="${rb}" /></a>
                 </option>
                 <option value="ua" >
                     <a href="?sessionLocale=ua">
                         <fmt:message key="lang.ua" bundle="${rb}" /></a>
                 </option>
                 ${lang}
             </select>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                $("#locales").change(function () {
                    var selectedOption = $('#locales').val();
                    if (selectedOption != ''){
                        window.location.replace('?sessionLocale=' + selectedOption);
                    }
                });
            });
        </script>

    </div>

</nav>