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
<c:set var="eventsURL" value="events.jsp"/>
<c:set var="carmodelsURL" value="carmodels.jsp"/>
<c:set var="userListURL" value="userList.jsp"/>
<c:set var="ticketsURL" value="tickets.jsp"/>

<c:if test="${fn:endsWith(currentPageURL,eventsURL)}">
    <c:set var="endPoint" value="events"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,carmodelsURL)}">
    <c:set var="endPoint" value="carmodels"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,userListURL)}">
    <c:set var="endPoint" value="users"/>
</c:if>
<c:if test="${fn:endsWith(currentPageURL,ticketsURL)}">
    <c:set var="endPoint" value="tickets"/>
</c:if>


<div  class="container-fluid   translate-middle-x">
    <div class="row">
        <div class="col order-1">
            <nav aria-label="Navigation for pageable" >
                <ul class="pagination">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item"><a class="page-link bg-transparent"
                                  href="${endPoint}?recordsPerPage=${recordsPerPage}&tPage=${currentPage-1}">Previous</a>
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
                                             href="${endPoint}?recordsPerPage=${recordsPerPage}&tPage=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage lt noOfPages}">
                        <li class="page-item"><a class="page-link bg-transparent"
                                       href="${endPoint}?recordsPerPage=${recordsPerPage}&tPage=${currentPage+1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <div class="col order-2">

                <form  action="${endPoint}">

                    <input type="hidden" name="currentPage" value="${currentPage}">

                    <div class="form-group">
                        <div class="row">
                            <div class="col-1">

                            </div>
                            <div class="col-4">
                                <label for="records" >Records per page:</label>
                            </div>
                            <div class="col">
                                <select class="form-control bg-transparent" id="records" name="recordsPerPage">
                                    <option type="hidden" value="" selected>${recordsPerPage}</option>
                                    <option value="3" >3</option>
                                    <option value="6" >6</option>
                                    <option value="9">9</option>
                                </select>
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



