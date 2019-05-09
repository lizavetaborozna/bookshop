<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Диаграммы</title>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/chart.js"></script>
<%--    <script src="${pageContext.request.contextPath}/resources/js/jquery-validate.js"></script>--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
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
<input type="hidden" id="sums" value="${sums}">
<input type="hidden" id="categories" value="${categories}">
<canvas id="myChart" width="300" height="300"></canvas>
<script>
    var massiv;
    var floatMassiv = new Array(2);
    massiv = $("#sums").val();
    var spMassiv = massiv.split(',');
    spMassiv[0] = spMassiv[0].split('[')[1];
    spMassiv[spMassiv.length - 1] = spMassiv[spMassiv.length - 1].split(']')[0];
    floatMassiv[0] = parseFloat(spMassiv[0]);
    floatMassiv[1] = parseFloat(spMassiv[1]);
    floatMassiv[2] = parseFloat(spMassiv[2]);

    var ctx = document.getElementById("myChart").getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Роман", "Драма", "Научный"],
            datasets: [{
                label: 'Диаграмма общей стоимости изделий по жанрам',
                data: floatMassiv,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            },
            responsive: true,
            maintainAspectRatio: false
        }
    });
</script>
</body>
</html>
