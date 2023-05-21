<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>budget_register</title>
</head>
<body>
	<h1>버찌 만들기</h1>
	<form action="">
		버찌 제목<br><input type="text" name="title"><br>
		시작 날짜<br><input type="date" name="start_date"><br>
		종료 날짜<br><input type="date" name="end_date"><br>
		버찌 금액<br><img src="https://postfiles.pstatic.net/MjAyMzA1MTJfMjQ2/MDAxNjgzODc4NzgxNjM1.8vyGdkNPYNVXCn-mBbsqZ6wIC9FTEfaOAjtu6L_PW5Eg.Nw6j8Rh_rpMXu5-9fTBr2GNnFlCGGlJGIxwrFzb-D6cg.PNG.uuas5866/image.png?type=w580" width="25" height="25">
		<input type="number" name="goal"><br>		
		다짐 한마디<br><textarea name="comment" cols="30" rows="3"></textarea><br>	
		<button type="submit" name="budgetcommit">생성 완료</button>	
	</form>
</body>
</html>