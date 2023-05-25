<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    
    <title>그룹 미션 현황</title>
</head>
<body>
	<h1></h1>
    <h4>${name}</h4>
    <a>목표 금액 : ${goal }</a><br>
    <a> 남은 일수 : ${remain }</a><br>
    <table>
 		
        <thead>
            <tr>
                <th></th>
                <th></th>
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