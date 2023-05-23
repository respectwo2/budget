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
	<%@ include file="../navbar.jsp"%>
	<h1>상세 내역</h1>
	<h2>${csm_date_modify }</h2>
	<c:forEach var="entry" items="${categoryMap}">
		<c:set var="key" value="${entry.key}" />
		<c:set var="value" value="${entry.value}" />

		<c:if test="${key eq csm.c_categoryid}"> 
			${value}
		</c:if>
	</c:forEach>

	<br> ${csm.c_money }원
	<hr>
	${csm.c_content }
	<br> ${csm.c_image }

</body>
</html>