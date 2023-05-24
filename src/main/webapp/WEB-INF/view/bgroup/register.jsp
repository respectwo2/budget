<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 등록</title>
</head>
<body>;
	<h1>그룹 만들기</h1>
	<form action="bgmform">
		그룹 명<br><input type="text" name="g_name"><br>
		그룹 인원<br><input type="text" name="g_maxpeople">(최대 30명)<br>
		그룹 설명<br><textarea name="g_content" cols="30" rows="3"></textarea><br>		
		해시 태그<br><input type="text" name="g_tag"><br>	
		<button type="submit" name="bgroupcommit">생성 완료</button>	
	</form>
</body>
</html>