<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Отели всего мира</title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:javascript src="jquery-3.3.1.min.js"/>
    <asset:javascript src="hotel.js"/>
</head>

<body>
<div class="container bg-info">
    <div class="row">
        <div class="col">
            Выберите страну:
        </div>
        <div class="col">
                <g:select name="selectedCountry"
                          optionKey="id"
                          value="${country.id}"
                          optionValue="name"
                          from="${countries}"/>
        </div>
    </div>
</div>

<div class="container">
    Страна ${country.name}, найденных отелей ${country.hotels.size()}
    <div class="row">
        <div class="col">
            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th>Отель</th>
                    <th>Звезды</th>
                    <th>Сайт</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${country.hotels}" var="hotel">
                    <tr>
                        <td class="d-none">${hotel.id}</td>
                        <td>${hotel.name}</td>
                        <td>${hotel.stars}</td>
                        <td>${hotel.webSite}</td>
                    </tr>
                </g:each>

                </tbody>
            </table>
        </div>

        <div class="col">
            <div id="add">
                <g:form action="addHotel">
                    <div>
                    <g:textField name="name" placeholder="Название"/>
                    </div>
                    <div>
                    <g:textField name="stars" placeholder="Рейтинг"/>
                    </div>
                    <div>
                    <g:textField name="webSite" placeholder="Сайт"/>
                    </div>
                    <div>
                    <g:textField name="countryId" placeholder="страна" value="${country.id}" class="d-none"/>
                    </div>
                    <div>
                    <g:submitButton name="Добавить"/>
                    </div>
                </g:form>
            </div>

            <div id="edit" class="d-none">
                <g:form action="updateHotel">
                    <div>
                    <g:textField name="id" value="" class="d-none"/>
                    </div>
                    <div>
                    <g:textField id="new_name" name="name" placeholder="Название"/>
                    </div>
                    <div>
                    <g:textField id="new_stars" name="stars" placeholder="Рейтинг"/>
                    </div>
                    <div>
                    <g:textField id="new_website" name="webSite" placeholder="Сайт"/>
                    </div>
                    <div>
                    <g:select
                            name="selectedCountryId"
                            optionKey="id"
                            value="${country.id}"
                            optionValue="name"
                            from="${countries}"/>
                    </div>
                    <div>
                    <g:submitButton name="Изменить"/>
                    </div>
                </g:form>
                <g:form action="deleteHotel">
                    <g:textField name="id" value="" class="d-none"/>
                    <g:submitButton name="Удалить"/>
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>