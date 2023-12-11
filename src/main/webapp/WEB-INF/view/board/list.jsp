<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gyuha
  Date: 2023-12-12
  Time: 오전 3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="kr">

<head>
    <meta charset="UTF-8">
    <title>게시판 메인 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-size: 14px; /* 글자 크기 조정 */
        }

        header {
            background-color: #2196f3;
            padding: 10px;
            text-align: center;
            font-size: 24px;
            color: white;
            width: 100%;
            position: absolute;
            top: 0;
        }

        table {
            border-collapse: collapse;
            font-size: 20px;

        }

        th, td {
            border: 1px solid #ddd;

            text-align: left;
            padding: 10px 100px 20px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        a {
            text-decoration: none;
            color: black;

        }

    </style>
</head>
<body>
<header>
    그린 컴퓨터
</header>
<table>
    <tr>
        <th>글 번호</th>
        <th>작성자</th>
        <th>글 제목</th>
        <th>작성 일자</th>
    </tr>
    <c:forEach items="${list}" var="board">
        <tr>
            <td>${board.postId}</td>
            <td>${board.title}</td>
            <td><a href="#">${board.content}</a></td>
            <td>${board.createdAt}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>