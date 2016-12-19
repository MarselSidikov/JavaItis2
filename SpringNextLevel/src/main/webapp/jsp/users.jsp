<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/style.css" rel="stylesheet" type="text/css">
<html>
<head>
    <title>Title</title>
    <style>
        table {
            font-family: "Helvetica Neue", Helvetica, Arial;
            font-size: 50px;
            font-style: normal;
            width: 100%;
            border-spacing: 0;
        }
        th {
            background-color: #BA55D3;
            color: white;
        }
        td {
            text-align: center;
            color: #4B0082;
        }

        img.center {
            display: block;
            margin: 0 auto;
        }

        tr:nth-child(odd) {background-color: #DDA0DD}
    </style>
</head>
<body>
    <table>
    <%-- перечисляем заголовки таблицы --%>
        <tr>
            <th>Имя</th>
            <th>Возраст</th>
        </tr>
    <%-- forEach - JSP-тег, бегает по массиву элементов
    начинаем с нуля до countOfSalkeshlar
    --%>
        <c:forEach items="${userList}" var="user">
        <%-- вставляем строки --%>
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
            </tr>
    </c:forEach>
</table>
</body>
</html>
