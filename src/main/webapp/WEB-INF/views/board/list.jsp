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
        <h1>게시글 목록</h1>
        <button class="btn btn-primary" onclick="location.href='/insert'">글쓰기</button>

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