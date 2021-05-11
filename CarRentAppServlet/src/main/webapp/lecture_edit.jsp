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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-6">

     <div th:insert="~{navbar :: #navb}"></div>

        <br/>

        <!--<div layout:fragment = "replace_fragment">-->
        <br>
        <h2 class="mt-4">Edit event</h2>
        <br>
     <div class="form-group mt-3">
          <form  method="post" enctype="multipart/form-data"  th:action="@{/events}" th:class = "${event}">

              <div class="form-group">
                  <input  type="text" class="form-control" name="name" placeholder="Name"
                          th:field ="${lecture.name}" />
                  <!--<th:block th:if="${#fields.hasErrors('name')}">
                      <div th:errorclass="invalid-input" th:errors="*{name}"></div>
                  </th:block>-->
              </div>


              <div class="form-group">
                  <select type="text" class="form-control"  name="theme"  placeholder="Theme"
                          th:field ="${lecture.theme}">
                      <div th:each ="theme : ${themes}">
                          <option th:value="${{theme}}" th:text="${theme.getTheme()}">Theme</option>
                      </div>
                  </select>
              </div>
              <div class="form-group">
                  <input type="text" class="form-control" name="description" placeholder="Description"
                         th:field ="${lecture.description}"/>
              </div>

              <div class="form-group">
                  <input type="text" class="form-control" name="shortDescription" placeholder="Short description"
                         th:field ="${lecture.shortDescription}"/>
              </div>

              <div class="form-group">
                  <input type="text" class="form-control" name="duration" placeholder="Duration"
                         th:field ="${lecture.duration}"/>
              </div>

              <div class="form-group">
                  <select id = "lectorSelect" type="text" class="form-control"  name="lectors" placeholder="Lector"
                          th:field ="${lecture.lector}">
                      <option th:each ="lector:${lectors}" th:value="${{lector}}" th:text="${lector.lastName}"
                      >Lector</option>
                  </select>
              </div>


              <div class="form-group">
                  <select type="text" class="form-control" name="language" placeholder="Language"
                          th:field ="${lecture.language}">
                      <div th:each ="language : ${languages}">
                          <option th:value="${{language}}" th:text="${language.getLanguage()}">Theme</option>
                      </div>
                  </select>
              </div>

              <div class="form-group">
                  <div class="lecture-details">
                      <input type="file" name="file" id="lectureDetails">
                      <label class="custom-file-label" for="lectureDetails">Choose file</label>
                  </div>
              </div>



              <a class="btn btn-primary" data-toggle="collapse" href="#collapseLectureTable" role="button" aria-expanded="false" aria-controls="collapseLectureTable">
                    Choose new lecturers
                </a>

                <div id="collapseLectureTable" class="collapse table-responsive-sm  table-hover mt-3">
                    <table class="table">
                        <thead>
                        <tr>

                            <th scope="col">Name</th>
                            <th scope="col">Theme</th>
                            <th scope="col">Lector</th>
                            <th scope="col">Choice</th>

                        </tr>
                        </thead>

                        <tbody>
                        <tr th:each="lecture : ${lectures}">

                            <th th:text = "${lecture.name}" >${lecture.name}</th>
                            <th th:text = "${lecture.theme}">${lecture.theme}</th>
                            <th th:text = "${lecture.lector}">${lecture.lector}</th>
                            <input type="checkbox"/>

                        </tr>
                        </tbody>
                    </table>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="hidden" value="${event.id}" name="id">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
        </form>
    </div>

</div>

</body>
</html>
