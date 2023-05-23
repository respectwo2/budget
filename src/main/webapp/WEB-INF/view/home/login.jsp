<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>버찌(budget)</h1>
	<span>버찌를 등록하고 절약을 실천해보세요!</span>
	<br>
	<form action="login" method="post">
		<!-- 아이디 입력 -->
		<div>
			<label for="id">아이디</label> <input type="text" name="id">
		</div>
		<!-- 비밀번호 입력 -->
		<div>
			<label for="pwd">비밀번호</label> <input type="password"
				name="pwd">
		</div>

		<!-- 에러 메시지 출력 -->
		<%-- 로그인 실패 메시지 출력 --%>
		<c:if test="${not empty error}">
			<p>${error}</p>
		</c:if>

		<!-- 로그인 버튼 -->
		<button type="submit">로그인</button>
	</form>
	<a href="/Buser/signup">회원가입하기</a>
</body>
</html>