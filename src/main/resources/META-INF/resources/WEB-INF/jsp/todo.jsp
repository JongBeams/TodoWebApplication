<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>

    <div class="container">
        <h1>투 두 리스트 계획</h1>
        <form:form method="post" modelAttribute="todo">
            <!--그룹화-->
            <fieldset class="m-3">
                <form:label path="description">내용</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="m-3">
                <form:label path="targetDate">목표일</form:label>
                <form:input type="text" path="targetDate" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
            <!--id와 done이 null로 들어와서 히든 변수로 자동 입력-->
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done"/>
            <input type="submit" class="btn-success"/>
            <p><form:errors path="description" cssClass="text-warning"/></p>
        </form:form>
    </div>

    <%@ include file="common/footer.jspf"%>

<!--현재 페이지에서만 적용-->
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
        language: 'ko',  // 한글 설정
        todayHighlight: true,  // 오늘 날짜 강조
        autoclose: true  // 날짜 선택 시 자동 닫기
    });
</script>