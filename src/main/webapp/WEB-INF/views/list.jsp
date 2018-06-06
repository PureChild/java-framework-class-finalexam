<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
    </head>

    <body>
        <h1>사용자 목록</h1>
        <button class="btn btn-primary" onclick="location.href='/insert'">회원가입</button>

        <div class="container">
            <table class="table table-hover">
                <tr>
                    <th>번호</th>
                    <th>프로필사진</th>
                    <th>이름</th>
                </tr>
                <core:forEach var="l" items="${list}">
                    <tr onclick="location.href='/detail/${l.id}'">
                        <td>${l.id}</td>
                        <td>${l.photo}</td>
                        <td>${l.name}</td>
                    </tr>
                </core:forEach>

            </table>
        </div>
    </body>
</html>