<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы для администратора</title>
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
<h3 class="display-3" style="text-align: center">Ваш отчет сформирован  в файл формата pdf</h3>
<p> </p>
<br>
<p>
    <span>  Выручка с ВЫПОЛНЕНЫХ заказов составляет : ${sessionScope.sums}</span> <span> BYN</span>
</p>
<br>
  <p>
      <span>  Будущая выручка с заказов со статусов ОЖИДАНИЯ : ${sessionScope.sums1}</span> <span> BYN</span>
  </p>
<input type="hidden" id="categories" value="${categories}">
</body>
</html>
