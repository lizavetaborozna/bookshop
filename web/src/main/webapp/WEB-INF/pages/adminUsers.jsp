<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
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
                <li><a  href="${pageContext.request.contextPath}/admin/chartPie">Круговая диаграмма
                </a>
                </li>
            </ul>
        </li>
        <li>
            <a  href="${pageContext.request.contextPath}/admin/report">Отчет
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logOut">Выход (${sessionScope.user})
            </a>
        </li>
    </ul>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th>№</th>
        <th> Логин</th>
        <th>Статус</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listAllUsers}" var="user" varStatus="i">
        <tr>
            <th scope="row">${i.count}</th>
            <td>${user.login}</td>
            <td>${user.role} </td>
            <form action="${pageContext.request.contextPath}/admin/users/delete" method="post" class="frm">
                <td>
                    <input type="hidden" value="${user.id}" name="idForDelete">
                    <button type="submit" class="btn btn-danger">Удалить</button>
                </td>
            </form>
        </tr>
        <tr></tr>
    </c:forEach>
    </tbody>
</table>
</form>
</body>
</html>