<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h4>회원가입</h4>
    <form action="signup" method="post">
        <div>
            <label for="user_id">사용자ID</label>
            <input type="text" name="user_id">
        </div>
        <div>
            <label for="user_pwd">비밀번호</label>
            <input type="password" name="user_pwd">
        </div>
        <div>
            <label for="user_pwd2">비밀번호 확인</label>
            <input type="password" name="user_pwd2">
        </div>
        <div>
            <label for="user_name">이름</label>
            <input type="text" name="user_name">
        </div>
        <div>
            <label for="user_nickname">닉네임</label>
            <input type="text" name="user_nickname">
        </div>
        <div>
            <label for="user_email">이메일</label>
            <input type="email" name="user_email">
        </div>
         <!-- 에러 메시지 출력 -->
        <%-- 아이디 중복 메시지 출력 --%>
        <c:if test="${not empty error}">
            <p>${error}</p>
        </c:if>
        
        <button type="submit">회원가입</button>
    </form>
</body>
</html>
