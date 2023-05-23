<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>

    <body>
        그룹명: ${groupInfo.g_name}
        필수태그: ${groupInfo.g_requiredTag}
        추가태그: ${groupInfo.g_tag}
        그룹리더: ${groupInfo.g_leaderName}
        <hr>
        그룹설명: ${groupInfo.g_content}
        <div id="groupJoinButton" onclick="groupJoin()">가입하기</div>


        <script>
            function goToSearchPage(searchInput) {
                 // 그룹가입하기로 post하고 그룹홈으로 이동하기
            }
        </script>
    </body>
</html>