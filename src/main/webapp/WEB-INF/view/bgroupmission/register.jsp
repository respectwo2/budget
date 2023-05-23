<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 미션 등록</title>
</head>
<body>
	<h1>그룹 미션 만들기</h1>
	<form action="/bgm/create" method="post">
		미션 이름<br><input type="text" name="bgm_name"><br>
		목표 금액<br><input type="text" name="bgm_goal"><br>
		미션 설명<br><textarea name="bgm_content" cols="30" rows="3"></textarea><br>		
		시작 일<br><input type="date" name="bgm_start"><br>	
		종료 일<br><input type="date" name="bgm_end"><br>	
		<button type="submit">생성</button>
	</form>
</body>
</html>






