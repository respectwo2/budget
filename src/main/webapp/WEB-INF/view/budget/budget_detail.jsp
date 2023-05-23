<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>budget_detail</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
 	<div id="piechart" style="width: 900px; height: 500px;"></div>
	<h1>마이버찌 디테일 페이지</h1>
	
	<h3>나의 지출</h3>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	var dataArray=[
    		['Category', 'Money']
    		<c:forEach items="${consumeList}" var="c">
    			,['${c.c_categoryId}', ${c.c_money}]
    		</c:forEach>
    	];
    	var data = google.visualization.arrayToDataTable(dataArray);
        var options = {
          title: '내 소비패턴',
          colors: ['#3B82A1', '#43B8B1', '#4D97ED', '#FF9900', '#FFA8A4']
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
	<c:forEach items="${consumeList}" var="c">
      <p>${c.c_money}</p>
      <p>${c.c_categoryId}</p>
   </c:forEach>
  
</body>
</html>