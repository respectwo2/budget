<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
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
     <c:forEach items="${userGroups}" var="userGroup">
           <tr>
             <td>${userGroup.g_no}</td>
             <td><a href="group/feed?groupNo=${userGroup.g_no}">${userGroup.g_name}</a></td>
             <td>${userGroup.g_maxpeople}</td>
             <td>${userGroup.g_tag}</td>
             <td>${userGroup.g_leader}</td>
             <td>${userGroup.g_date}</td>
             <td>${userGroup.g_content}</td>
           </tr>
     </c:forEach>
   </tbody>
 </table>
 </body>
 </html>
// 작동 확인 완료!


