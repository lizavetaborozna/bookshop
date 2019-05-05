<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавление карты</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainBook.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<header class="head">
   </header>
<div class="menu" style="background-color: #cbedf2">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/user">Каталог <span class="sr-only">(current)</span></a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/sort">Сортировать по стоимости</a></li>
                <li><a href="${pageContext.request.contextPath}/user/sale">Спец предложение</a></li>
            </ul>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/cart">Корзина ${sessionScope.number}</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/order">Заказы</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/card">Платежные карты</a>
        </li>
        <%--        <li>--%>
        <%--            <form class="search" action="${pageContext.request.contextPath}/user/search">--%>
        <%--                <input type="search" name="text">--%>
        <%--                <input type="submit" value="Найти">--%>
        <%--            </form>--%>
        <%--        </li>--%>
        <li>
            <a href="${pageContext.request.contextPath}/logOut">Выход (${sessionScope.user})
            </a>
        </li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/user/card/add" method="post" class="frm">
    <br/>
    <div class="form-group">
        <label for="num">Номер карты:</label>
        <input type="text" class="form-control" id="num" name="numberCard" placeholder="Введите номер карты:">
    </div>
    <div class="form-group">
        <label for="month">Месяц:</label>
        <input type="text" class="form-control" id="month" name="month" placeholder="Введите месяц:">
    </div>
    <div class="form-group">
        <label for="year">Год:</label>
        <input type="text" class="form-control" id="year" name="year" placeholder="Введите год:">
    </div>
    <div class="form-group">
        <label for="description">Описание:</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="Введите описание:">
    </div>
    <button type="submit" id="popover" class="btn btn-success">Добавить</button>
</form>
</body>
</html>
