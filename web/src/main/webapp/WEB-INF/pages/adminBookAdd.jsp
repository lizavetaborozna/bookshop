<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добавление товара</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/chart.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-validate.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainBook.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<div class="menu" style="background-color: #cbedf2">
    <ul id="nav">
        <li><a href="/admin">Заказы</a>
        </li>
        <li><a href="/admin/add">Товары</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/users">Пользователи</a>
        </li>

        <li>
            <a href="#">Диаграммы</a>
            <ul>
                <li><a href="${pageContext.request.contextPath}/admin/chart">Столбчатая диаграмма стоимости</a></li>
                <li><a href="${pageContext.request.contextPath}/admin/chartPie">Круговая диаграмма
                </a>
                </li>
            </ul>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/report">Отчет
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logOut">Выход (${sessionScope.user})
            </a>
        </li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/admin/add" method="post" class="frm">
    <br/>
    <div class="form-group">
        <label for="name">Название книги:</label>
        <input type="text" class="form-control" id="name" name="nameBook" placeholder="Введите название книги:">
    </div>
    <div class="form-group">
        <label for="author">Автор:</label>
        <input type="text" class="form-control" id="author" name="author" placeholder="Введите автора:">
    </div>
    <div class="form-group">
        <label for="genre">Введите жанр:</label>
        <input type="text" class="form-control" id="genre" name="genre" placeholder="Введите жанр:">
    </div>
    <div class="form-group">
        <label for="price">Цена:</label>
        <input type="text" class="form-control" id="price" name="price" placeholder="Введите цену:">
    </div>
    <div class="form-group">
        <label for="image">Название картинки:</label>
        <input type="text" class="form-control" id="image" name="image" placeholder="Введите название картинки:">
    </div>
    <button type="submit" id="popover" class="btn btn-success">Добавить</button>
</form>
</body>
</html>
