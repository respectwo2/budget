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
	<!-- 홈화면에서 총소비 누르면 보여줄 리스트 -->
	<h1>내 소비 내역 리스트</h1>
	<h2>날짜 출력</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>소비 금액</th>
				<th>카테고리</th>

				<!-- 			<th>내 코멘트</th>
				<th>유저번호</th>
				<th>이미지</th> -->
			</tr>
		</thead>

		<tbody>
			<c:forEach var="consume" items="${csmList}" varStatus="loop">

				<tr>
					<td>${loop.count}</td>
					<%-- 
					<td>
						<a href="/consume/detail/${consume.c_no}">${consume.c_no}</a>
					</td> --%>
					<td><a href="/consume/detail/${consume.c_no}">${consume.c_money}</a>
					</td>
					<td>${consume.c_categoryid}</td>
					<%-- 
					<td>${consume.c_image}</td>
					<td>${consume.user_no}</td>
					<td>${consume.c_content}</td>
					 --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>