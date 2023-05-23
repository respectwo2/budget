<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>

    <body>
        <c:forEach items="${groupsBySearch}" var="group" >
            <div onclick="goToGroupInfoPage(${group.g_no})">그룹명: ${group.g_name}, 필수태그: ${group.g_requiredTag}, 작성한 태그: ${group.g_tag}</div>
        </c:forEach>

        <script>
            function goToGroupInfoPage(groupNo) {
                location.href = "/group/info?groupNo=" + groupNo;  // 그룹정보 페이지로 이동
            }
        </script>
    </body>
</html>