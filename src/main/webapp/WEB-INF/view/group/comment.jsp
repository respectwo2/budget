<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
</head>
<body>
    <td>${consume.user_name}</td>
    <td>${consume.c_date}</td>
	<td>${consume.c_money}원</td>
	<td>${categoryMap.get(consume.c_categoryid)}</td>
	<td>${consume.c_content}</td>
	<td>${consume.c_image}</td>

	<hr>
	<form action="/group/feed/comment?consumeNo=${consume.c_no}" method="post">
	    <input type="text" name="inputComment">
	</form>

    <c:forEach items="${comments}" var="comment">
        <p>${comment.user_name}, 작성일: ${comment.cmn_date}, ${comment.cmn_content}</p>
    </c:forEach>

    <span onclick="goBack()" class="btn btn-primary" style="background-color: green">뒤로가기</span>

    <script>
        // 뒤로가기
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
