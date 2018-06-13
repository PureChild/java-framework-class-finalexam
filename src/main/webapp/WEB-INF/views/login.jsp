<%--
  Created by IntelliJ IDEA.
  User: SeungsooLee
  Date: 2018-06-13
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> 로그인 </h1>

    <div class="container">
        <form action="/login_confirm" method="post">
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요.">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요.">
            </div>
            <button type="submit" class="btn btn-primary">로그인</button>
        </form>
    </div>

    <%@ include file="bootstrap.jsp" %>
</body>
</html>
