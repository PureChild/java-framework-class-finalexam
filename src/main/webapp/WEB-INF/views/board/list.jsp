<%@ page import="org.springframework.web.bind.annotation.SessionAttribute" %>
<%@ page import="org.springframework.web.context.request.SessionScope" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Board List</title>
    </head>

    <body>
        <h1>국민청원게시판</h1>
        <button class="btn btn-light" onclick="location.href='/'">홈으로</button>
        <button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>
        <core:choose>
            <core:when test="${sessionScope.login ne null}">
                <button class="btn btn-danger" onclick="location.href='/logout'">로그아웃</button>
                <p>${sessionScope.login.login_user}님 환영합니다</p>
                <button class="btn btn-success" onclick="location.href='/member/detail/${sessionScope.login.login_user}'">마이페이지</button>
            </core:when>
            <core:otherwise>
                <button class="btn btn-success" onclick="location.href='/login'">로그인</button>
                <button class="btn btn-info" onclick="location.href='/member/insert'">회원가입</button>
            </core:otherwise>
        </core:choose>
        <div class="container">
            <table class="table table-hover">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                </tr>
                <core:forEach var="l" items="${list}">
                    <tr onclick="location.href='/detail/${l.bno}'">
                        <td>${l.bno}</td>
                        <td>${l.title}</td>
                        <td>${l.user}</td>
                    </tr>
                </core:forEach>

            </table>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>