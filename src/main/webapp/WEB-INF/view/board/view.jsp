<%--
  Created by IntelliJ IDEA.
  User: gyuha
  Date: 2023-12-12
  Time: 오전 7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="kr">
<script>

    function commentDel(id) {


        if (!confirm("정말로 삭제하시겠습니까?")) {
            return;
        }
        fetch('/api-comment/delete/' + id, {
            method: 'DELETE',

        })

            .then(response => {
                if (!response.ok) {
                    alert("삭제 실패");
                } else {
                    alert("삭제 되었습니다.");
                    location.reload();
                }

            })
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));


    }

    function commentCreate() {

        fetch('/api-comment/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                boardId: document.getElementById('id').value,
                content: document.getElementById('comment-input').value
            })

        }).then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            } else {

                location.reload();
            }

        })
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));

    }

    function fetchData() {
        let id = document.getElementById('id').value;

        fetch('/api-comment/get-list-by-id/' + id) // API 엔드포인트 주소
            .then(response => response.json())
            .then(data => {
                console.log(data)
                renderComments(data);
            })
            .catch(error => console.error('Error:', error));
    }

    // 댓글 데이터를 HTML로 변환하여 페이지에 삽입하는 함수
    function renderComments(comments) {
        const commentsContainer = document.querySelector('.comments');

        comments.forEach(comment => {

            let html = '<div class="comment">'

                + '<p>' + comment.content + '</p>'
                + '<button class="delete-button" onclick="commentDel(' + comment.commentId + ')">삭제</button>'
                + '</div>'
            commentsContainer.innerHTML += html

        });

    }

    // 페이지 로드 시 데이터를 불러오는 함수 실행
    document.addEventListener('DOMContentLoaded', function () {
        fetchData();
    });


    function update() {
        let id = document.getElementById('id').value;
        location.href = '/board/update/' + id;
    }

    function del() {
        let id = document.getElementById('id').value;
        if (!confirm("정말로 삭제하시겠습니까?")) {
            return;
        }
        fetch('/api-board/delete/' + id, {
            method: 'DELETE',

        })

            .then(response => {
                if (!response.ok) {
                    alert("삭제 실패");
                } else {
                    alert("삭제 되었습니다.")
                    location.href = "/board/";
                }

            })
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));

    }

</script>
<head>
    <meta charset="UTF-8">

    <title>게시글 보기</title>
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
            background-color: #2196f3; /* 색상 변경 */
            padding: 10px;
            text-align: center;
            font-size: 24px;
            color: white;
        }

        .post-content {
            background-color: #f9f9f9;
            padding: 20px;
            margin-bottom: 20px;
        }

        .button {
            background-color: #2196f3; /* 색상 변경 */
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

        .comments {
            background-color: #f2f2f2;
            padding: 10px;
            margin-top: 20px;
        }

        .comment {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .delete-button {
            background-color: lightcoral;
            color: white;
            padding: 5px 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .delete-button:hover {
            background-color: darkred;
        }

        .comment-form {
            margin-top: 20px;
        }

        .comment-input {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        .comment-submit {
            background-color: #2196f3; /* 색상 변경 */
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .comment-submit:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">게시글 보기</div>

    <div class="post-content">
        <h2>${dto.title}</h2>
        <p>${dto.content}</p>
        <button class="button" onclick="update()">수정</button>
        <button class="button" style="background-color: red;" onclick="del()">삭제</button>
        <button class="button">기타</button>
    </div>

    <input type="hidden" id="id" value="${dto.boardId}">

    <div class="comments">
        <h3>댓글</h3>
        <!-- 댓글 폼 -->
        <div class="comment-form">
            <textarea id="comment-input" class="comment-input" placeholder="댓글을 입력하세요"></textarea>
            <button class="comment-submit" onclick="commentCreate()">댓글 작성</button>
        </div>

    </div>
</div>
</body>
</html>