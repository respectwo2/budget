<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    </head>
    <body>
        <span><form><input type="search" id="searchInput"></form></span>
        <img id="searchIcon" onclick="goToSearchPage('searchInput')" src="images/돋보기.svg">
        <hr>

        <b id="myGroupBar"> 나의 그룹&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span id="createButton" onclick="goToGroupCreationPage()">만들기</span>
        </b>
        <br><br>

        <c:forEach items="${groupsWithMemberCount}" var="userGroup" >
            <div id="myGroup" onclick="goToGroupFeed(${userGroup.g_no})">${userGroup.g_name}&nbsp;&nbsp;&nbsp;
                <small id="peopleNum">${userGroup.memberCount}/${userGroup.g_maxpeople}명</small>&nbsp;&nbsp;&nbsp;
                <b>#${userGroup.g_tag}</b>
            </div>
            <br>
        </c:forEach>
        <br><br>

        <div>
            <span id="청소년" onclick="showGroupsByTag('청소년')"> #청소년&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span id="대학생" onclick="showGroupsByTag('대학생')"> #대학생&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span id="취준생" onclick="showGroupsByTag('취준생')"> #취준생&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <span id="직장인" onclick="showGroupsByTag('직장인')"> #직장인</span>
        </div>
        <br>

        <div>
            <c:forEach items="${groupList}" var="group">
                <b onclick="goToGroupInfoPage(${group.g_no})">${group.g_name}</b>&nbsp;&nbsp;&nbsp; <small>#${group.g_tag}</small>
                <br><br>
            </c:forEach>
        </div>

    <script>

        //검색된 그룹 보여주는 페이지로 이동하기
        function goToSearchPage(searchInput) {
            var searchTmp = document.getElementById(searchInput);
            var searchValue = searchTmp.value;

            location.href = "group/search?q=" + searchValue;
        }

        //그룹만들기 페이지로 이동
        function goToGroupCreationPage() {
             location.href = "group/create";
        }

        //그룹g_no의 피드로 이동
        function goToGroupFeed(gNo) {
             location.href = "group/feed?groupNo=" + gNo;
        }

        //그룹정보 페이지로 이동
        function goToGroupInfoPage(groupNo) {
            location.href = "/group/info?groupNo=" + groupNo;
        }

        //태그로 그룹 조회해서 그룹메인 보여주기
        function showGroupsByTag(tag) {
            location.href = "group/list?tag=" + tag;
        }

    </script>
    </body>
</html>
