<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Корзина</title>

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
<c:choose>
    <c:when test="${sizeListCart!=0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Цена</th>
                <th>Добавить в заказы</th>
            </tr>
            </thead>
            <tbody>
            <form action="${pageContext.request.contextPath}/user/order/add" method="post" name="cart"
                  onsubmit="return validate();">
                <c:forEach items="${listCart}" var="book" varStatus="i">
                <tr>
                    <td>${i.count}</td>
                    <td>${book.name}</td>
                    <td>${book.price} BYN</td>
                    <td>
                        <input type="checkbox" value="${book.idbook}" name="idBook">
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="hidden" value="${sessionScope.user}" name="userName">
        <button type="submit" class="btn btn-success col-md-offset-10">К заказам</button>
        </form>
    </c:when>
    <c:otherwise>
        <h3 class="display-3" style="text-align: center">Корзина пуста</h3>
    </c:otherwise>
</c:choose>
</body>
</html>
