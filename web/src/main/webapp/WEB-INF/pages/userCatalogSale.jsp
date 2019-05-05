<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Главная</title>
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
<form action="${pageContext.request.contextPath}/user" method="post" class="frm">
    <c:forEach items="${listBooksSale}" var="book">
        <div class="row">
            <div>
                <div class="col-lg-6">
                    <img src="/resources/images/books/${book.imageName}.jpg" alt=${book.name} class="im">
                    <div class="caption">
                        <span class="title">${book.name}</span>
                        <span class="info">Автор: ${book.author}<br/>
                        Жанр: ${book.genre}<br/>Цена: ${book.price} BYN</span>
                    </div>
                </div>
                <br/>
                <div class="test">
                    <button type="submit" class="btn btn-default" name="bookImageName" value="${book.imageName}">
                        Добавить в корзину
                    </button>
                </div>
            </div>
        </div>
    </c:forEach>
</form>
</body>
</html>
