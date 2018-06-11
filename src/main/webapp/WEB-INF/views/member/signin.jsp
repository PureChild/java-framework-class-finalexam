<%--
  Created by IntelliJ IDEA.
  User: SeungsooLee
  Date: 2018-06-11
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>로그인페이지</title>
    <script>
        $(document).ready(function(){
            $("#btnSignIn").click(function(){
                var userName = $("#name").val();
                var userPw = $("#password").val();
                if(userName == ""){
                    alert("이름을 입력하세요.");
                    $("#name").focus(); // 입력포커스 이동
                    return; // 함수 종료
                }
                if(userPw == ""){
                    alert("비밀번호를 입력하세요.");
                    $("#password").focus();
                    return;
                }
                // 폼 내부 데이터 전송
                document.form.action="${path}/member/logCheck"
                document.form.submit();
            });
        });
    </script>
</head>
<body>
<h1>로그인</h1>
<form name="form" method="post">
    <table border="1" width="400px">
        <tr>
            <td>아이디</td>
            <td><input name="name" id="name"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="button" id="btnSignIn">로그인</button>
                <c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
                </c:if>
                <c:if test="${msg == 'logout'}">
                    <div style="color: red">
                        로그아웃되었습니다.
                    </div>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>