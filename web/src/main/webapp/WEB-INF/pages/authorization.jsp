<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/authorization.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"
          type="image/x-icon">
</head>
<body>
<div class="menu" style="background-color: #cbedf2">
    <ul id="nav">
        <li>
            <a href="${pageContext.request.contextPath}/">MyBook.by</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/registration">Регистрация</a>
        </li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/" method="post" class="frm" style="margin: 0 auto">
    <br/>
    <div class="form-group">
        <label for="usr">Логин:</label>
        <input type="text" class="form-control" id="usr" name="username" placeholder="Введите логин">
    </div>
    <div class="form-group">
        <label for="psw">Пароль:</label>
        <input type="password" class="form-control" id="psw" name="password" placeholder="Введите пароль">
    </div>
    <button type="submit" id="popover" class="btn btn-default">Войти</button>
</form>
<c:if test="${sessionScope.info!=null}">
    <div style="color: #ff0000">
        <p style="margin-left: 5%">Информация:</p>
        <c:forEach var="error" items="${sessionScope.info}">
            <p style="margin-left: 5%">● ${error}</p>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
