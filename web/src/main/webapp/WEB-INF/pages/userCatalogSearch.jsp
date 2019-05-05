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
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<header class="head">
</header>
<nav class="navbar navbar-light  bg-faded" style="background-color: #cbedf2;">
    <ul class="nav navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/user">Каталог <span
                    class="sr-only">(current)</span></a>
            <ul>
                <li><a  class="nav-link" href="${pageContext.request.contextPath}/user/sort" >Сортировать по стоимости</a></li>
            </ul>
            <ul>
                <li><a  class="nav-link" href="${pageContext.request.contextPath}/user/sale" >Спец предложение</a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/cart">Корзина ${sessionScope.number}</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/order">Заказы</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/user/card">Платежные карты</a>
        </li>
        <li>
            <a class="nav-link" href="${pageContext.request.contextPath}/logOut">Выход
                <p>(${sessionScope.user})</p>
            </a>
        </li>
        <li>
            <form  method="post" class="nav-link search" action="${pageContext.request.contextPath}/user/search" >
                <input type="search" name="search">
                <input type="submit" value="Найти">
            </form>
        </li>
    </ul>
</nav>
<form action="${pageContext.request.contextPath}/user" method="post" class="frm">
    <c:forEach items="${listBooksSearch}" var="book">
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
