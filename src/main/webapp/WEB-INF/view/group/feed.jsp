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
var = ${group.g_no}
bgm_no

location.href=“/bgm/now” + var;

<c:forEach items="${consumes}" var="consume">
<tr>
	<td>${consume.user_name}</td>
    <td>${consume.c_date}</td>
	<td>${consume.c_money}</td>
	<td>${categoryMap.get(consume.c_categoryid)}</td>
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