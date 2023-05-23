<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>
    <body>
        <span><form><input type="search" id="searchInput"></form></div>
        <img id="searchIcon" onclick="goToSearchPage('searchInput')" src="img/돋보기.svg">
        <hr>

        <b id="myGroupBar"> 나의 그룹&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="createButton" onclick="goToGroupCreationPage()">만들기</span></b>
        <br><br>

        <c:forEach items="${userGroups}" var="userGroup" >
            <div id="myGroup" onclick="goToGroupFeed(${userGroup.g_no})">${userGroup.g_name}&nbsp;&nbsp;&nbsp;
                <small id="peopleNum">현재인원/${userGroup.g_maxpeople}명</small>&nbsp;&nbsp;&nbsp;
                <b>#${userGroup.g_tag}</b>
            </div>
            <br><br><br>
        </c:forEach>

        <span id="청소년">#청소년</span>
        <span id="대학생">#대학생</span>
        <span id="취준생">#취준생</span>
        <span id="직장인">#직장인</span>

    <script>
        function goToSearchPage(searchInput) {
            var searchTmp = document.getElementById(searchInput);
            var searchValue = searchTmp.value;

            location.href="group/search?q=" + searchValue;
        }

        function goToGroupCreationPage() {
             location.href="group/join";  //그룹만들기 페이지로 이동
        }

        function goToGroupFeed(gNo) {
             location.href="group/feed?groupNo=" + gNo;  //그룹g_no의 피드로 이동
        }

        function showGroupsByTag() {

        }
    </script>
    </body>
</html>