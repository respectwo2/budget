<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
</head>
<body>
    <fmt:parseDate var="dateString" value="${consume.c_date}" pattern="yyyy-MM-dd HH:mm:SS" />
    <fmt:formatDate var="date" value="${dateString}" pattern="yyyy년MM월dd일"/>

    <td>${consume.user_name}</td>
    <td>${date}</td>
	<td>${consume.c_money}</td>
	<td>${categoryMap.get(consume.c_categoryId)}</td>
	<td>${consume.c_content}</td>
	<td>${consume.c_image}</td>

	<hr>
	<form action="/group/feed/comment?consumeNo=${consume.c_no}" method="post">
	    <input type="text" name="inputComment">
	</form>


    <c:forEach items="${comments}" var="comment">
        <p>${comment.user_name}, 작성일: ${comment.cmn_date}, ${comment.cmn_content}</p>
    </c:forEach>


</body>
</html>
