<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.* , java.lang.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false"%>
<%@ page session="true" %>


<!-- Pagination control -->
<!-- Hardcoding the default page-size as 3. User can create a dropdown to select the different page-sizes. -->
<c:set var="currentPageURL" value="${pageContext.request.requestURL}"/>
<c:set var="ordersURL" value="orders.jsp"/>
<c:set var="carmodelsURL" value="carmodels.jsp"/>
<c:set var="userListURL" value="userList.jsp"/>
<c:set var="vehiclesURL" value="vehicles.jsp"/>

<c:if test="${fn:endsWith(currentPageURL,ordersURL)}">
    <c:set var="endPoint" value="orders"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,carmodelsURL)}">
    <c:set var="endPoint" value="carModels"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,userListURL)}">
    <c:set var="endPoint" value="users"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,vehiclesURL)}">
    <c:set var="endPoint" value="vehicles"/>
</c:if>


<div  class="container-fluid   translate-middle-x">
    <div class="row">
        <div class="col order-1">
            <nav aria-label="Navigation for pageable" >
                <ul class="pagination">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item"><a class="page-link bg-transparent"
                                  href="controller?command=${endPoint}&recordsPerPage=${recordsPerPage}&tPage=${currentPage-1}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <li class="page-item active"><a class="page-link bg-transparent"
                                            ${i} <span class="sr-only">${currentPage}</span></a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link bg-transparent"
                                             href="controller?command=${endPoint}&recordsPerPage=${recordsPerPage}&tPage=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage lt noOfPages}">
                        <li class="page-item"><a class="page-link bg-transparent"
                                       href="controller?command=${endPoint}&recordsPerPage=${recordsPerPage}&tPage=${currentPage+1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <div class="col order-2">

               <form  action="controller?command=${endPoint}">

                    <input type="hidden" name="currentPage" value="${currentPage}">

                    <div class="form-group">
                        <div class="row">
                            <div class="col-1">

                            </div>
                            <div class="col-4">
                                <label for="records" >Records per page:</label>
                            </div>

                            <div class="col">
                                <div class="row">
                                    <nav aria-label="Navigation for events">
                                        <ul id="records" class="pagination">
                                            <li class="page-item">
                                                <a class="page-link "
                                                   href="controller?command=${endPoint}&currentPage=${currentPage}&&recordsPerPage=3">3
                                                </a>
                                            </li>
                                            <li class="page-item">
                                                <a class="page-link "
                                                   href="controller?command=${endPoint}&currentPage=${currentPage}&&recordsPerPage=6">6
                                                </a>
                                            </li>
                                            <li class="page-item">
                                                <a class="page-link "
                                                   href="controller?command=${endPoint}&currentPage=${currentPage}&&recordsPerPage=9">9
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                        <%--
                                <select class="form-control bg-transparent" id="records" name="recordsPerPage1">
                                    <option type="hidden" value="" selected>${recordsPerPage}</option>
                                    <option value="3" >3</option>
                                    <option value="6" >6</option>
                                    <option value="9">9</option>
                                </select>
                        --%>
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-transparent btn-outline-primary">Submit</button>

                            </div>
                        </div>
                   </div>
            </form>

        </div>
    </div>
</div>



