<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!--네비게이션 바-->

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
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
        <c:forEach items="${todos}" var="todo">
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
    <a href="add-todo" class="btn btn-success">추가</a>

</div>

<%@ include file="common/footer.jspf"%>