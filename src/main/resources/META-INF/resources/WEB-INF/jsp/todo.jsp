<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- JSTL 스텐다드 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>투 두 추가</title>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <h1>투 두 리스트 계획 추가</h1>
        <form:form method="post" modelAttribute="todo">
            Description: <form:input type="text" path="description"
                                required="required"/>
            <!--id와 done이 null로 들어와서 히든 변수로 자동 입력-->
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type="submit" class="btn-success"/>
            <p><form:errors path="description" cssClass="text-warning"/></p>
        </form:form>
    </div>
    <script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
    <script src="webjars\jquery\3.6.0\jquery.min.js"></script>
    </body>
</html>