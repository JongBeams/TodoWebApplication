<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>장종범 웹</h1>

<div class="container">
<h2>로그인</h2>

<pre>${errorMessage}</pre>
<form action="/login" method="post">
    <div>
        <label for="id">ID : </label>
        <input id="id" name="name" type="text" required />
    </div>
    <div>
        <label for="password">비밀번호 : </label>
        <input id="password" name="password" type="password" required />
    </div>
    <button type="submit">로그인</button>
</form>

</div>

<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
</body>
</html>