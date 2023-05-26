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