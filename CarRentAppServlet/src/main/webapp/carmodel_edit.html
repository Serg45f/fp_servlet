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

<div class="container mt-6" style="color:#515151; background-color: rgba(255, 255, 255, 0.7); display: flex;
flex-direction: column;
height:100vh;">
        <br>
        <h2 class="mt-4">Edit car model</h2>
        <br>
     <c:if class="form-group mt-3">
          <form accept-charset="UTF-8" method="post" enctype="multipart/form-data"  action="/carmodels" >

               <div class="form-group">
                    <div class="custom-pict">
                        <img src="resources/pic/${carmodel.picture}" width="500" height="312" alt="...">
                        <input  type="file" class="form-control  rounded" name="file" id="customPict">
<!--                        <label class="custom-file-label" for="customPict">Choose picture</label>-->
                    </div>
               </div>

              <div class="form-group">
                  <input  type="text" class="form-control bg-transparent" placeholder="Name"
                          value ="${carmodel.name}"  name ="name" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <input  type="text" class="form-control bg-transparent"  placeholder="Seats"
                          value ="${carmodel.seatsNumb}"  name ="seatsNumb" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <input  type="text" class="form-control bg-transparent"  placeholder="Doors"
                          value ="${carmodel.doorsNumb}"  name ="doorsNumb" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <select type="text" class="form-control bg-transparent" placeholder="Type"
                          value ="${carmodel.type}"  name ="type" />
                      <c:forEach var="type" items="${cartypes}">
                          <c:if test="${carmodel.type == type}">
                              <option class="form-control bg-transparent"
                                      selected
                                      value="${{type}}">${type.getType()}
                              </option>
                          </c:if>
                          <c:if test="${carmodel.type != type}">
                              <option class="form-control bg-transparent"
                                      value="${{type}}">${type.getType()}
                              </option>
                          </c:if>
                      </c:forEach>
                  </select>
              </div>

              <div class="form-group">
                  <select type="text" class="form-control bg-transparent" placeholder="Status"
                          value ="${carmodel.status}"  name ="status" />
                  <c:forEach var="status" items="${carstatuses}">
                      <c:if test="${carmodel.status == status}">
                          <option class="form-control bg-transparent"
                                  selected
                                  value="${{status}}">${status.getStatus()}
                          </option>
                      </c:if>
                      <c:if test="${carmodel.status != status}">
                          <option class="form-control bg-transparent"
                                  value="${{status}}">${status.getStatus()}
                          </option>
                      </c:if>
                  </c:forEach>
                  </select>
              </div>
              <div class="form-group">
                  <input  type="number" class="form-control bg-transparent"  placeholder="Price"
                          value ="${carmodel.price}"  name ="price" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

              <div class="form-group">
                  <input  type="number" class="form-control bg-transparent"  placeholder="Price"
                          value ="${carmodel.deposit}"  name ="deposit" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <c:if test="${carmodel.id!=null}">
                    <input type="hidden" value="${carmodel.id}"  named="id">
                </c:if>
                <div class="form-group">
                    <button type="submit" class="btn btn-transparent btn-outline-primary" >Save</button>
                </div>
        </form>
    </div>

</div>

</body>
</html>
