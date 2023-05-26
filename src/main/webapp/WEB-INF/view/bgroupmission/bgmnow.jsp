<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <title>그룹 미션 현황</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');


    </style>
    <link href="${path}/resources/css/budget_detail.css" rel="stylesheet">
</head>
<body>
<%@ include file="../navbar.jsp"%>
<div class="top-rectangle">
    <div class="time">9:40</div>
    <div class="data">
        <img src="${pageContext.request.contextPath}/resources/images/data.svg" alt="SVG">
    </div>
    <div class="wifi">
        <img src="${pageContext.request.contextPath}/resources/images/wifi.svg" alt="SVG">
    </div>
    <div class="battery">
        <img src="${pageContext.request.contextPath}/resources/images/battery.svg" alt="SVG">
    </div>
    <button class="back-page" type="button" onclick="history.back()">
        <img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
    </button>
    <h1 class="my-budget">상단바</h1>
</div>

    <div class="container">
    <h4>${name}</h4>
    <div class="goal">목표 금액: ${goal}</div>
    <div class="remain">남은 일수: ${remain}</div>
    <div class="budget-list">
    				<% int itemCount=0; %>
    
        <c:forEach var="member" items="${member}" varStatus="i">
            <div class="member">
                <div class = "membercs">${member} ${membercs[i.index]}</div>
            </div>
            <% itemCount++; %>
            
        </c:forEach>
    <script>
					var container = document.querySelector('.container');
			        var budgetList = document.querySelector('.budget-list');
			        var itemCount = <%= itemCount %>;
			        container.style.height = budgetList.offsetHeight + (itemCount - 1) * 100 + 'px';
				</script>
    </div>
</div>

           <%--  <script>
					var container = document.querySelector('.container');
			        var budgetList = document.querySelector('.budget-list');
			        var itemCount = <%= itemCount %>;
			        container.style.height = budgetList.offsetHeight + (itemCount - 1) * 100 + 'px';
				</script> --%>
</body>
</html>
