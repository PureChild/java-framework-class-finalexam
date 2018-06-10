<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Board Detail</title>
    </head>

    <body>
        <h1> 게시판 </h1>

        <button class="btn btn-primary" onclick="location.href='/update/${detail.bno}'">수정</button>
        <button class="btn btn-danger" onclick="location.href='/delete/${detail.bno}'">삭제</button>

        <div class="container">
            <form action="/insertProc" method="post">
                <div class="form-group">
                    <label>제목</label>
                    <p>${detail.title}</p>
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <p>${detail.content}</p>
                </div>
                <div class="form-group">
                    <label>작성자</label>
                    <p>${detail.user}</p>
                </div>
                <div class="form-group">
                    <label>공감</label>
                    <p>${detail.cntLike}</p>
                </div>
            </form>
            <button class="btn btn-primary" onclick="location.href='/like/${detail.bno}'">공감</button>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
