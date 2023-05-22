<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
     <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>
<body>
미션: ${groupMissionBanner}

<c:forEach items="${consumes}" var="consume">
<fmt:parseDate var="dateString" value="${consume.c_date}" pattern="yyyy-MM-dd HH:mm:SS" />
<fmt:formatDate var="date" value="${dateString}" pattern="yyyy년MM월dd일"/>

<tr>
	<td>${consume.user_name}</td>
    <td>${date}</td>
	<td>${consume.c_money}</td>
	<td>${consume.categoryId}
	<td>${consume.c_content}
	<td>${consume.c_image}
</tr>
</c:forEach>
</body>
</html>
