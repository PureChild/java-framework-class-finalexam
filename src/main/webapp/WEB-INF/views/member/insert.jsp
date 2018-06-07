<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Form</title>
    </head>

    <body>
        <h1> 회원가입 </h1>

        <div class="container">
            <form action="/member/insertProc" method="post">
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요.">
                </div>
                <div class="form-group">
                    <label for="photo">프로필사진</label>
                    <input type="file" class="form-control" id="photo" name="photo"></input>
                </div>
                <button type="submit" class="btn btn-primary">회원가입</button>
            </form>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
