<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>

<body>
<table>
  <thead>
    <tr>
      <th>Group No</th>
      <th>Group Name</th>
      <th>Max People</th>
      <th>Group Tag</th>
      <th>Group Leader</th>
      <th>Group Date</th>
      <th>Group Content</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${groupList}" var="group">
      <tr>
        <td>${group.g_no}</td>
        <td>${group.g_name}</td>
        <td>${group.g_maxpeople}</td>
        <td>${group.g_tag}</td>
        <td>${group.g_leader}</td>
        <td>${group.g_date}</td>
        <td>${group.g_content}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
// 작동 확인 완료!



