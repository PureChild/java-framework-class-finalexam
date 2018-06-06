<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Detail</title>
    </head>

    <body>
        <h1> 회원정보 </h1>

        <button class="btn btn-primary" onclick="location.href='/update/${detail.id}'">수정</button>
        <button class="btn btn-danger" onclick="location.href='/delete/${detail.id}'">삭제</button>

        <div class="container">
            <form action="/insertProc" method="post">
                <div class="form-group">
                    <label>이름</label>
                    <p>${detail.name}</p>
                </div>
                <div class="form-group">
                    <label>비밀번호</label>
                    <p>${detail.password}</p>
                </div>
                <div class="form-group">
                    <label>프로필사진</label>
                    <p>${detail.photo}</p>
                </div>
            </form>
        </div>
    </body>
</html>
