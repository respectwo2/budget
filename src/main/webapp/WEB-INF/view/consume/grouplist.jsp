<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 상세 소비 내역</title>
</head>
<body>
	<h1>그룹원 소비 내역 리스트</h1>
	<h2>날짜 출력</h2>
	<table>
		<thead>
			<tr>
				<th>닉네임</th>
				<th>소비 금액</th>
				
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="member" items="${member}"  varStatus="i">
	                <tr>
	                    <td>${member}</td>
	                    <td>${membercs[i.index]}</td>
	                </tr>
	            </c:forEach>
		</tbody>
	</table>
</body>
</html>