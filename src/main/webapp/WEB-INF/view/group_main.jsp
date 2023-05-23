<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 목록</title>
</head>
<body>
	<h1>그룹 리스트</h1>
	
	<p>총 그룹 갯수 : ${bgroup_list.size()}</p>
	<ul>
	<c:forEach items="${bgroup_list}" var="bgroup">
		<li>${bgroup.no} / ${bgroup.title} / 
	</c:forEach>
	</ul>	
</body>
</html>