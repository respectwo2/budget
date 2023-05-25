<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>
    <body>
        <h1>그룹 만들기</h1>
        	<form action="/group/create" method="post">
        		그룹 명<br><input type="text" name="g_name"><br>
        		그룹 인원<br><input type="text" name="g_maxpeople">(최대 30명)<br>
        		필수 태그<br><input type="text" name="g_rtag"><br>
        		해시 태그<br><input type="text" name="g_tag"><br>
        		그룹 설명<br><textarea name="g_content" cols="30" rows="3"></textarea><br>
        		<button type="submit" name="bgroupcommit">생성 완료</button>
        	</form>
    </body>
</html>