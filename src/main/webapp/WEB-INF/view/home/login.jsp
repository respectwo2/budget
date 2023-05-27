<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="content">
		<div class="logoBox">
			<div class="Biglogo"><img style="width: 100%;" alt="" src="${path}/resources/images/logo_eng.png"></div>
			<div class="Smalllogo"><img style="width: 80px;" alt="" src="${path}/resources/images/logo_kor.png"><span>를 등록하고 <span style="color: #42AC9F;">절약</span>을 실천해보세요!</span></div>
		</div>
		<div class="form">
			<form action="login" method="post">
				<!-- 아이디 입력 -->
				<div class="formbox">
					<label for="id"></label> 
					<img class="formimg" alt="" src="${path}/resources/images/password.svg">
					<input type="text" name="id">
				</div>
				<!-- 비밀번호 입력 -->
				<div class="formbox">
					<label for="pwd"></label>
					<img class="formimg" alt="" src="${path}/resources/images/email.svg">
					<input type="password" name="pwd">
				</div>
		
		
				<!-- 로그인 버튼 -->
				<div class="loginbtn">
					<button type="submit">로그인</button>
					<!-- 에러 메시지 출력 -->
					<%-- 로그인 실패 메시지 출력 --%>
					<c:if test="${not empty error}">
						<p style="color: #3DAA9D;">이메일 혹은 비밀번호를 확인해주세요.</p>
					</c:if>
				</div>
				
			</form>
		</div>
		<div class="rgst">
			<div class="line">또는</div>
			<a href="/Buser/signup">회원가입하기</a>
			
		</div>
	</div>
</body>
</html>