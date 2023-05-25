<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>budget_detail</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
</style>
<link href="${path}/resources/css/budget_detail.css" rel="stylesheet">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	var dataArray=[
    		['Category', 'Money']
    		<c:forEach items="${consumeList}" var="c">
    			,['${c.c_category}', ${c.c_money}]
    		</c:forEach>
    	];
    	var data = google.visualization.arrayToDataTable(dataArray);
        var options = {
          colors: ['#3B82A1', '#43B8B1', '#4D97ED', '#FF9900', '#FFA8A4'],
          backgroundColor: 'transparent',
          chartArea: {width: '100%', height: '100%'},
          legend: {position: 'right'}
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
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
		<button class="back-page" type="button" onclick="location.href='/budget/budget_list'">
			<img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
		</button>
		<h1 class="my-budget">마이 버찌</h1>
	</div>
		
		
	<h3>나의 지출</h3>
	<c:forEach items="${consumeList}" var="c">
      <p>${c.c_money}</p>
      <p>${c.c_category}</p>
    </c:forEach>
 	<div id="piechart" style="width: 200px; height: 200px;"></div>
 	
	<div class="cherry">
		<img src="/resources/images/cherry.png">
	</div>
	<div class="budget-name">${bd_name}</div><br>
	<div class="budget-detail">목표금액:${bd_goal} 남은금액:${bd_goalleft} 남은기간:${bd_dateleft}</div>
	<div>${bd_start}</div>
	<div>${bd_end}</div>
  
</body>
</html>