<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>���� ������ �׷� ���</title>
</head>
<body>

	<h1>�׷� ����Ʈ</h1>
	<h3>���� ������ �׷�</h3>
		<ul>
  <c:forEach var="index" begin="0" end="${names.size() - 1}">
    <li><a href="/bgroup/info?g_no=${nos[index]}">${names[index]}</a></li>
  </c:forEach>
</ul>
	

</body>
</html>