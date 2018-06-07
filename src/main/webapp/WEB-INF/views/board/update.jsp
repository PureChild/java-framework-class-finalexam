<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Board Update</title>
    </head>

    <body>
        <h1> 게시글 수정 </h1>

        <div class="container">
            <form action="/updateProc" method="post">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="수정할 제목을 입력하세요">
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" id="content" name="content" placeholder="수정할 내용을 입력하세요"></textarea>
                </div>
                <input type="hidden" name="bno" value="${detail.bno}"/>
                <button type="submit" class="btn btn-primary">수정</button>
            </form>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
