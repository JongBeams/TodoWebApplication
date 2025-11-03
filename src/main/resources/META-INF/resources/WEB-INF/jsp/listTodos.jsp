<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- JSTL 스텐다드 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>투 두 리스트</title>
</head>
<body>
<h1>장종범 웹</h1>
<h2>${name}의 투 두 리스트</h2>
<hr>
<h1>너의 지금 투 두 리스트는?</h1>
<!-- 테이블 구문 작성 방법-->
<table>
    <thead>
    <tr><!--제목 행-->
        <th>id</th>
        <th>내용</th>
        <th>목표일</th>
        <th>완료 여부</th>
    </tr>
    </thead>
    <tbody><!--데이터는 모드 tbody 안에-->
    <c:forEach items="${todos}" var ="todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div></div>
</body>
</html>