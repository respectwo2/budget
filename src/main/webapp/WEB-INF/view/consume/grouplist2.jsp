<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<title>그룹 상세 소비 내역</title>
</head>
<body>
	<h2> ${parsedDate}</h2>
	<h3>소비왕 순</h3>
        <c:forEach var="nickname" items="${consumeList}" varStatus="status">
        <h4>${nickname}</h4>
        <table>
            <thead>
                <tr>
                    <th>카테고리</th>
                    <th>소비 금액</th>
                    <th>소비 내역</th>
                    <th>좋아요</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${consumeMap[nickname]}">
                    <tr>
                        <td>${item.c_categoryId}</td>
                        <td>${item.c_money}</td>
                        <td>${item.c_content}</td>
                        <td>${item.c_like}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:forEach>
</body>
</html>