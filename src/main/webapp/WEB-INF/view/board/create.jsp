<%--
  Created by IntelliJ IDEA.
  User: gyuha
  Date: 2023-12-12
  Time: 오후 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script>

    function test() {
        let title = document.getElementById('title');
        let content = document.getElementById('content');

        if (title.value.length === 0) {

            title.focus()
            alert('제목을 입력해주세요');
            return;
        }
        if (content.value.length === 0) {
            content.focus()
            alert('내용을 입력해주세요');
            return;
        }


        fetch('/api-board/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: title.value,
                content: content.value
            })

        }).then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }else {
                alert("글이 작성되었습니다.")
                location.href='/board/'
            }

        })
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));
    }


</script>
<head>
    <title>글 작성하기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            font-size: 14px;
        }

        .container {
            width: 80%;
            margin: 0 auto;
        }

        .header {
            background-color: skyblue;
            padding: 10px;
            text-align: center;
            font-size: 24px;
            color: white;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .button {
            background-color: lightblue;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">글 작성하기</div>
    <input type="text" class="input-field" placeholder="제목을 입력하세요" id="title">
    <textarea class="input-field" placeholder="내용을 입력하세요" rows="10" id="content"></textarea>
    <button type="button" class="button" onclick="test()">글 작성</button>
</div>
</body>
</html>