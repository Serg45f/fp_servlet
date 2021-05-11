<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>CONFERENCEHUB#1</title>
    <link rel="stylesheet" href="/img/style.css">
    <!--<link th:href="@{/css/fontawesome/fontawesome-all.min.css}" rel="stylesheet">-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>-->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-6">

    <div th:insert="~{navbar :: #navb}"></div>

<br/>
<br/>
<br/>
    <div sec:authorize="hasAuthority('USER')">


    <div layout:fragment = "replace_fragment">
            <a class="btn btn-primary" data-toggle="collapse" href="#collapseEvents" role="button" aria-expanded="false" aria-controls="collapseExample">
                Add new lecture
            </a>
            <div class="collapse" id="collapseEvents">
                <div class="form-group mt-3">
                    <form  method="post" enctype="multipart/form-data"  th:action="@{/lectures}" th:object="${lecture}">


                        <div class="form-group">
                            <input  type="text" class="form-control bg-transparent" name="name" placeholder="Name" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                            th:field ="${lecture.name}" />
                            <!--<th:block th:if="${#fields.hasErrors('name')}">
                                <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                            </th:block>-->
                        </div>


                        <div class="form-group">
                            <select type="text" class="form-control bg-transparent"  name="theme"  placeholder="Theme" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                                    th:field ="${lecture.theme}">
                                <div th:each ="theme : ${themes}">
                                    <option th:value="${{theme}}" th:text="${theme.getTheme()}">Theme</option>
                                </div>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control bg-transparent" name="description" placeholder="Description" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                                   th:field ="${lecture.description}"/>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control bg-transparent" name="shortDescription" placeholder="Short description" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                            th:field ="${lecture.shortDescription}"/>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control bg-transparent" name="duration" placeholder="Duration" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                                   th:field ="${lecture.duration}"/>
                        </div>

                        <div class="form-group">
                            <input id = "lectorSelect" type="hidden" class="form-control bg-transparent"  name="lector" placeholder="Lector" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                                    th:field ="${lecture.lector}">
<!--                                    <option th:each ="lector:${lectors}" th:value="${{lector}}" th:text="${lector.lastName}"-->
<!--                                            >Lector</option>-->
                            </input>
                        </div>

                        <div class="form-group">
                            <select type="text" class="form-control bg-transparent" name="language" placeholder="Language" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;"
                                    th:field ="${lecture.language}">
                                <div th:each ="language : ${languages}">
                                    <option th:value="${{language}}" th:text="${language.getLanguage()}">Theme</option>
                                </div>
                            </select>
                        </div>

                        <div class="form-group">
                            <div class="lecture-details">
                                <input type="file" name="file" id="lectureDetails" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;">
                                <label class="custom-file-label " for="lectureDetails" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;">Choose lecture file</label>
                            </div>
                        </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" name="status" th:value="${lecture.status}" th:field ="${lecture.status}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>


                </form>
                </div>
            </div>

                        <div id="lectureTable" class="table-responsive-sm  table-hover mt-3">
                            <table class="table table-responsive-sm  table-hover mt-3 round" style="background-image: url(/img/BG_1_LB.png); color: #FFEACE;">
                                <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                    <th scope="col">Theme</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Lector</th>
                                    <th scope="col">File</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr th:each="lecture : ${lectures}">
                                    <td th:text = "${lecture.name}">${lecture.name}</td>
                                    <td th:text = "${lecture.theme}">${lecture.theme}</td>
                                    <td th:text = "${lecture.shortDescription}">${lecture.shortDescription}</td>
                                    <td th:text = "${lecture.status}">${lecture.status}</td>
                                    <td th:text = "${lecture.lector.lastName}">${lecture.lector}</td>
                                    <td th:text = "${lecture.lectureFileName}" >${lecture.file}</td>
                                    <td>
                                        <a class="text-success" th:href="@{/lectures/edit/{id}(id=${lecture.id})}">Edit</a>
                                        <a>   </a>
                                    </td>
                                    <td><a class="text-danger" th:href="@{/lectures/delete/{id}(id=${lecture.id})}">Delete</a></td>
                                </tr>
                                </tbody>
                            </table>
                </div>

        </div>
    </div>
    </div>
</div>
</body>
</html>