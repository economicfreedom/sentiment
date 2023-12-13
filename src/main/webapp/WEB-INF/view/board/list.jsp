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
<script>
    function create() {
        location.href = "/board/create"
    }
</script>
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
    /* 기존 스타일 유지 */
        /* ... */

        .write-button {
            background-color: #2196f3; /* 기본 배경 색상 */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s; /* 부드러운 색상 전환 */
            position: fixed; /* 위치 고정 */
            bottom: 20px; /* 하단에서 20px */
            left: 20px; /* 왼쪽에서 20px */
        }

        .write-button:hover {
            background-color: #42a5f5; /* 마우스 오버시 색상 변경 */
        }
    </style>
</head>
<body>
<header>
    감정 분석 예제
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
            <td>${board.boardId}</td>
            <td>${board.author}</td>
            <td><a href="/board/view/${board.boardId}">${board.title}</a></td>
            <td>${board.createdAt}</td>
        </tr>
    </c:forEach>

</table>
<button onclick="create()" class="write-button">글 작성하기</button>
</body>
</html>