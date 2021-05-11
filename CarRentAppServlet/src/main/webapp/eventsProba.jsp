<!DOCTYPE html>
<html  xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>ConferenceHall</title>
    <link rel="stylesheet" href="/static/style.css">
    <link th:href="@{/css/fontawesome/fontawesome-all.min.css}" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>

<h5 class="mt-2" >Current events </h5>

<br>
<br>



<div class="card" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Название карточки</h5>
        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Cras justo odio</li>
        <li class="list-group-item">Dapibus ac facilisis in</li>
        <li class="list-group-item">Vestibulum at eros</li>
    </ul>
    <div class="card-body">
        <a href="#" class="card-link">Card link</a>
        <a href="#" class="card-link">Another link</a>
    </div>
</div>

<!--<h5 class="mt-2" >Current events </h5>
<div>
    <div class="card-columns">

        <br>
        <br>

        <label style="margin-right: 1.5em" for="each"> th:each : </label>
        <table style="color: green" id="each">
        <tr th:each="event : ${events}">
            <div class="card my-1">

                <img src="/img/${event.picture}" class="card-img-top">

                <div class="m-2">
                    <h5 class="card-title">${event.name}</h5>
                    <div class="card-body">

                        <td th:text="${event.place}"></td>
                        <td th:text="${event.date}"></td>
                        <td th:text="${event.time}"></td>
                        <td th:text="${event.language}"></td>
                        <p class="card-text" th:text="${event.description}"></p>
                    </div>

                </div>
                <div class="card-footer text-muted" th:text="${event.price}" ></div>
                <a th:href="/registration" class="btn btn-primary">Registration</a>
                <a th:href="/eventEdit" class="btn btn-primary">Open</a>
            </div>


        </tr>
        </table>


</div>



</div>-->

</html>