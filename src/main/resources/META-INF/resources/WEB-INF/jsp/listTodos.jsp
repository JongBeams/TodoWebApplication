<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- JSTL 스텐다드 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>투 두 리스트</title>
    <!--스타일 시트 파일은 헤드에 추가-->
    <!--경로 : webjars\bootstrap\5.1.3\css\bootstrap.min.css-->
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
<h1>장종범 웹</h1>
<h2>${name}의 투 두 리스트</h2>
<hr>
<h1>너의 지금 투 두 리스트는?</h1>
<!-- 테이블 구문 작성 방법-->
<table class="table">
    <thead>
    <tr><!--제목 행-->
        <th>내용</th>
        <th>목표일</th>
        <th>완료 여부</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody><!--데이터는 모드 tbody 안에-->
    <c:forEach items="${todos}" var ="todo">
        <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <!--쿼리 파라미터를 사용해 아이디 호출-->
            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">변경</a></td>
            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">삭제</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="add-todo" class ="btn btn-success">추가</a>

</div>
<!--자바 스크립트 파일은 바디를 닫기전 script로 추가 -->
<!--경로 : webjars\bootstrap\5.1.3\js\bootstrap.min.js-->
<!--경로 : webjars\jquery\3.6.0\jquery.min.js-->
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>