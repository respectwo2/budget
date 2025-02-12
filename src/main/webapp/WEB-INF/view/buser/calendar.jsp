<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="s" value="${ start.getDayOfWeek().getValue() }" />
<c:set var="e"
	value="${ start.withDayOfMonth(start.lengthOfMonth()).getDayOfMonth() }" />
<!DOCTYPE html>
<html>
<style>
.daytotal {
	width: 18px;
}
</style>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta charset="UTF-8">
<title>MyCalendar</title>
<link href="${path}/resources/css/calendar.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="box">
			<div class="month">
				<<<<<<< HEAD

				<p class="year">${ start.getYear() }<span
						style="font-size: 14px">년</span>
				</p>
				<button style="margin-right: 60px"
					onclick="prev(${start.getYear()}, ${start.getMonthValue()})">
					<img alt="" src="${path}/resources/images/Polygon1.svg">
				</button>

				<span style="font-size: 24px;">${ start.getMonthValue() }</span>월
				<button style="margin-left: 60px">
					<img alt="" src="${path}/resources/images/Polygon2.svg">
					=======
					<p class="year">${ start.getYear() }<span
							style="font-size: 14px">년</span>
					</p>
					<button style="margin-right: 60px"
						onclick="prev(${start.getYear()}, ${start.getMonthValue()}, 1)">
						<img alt="" src="${path}/resources/images/Polygon1.svg">
					</button>

					<span style="font-size: 24px;">${ start.getMonthValue() }</span>월
					<button style="margin-left: 60px"
						onclick="next(${start.getYear()}, ${start.getMonthValue()}, 1)">
						<img alt="" src="${path}/resources/images/Polygon2.svg">
						>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
					</button>
					<div class="total">${arr[0]}</div>
			</div>


			<div class="week">
				<div class="w" style="color: #FF3535;">일</div>
				<div class="w">월</div>
				<div class="w">화</div>
				<div class="w">수</div>
				<div class="w">목</div>
				<div class="w">금</div>
				<div class="w" style="color: #3269F5;">토</div>
			</div>
			<div class="day">
				<<<<<<< HEAD
				<c:forEach var="i" begin="1" end="${s}" step="1">
					<button class="blankbtn">
						<div class="btn">
							<p></p>
						</div>
					</button>
				</c:forEach>

				<c:forEach var="k" begin="1" end="${e}" step="1">
					<button class="daybtn">
						=======
						<c:if test="${s != 7}">
							<c:forEach var="i" begin="1" end="${s}" step="1">
								<button class="blankbtn">
									<div class="btn">
										<p></p>
									</div>
								</button>
							</c:forEach>
						</c:if>
						<c:forEach var="k" begin="1" end="${e}" step="1">

							<%-- <button class="daybtn" onclick="viewEvent('${start.getYear()}-${String.format('%02d', start.getMonthValue())}-${String.format('%02d', k)}')">
 --%>
							<button class="daybtn"
								onclick="location.href = '/buser/MyCalendar?year=${start.getYear()}&&month=${start.getMonthValue()}&&day=${k}'">
								>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
								<div class="btn">
									<c:choose>
										<c:when test="${k == pick.getDayOfMonth()}">
											<span class="pick">${k}</span>
										</c:when>							
<<<<<<< HEAD
								<c:when test="${k == now.getDayOfMonth()}">
=======
								<c:when
												test="${start.getMonthValue() == now.getMonthValue() && k == now.getDayOfMonth()}">
>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
									<span style="color: #F87670">${k}</span>
											</c:when>
											<c:when test="${(k+s)%7 == 0 or (k+s)%7 == 1}">
												<span style="color: #8CA1B6">${k}</span>
											</c:when>
											<c:otherwise>
												<span>${k}</span>
											</c:otherwise>
									</c:choose>
									<c:if test="${arr[k] != 0}">
<<<<<<< HEAD
								<div class="daytotal">${arr[k]}</div>
=======
								<div class="daytotal">
											<span style="font-size: 10px;">${arr[k]}</span>
										</div>
>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
							</c:if>
								</div>

							</button>
						</c:forEach>
			</div>
		</div>
		<<<<<<< HEAD
	</div>

	<c:forEach items="${dayConsumes}" var="consume">
		${consume}
	</c:forEach>
	=======

	</div>

	<div class="dayconsumes">
		<c:forEach var="consume" items="${dayConsumes}">
			<div class="consumebox">${consume}</div>
		</c:forEach>


	</div>
	>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574

	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"> 
	
<<<<<<< HEAD
		function prev(y, m){
			let month = m - 1; let year = y
=======
		function prev(y, m, d){
			console.log(d)
			let month = m - 1; let year = y; let day = d;
>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
			if (month == 0){
				month = 12
				year -= 1
			}
			
<<<<<<< HEAD
			link = "/MyCalendar?year="+year+"&&month="+month
=======
			link = "/buser/MyCalendar?year="+year+"&&month="+month+"&&day="+day;
			location.href = link;
		}
		
		function next(y, m, d){
			let month = m + 1; let year = y; let day = d;
			if (month == 13){
				month = 1 
				year += 1
			}
			
			link = "/buser/MyCalendar?year="+year+"&&month="+month+"&&day="+day;
>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
			location.href = link;
		}
	
/* 		function prev(y, m){
			let month = m - 1; let year = y
			if (month == 0){
				month = 12
				year -= 1
			}
	
			$.ajax({
				url: "/calendar/"+year+"/"+month,
				type: "GET",
				data: {
					year: year,
					month: month
				},
				success: function(response){
					console.log("success")
				}	
			})
		} */
		
<<<<<<< HEAD
=======
		/* 	    function viewEvent(day) {
        location.href = "/consume/grouplist/" + day;
    }
	 */
		
>>>>>>> 265b59afd5f9af0be0a5c0a74bb1dd0593076574
    </script>
</body>
</html>