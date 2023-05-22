<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
     <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>
<body>
미션: ${groupMissionBanner}
<hr>

<c:forEach items="${consumes}" var="consume">
<fmt:parseDate var="dateString" value="${consume.c_date}" pattern="yyyy-MM-dd HH:mm:SS" />
<fmt:formatDate var="date" value="${dateString}" pattern="yyyy년MM월dd일"/>
<tr>
	<td>${consume.user_name}</td>
    <td>${date}</td>
	<td>${consume.c_money}</td>
	<td>${categoryMap.get(consume.c_categoryId)}</td>
	<td>${consume.c_content}</td>
	<td>${consume.c_image}</td>
	<div onclick="goToComment(${consume.c_no})">댓글</div>
	<td>like ${consume.c_like}</td>
</tr>
<hr>
</c:forEach>

<script>
    function goToComment(consumeNo) {
        location.href="/group/feed/comment?consumeNo=" + consumeNo;  // 댓글 등록 및 조회 페이지로 이동
    }
</script>

</body>
</html>