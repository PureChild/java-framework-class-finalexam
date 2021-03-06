<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Form</title>
    </head>

    <body>
        <h1> 글쓰기 </h1>

        <div class="container">
            <form action="/insertProc" method="post">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요."></textarea>
                </div>
                <div class="form-group">
                    <input type="hidden" name="user" value="${sessionScope.login.login_user}"/>
                </div>
                <button type="submit" class="btn btn-primary">작성</button>
            </form>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
