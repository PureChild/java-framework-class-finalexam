<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update</title>
    </head>

    <body>
        <h1> 사용자 정보 수정 </h1>

        <div class="container">
            <form action="/member/updateProc" method="post"  enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">이름</label>
                    <input type="text" class="form-control" id="name" name="name" value="${detail.name}">
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="text" class="form-control" id="password" name="password" value="${detail.password}">
                </div>
                <div class="form-group">
                    <label for="photo">프로필사진</label>
                    <input type="file" class="form-control" id="photo" name="photo"></input>
                </div>
                <input type="hidden" name="id" value="${detail.id}"/>
                <%--<input type="input" name="id" value="${id}"/>--%>
                <button type="submit" class="btn btn-primary">수정</button>
            </form>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
