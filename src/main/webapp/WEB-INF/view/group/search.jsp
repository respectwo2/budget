<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>

    <body>
        <span><form><input type="search" id="searchInput"></form></span>
            <img id="searchIcon" onclick="goToSearchPage('searchInput')" src="/images/돋보기.svg">
        <hr>

        <c:forEach items="${groupsBySearch}" var="group" >
            <div onclick="goToGroupInfoPage(${group.g_no})">그룹명: ${group.g_name}, 필수태그: ${group.g_requiredTag}, 작성한 태그: ${group.g_tag}</div>
        </c:forEach>

        <script>
            //검색된 그룹 보여주는 페이지로 이동하기
            function goToSearchPage(searchInput) {
                var searchTmp = document.getElementById(searchInput);
                var searchValue = searchTmp.value;

                location.href = "/group/search?q=" + searchValue;
            }

            //그룹
            function goToGroupInfoPage(groupNo) {
                location.href = "/group/info?groupNo=" + groupNo;  // 그룹정보 페이지로 이동
            }

            //그룹 가입하기
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