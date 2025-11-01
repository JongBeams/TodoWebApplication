<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>
<h1>장종범 웹</h1>
<h2>로그인</h2>
<h3>${name}</h3>

<!-- 서버에서 request.setAttribute("error", "...") 주면 EL로 표시됨 -->
<div style="color:#c00;"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></div>

<form action="/login" method="post">
    <div>
        <label for="id">ID : </label>
        <input id="id" name="id" type="text" required />
    </div>
    <div>
        <label for="password">비밀번호 : </label>
        <input id="password" name="password" type="password" required />
    </div>
    <button type="submit">로그인</button>
</form>
</body>
</html>