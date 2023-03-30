<!doctype html>
<html>
<head>
    <title>Поиск отеля</title>
</head>
<asset:stylesheet src="bootstrap.css"/>
<asset:javascript src="jquery-3.3.1.min.js"/>
<body>
<div class="h1">Добро пожаловать на сайт выбора отелей</div>

<a class="btn btn-primary" href="hotel">Отели</a>
<a class="btn btn-primary" href="country">Страны</a>
<div class="container">
    <div class="row">
        <form action="main">
            <div class="col">
                Выбрать страну
                <g:select name="selectedCountry"
                          optionKey="id"
                          value="${country.id}"
                          optionValue="name"
                          from="${countries}"/>
            </div>

            <div class="col">
                <g:textField name="filter" placeholder="Название отеля"/>
                <g:submitButton name="Найти"/>
            </div>
        </form>
    </div>

    <div class="row">
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th>Отель</th>
                <th>Звезды</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${hotels}" var="hotel">
                <tr>
                    <td class="d-none">${hotel.id}</td>
                    <td>${hotel.name}</td>
                    <td>${hotel.stars}</td>
                    <td><link><a href='${hotel.webSite}' class="btn btn-primary">Перейти на сайт</a></td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
