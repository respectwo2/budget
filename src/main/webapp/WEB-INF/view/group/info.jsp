<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>

    <body>
        그룹명: ${groupInfo.g_name}<br>
        필수태그: ${groupInfo.g_requiredTag}<br>
        추가태그: ${groupInfo.g_tag}<br>
        그룹리더: ${groupInfo.g_leaderName}<br>
        현재인원/${group.Info.g_maxpeople}명<br>
        <hr>
        그룹설명: ${groupInfo.g_content}
        <div id="groupJoinButton" onclick="groupJoin(${groupInfo.g_no})">가입하기</div>

        <script>
            function groupJoin(gNo) {

                var groupNo = gNo;
                var form = document.createElement("form");
                form.method = "POST";
                form.action = "/group/join";

                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "groupNo";
                input.value = groupNo;
                form.appendChild(input);

                document.body.appendChild(form);
                form.submit();
            }
        </script>
    </body>
</html>