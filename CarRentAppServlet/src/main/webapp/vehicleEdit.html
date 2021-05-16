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
<!--<div layout:fragment = "replace_fragment_main">-->

<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
        <br>
        <br>
        <h2 class="mt-4">Edit vehicle</h2>
        <br>
     <div class="form-group mt-3">
          <form accept-charset="UTF-8" method="post"  action="${pageContext.request.contextPath}/vehicles">

               <div class="form-group">
                    <div class="custom-pict">
                        <c:if test="${vehicle.carModel!=null}">
                            <img src="${pageContext.request.contextPath}/pic/${vehicle.carModel.picture}" width="500" height="312" alt="..."/>
                        </c:if>
<!--                        <input  type="file" class="form-control  rounded" name="file" id="customPict" >-->
<!--                        <label class="custom-file-label" for="customPict">Choose picture</label>-->
                    </div>
               </div>

              <c:forEeach class="form-group">
                  <select type="text" class="form-control bg-transparent" placeholder="Car model"
                          value ="${carModel}" name="carModel">
                      <c:forEeach var="carmodel" items="${carmodels}">
                          <option class="form-control bg-transparent"
                                  value="${{carmodel}}" >${carmodel.name}</option>
                      </c:forEeach>
                  </select>
              </div>

              <div class="form-group">
                  <input  type="text" class="form-control bg-transparent" placeholder="Registration number"
                          value ="${vehicle.regNumber}" name="regNumber"/>
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <input  type="date" class="form-control bg-transparent"  placeholder="Year of issue"
                          value="${vehicle.yearIssue}" name ="yearIssue" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <input  type="text" class="form-control bg-transparent"  placeholder="Transmission"
                          value ="${vehicle.transmission}" name ="transmission"/>
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <select type="text" class="form-control bg-transparent" placeholder="Color"
                          value ="${vehicle.color}" name ="color">
                      <c:forEach var="color" items="${colors}">
                          <option class="form-control bg-transparent"  value="${{color}}">
                              ${color.getColor()}
                          </option>
                      </c:forEach>
                  </select>

              </div>


              <div class="form-group">
                  <input  type="number" class="form-control bg-transparent"  placeholder="Discount"
                          value ="${vehicle.discount}" name ="discount"/>
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <select type="text" class="form-control bg-transparent" name="themes" placeholder="Themes"
                          value ="${vehicle.manager}" name="manager">
                      <c:forEach var="manager" items="${managers}" >
                          <option class="form-control bg-transparent" value="${{manager}}">
                              ${manager.lastName}"
                          </option>
                      </c:forEach>
                  </select>
              </div>


                <input type="hidden" name="_csrf" value="${_csrf.token}" />
              <c:if test="${vehicle.id!=null}">
                <input type="hidden" value="${vehicle.id}" name="id" >
              </c:if>
                <div class="form-group">
                    <button type="submit" class="btn btn-transparent btn-outline-primary" >Save</button>
                </div>
        </form>
    </div>

</div>

</body>
</html>
