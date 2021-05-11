<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>ConferenceHall</title>
    <link rel="stylesheet" href="/img/style.css">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>

    <div th:insert="~{navbar :: #navb}"></div>
    <br>
    <br>
    <div class="container mx-auto my-auto" style="color:#ffffff;">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label"></label>
                <h2 class="mt-6 form-signing-hiding" >Lectors registration</h2>
            </div>
            <form accept-charset="UTF-8" enctype="multipart/form-data" method="post" th:action="@{/registration/lector}" th:object="${user}">

                    <div class="form-group mt-3">

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label"></label>
                            <div class="col-sm-6">
                                <a  type="text" th:text="#{reg.lect.text}">
                                    Speaker intro text
                                </a>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label"></label>
                                <input type="file" name="file" class="col-sm-6 col-form-label" id="speakerResume">
                                <label class="custom-file-label" for="speakerResume"
                                       th:text="#{reg.resume.text}">Add resume</label>
                        </div>

                        <div class="form-group row">
                             <label class="col-sm-2 col-form-label"></label>
                             <div class="col-sm-4">
                                 <a th:href="@{/lectures/new}" class="btn btn-transparent btn-outline-primary btn-lg btn-block"
                                    style="background-image: url(/img/BG_1_LB.png); color: #ffffff;" >Load lecture</a>
                             </div>
                        </div>


                    <input type="hidden" value="${user.id}" name="userId">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label"></label>
                        <a class="col-sm-4">
                            <button class="btn btn-lg btn-transparent btn-outline-primary btn-lg btn-block"
                                    style="background-image: url(/img/BG_1_LB.png); color: #ffffff;" type="submit">Submit</button>

                        </a>
                    </div>
                </div>


            </form>

        </div>
        </div>
    </div>

</body>
</html>
