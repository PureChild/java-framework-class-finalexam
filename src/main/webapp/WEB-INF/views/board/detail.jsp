<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Board Detail</title>
    </head>

    <body>
        <h1> ${detail.title} </h1>
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

        <core:if test="${sessionScope.login.login_user ne null && sessionScope.login.login_user eq detail.user}">
            <button class="btn btn-primary" onclick="location.href='/update/${detail.bno}'">수정</button>
            <button class="btn btn-danger" onclick="location.href='/delete/${detail.bno}'">삭제</button>
        </core:if>

        <div class="container">
            <form action="/insertProc" method="post">
                <div class="form-group">
                    <img src="/getPhoto?url=${detail.url}${detail.filename}" alt="프로필사진" width="50px" height="50px">
                    <span>${detail.user}님이 작성하신 글입니다</span>
                </div>
                <div class="form-group">
                    <label>내용</label>
                    <p>${detail.content}</p>
                </div>
                <div class="form-group">
                    <p>${detail.cntLike} 명이 공감하였습니다</p>
                </div>
            </form>
            <core:if test="${sessionScope.login.login_user ne null && sessionScope.login.login_user ne detail.user}">
                <button class="btn btn-primary" onclick="location.href='/like/${detail.bno}'">공감</button>
            </core:if>
        </div>

        <%@ include file="../bootstrap.jsp" %>
    </body>
</html>
