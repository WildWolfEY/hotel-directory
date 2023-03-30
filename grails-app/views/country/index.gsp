<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<meta charset="utf-8">
<meta name="layout" content="main"/>
<asset:stylesheet src="bootstrap.css"/>
<asset:javascript src="jquery-3.3.1.min.js"/>
<asset:javascript src="country.js"/>
<head>
    <title>Страны</title>

</head>

<body class="card-body">

<div class="container">
    <div class="row">
        <div class="col">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>Страна</th>
                    <th>Столица</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${countries}" var="country">
                    <tr>
                        <td class="d-none">${country.id}</td>
                        <td>${country.name}</td>
                        <td>${country.capital}</td>
                    </tr>
                </g:each>

                </tbody>
            </table>
        </div>

        <div class="col">
            <div id="add">
                <g:form action="addCountry">
                    <g:textField name="name" placeholder="Название"/>
                    <g:textField name="capital" placeholder="Столица"/>
                    <g:submitButton name="Добавить"/>
                </g:form>
            </div>

            <div id="edit" class="d-none">
                <g:form action="updateCountry">
                    <g:textField name="id" value="" class="d-none"/>
                    <g:textField id="new_name" name="name" placeholder="Название"/>
                    <g:textField id="new_capital" name="capital" placeholder="Столица"/>
                    <g:submitButton name="Изменить"/>
                </g:form>
                <g:form action="deleteCountry">
                    <g:textField name="id" value="" class="d-none"/>
                    <g:submitButton name="Удалить"/>
                </g:form>
            </div>
        </div>
    </div>

</div>
</body>
</html>