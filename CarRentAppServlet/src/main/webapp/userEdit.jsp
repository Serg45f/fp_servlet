<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate = "~{index}">

<body>
<div class="bg-gradient-info" layout:fragment = "replace_fragment">
    <br>
    <br>
    <br>
    <H3>User editor</H3>

<form action="/user/edit" method = "post" class="${user}">
    <input type="text" th:value="${user.email}" name="email">
    <input type="text" th:value="${user.firstName}" name="firstName">
    <input type="text" th:value="${user.lastName}" name="lastName">


    <div th:each="role : ${roles}">
        <label><input type="checkbox" th:name="${role}" th:text = "${role.getAuthority()}"
                       th:checked="${#sets.contains(user.getRoles(),role)}">  Role</label>
    </div>
    <td >
<!--        accept=".txt,.css,.html,.docx,.pdf"-->
        <textarea id="js-textarea"></textarea>
        <input type="file" id="js-file" th:value = "@{/resume/{path}(path=${user.resume})}" style="display:none" onchange="handleFiles(this.files)">
        <a id="fileSelect" th:href = "@{/resume/{path}(path=${user.resume})}" target_parent>
            Resume
        </a>

    </td>
    <input type="hidden" th:value="${user.id}" name="userId">
    <!--<input type="hidden" th:value="${_csrf.token}" name="_csrf">-->
    <button type = "submit">Save</button>
</form>


<!--<form method="post">-->
<!--    <textarea id="js-textarea"></textarea>-->
<!--    <input type="file" id="js-file" accept=".txt,.css,.html">-->
<!--</form>-->
<style type="text/css">
textarea {
	width: 100%;
	height: 400px;
	margin-bottom: 25px;
}
</style>

<script src="https://snipp.ru/cdn/jquery/2.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            alert( 'DOM готов' );
            $("fileSelect").click();
        });

    </script>
<script>
    var fileSelect = document.getElementById("js-file"),
    fileElem = document.getElementById("fileElem");

    fileSelect.addEventListener("click", function (e) {
    if (fileElem) {
    fileElem.click();
    }
    e.preventDefault(); // предотвращает перемещение к "#"
    }, false);
</script>
<script>
$("#js-file").change(function(){
	var reader = new FileReader();
	reader.onload = function(e){
		$("#js-textarea").val(e.target.result);
	};
	reader.readAsText($("#js-file")[0].files[0], "UTF-8");
});

</script>
</div>



<