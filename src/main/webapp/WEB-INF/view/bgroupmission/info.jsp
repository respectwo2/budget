<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>�׷� ����</title>
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
      <button class="back-page" type="button" onclick="location.href='/budget/budget_list'">
         <img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
      </button>
      <h1 class="my-budget">��ܹ�</h1>
   </div>
	<h1>�׷� �̼� ����</h1> <br>
	<a>�̼� �̸� : ${name}</a><br>
	<a>��ǥ �ݾ� : ${goal}</a><br>
<%-- 	<a>������ : ${start}</a><br> 
	<a>������ : ${end}</a><br>
 --%>
 	<a>�̼� ���� : ${content}</a><br>
	
</body>
</html>