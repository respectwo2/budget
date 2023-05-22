<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
        <link rel="stylesheet" href="css/groupHome.css"/>
    </head>

    <body>
        <div id="container">
            <div id="header">그룹</div>

            <div id="main">

                <div id="searchBox">
                    <div id="search"><form><input type="search" id="searchInput"></div></form>
                    <img id="searchIcon" onclick="showSearchedGroups(searchInput)" src="img/돋보기.svg">
                </div>

                <div id="myGroupBar"> 나의 그룹
                    <div id="createButton" onclick="goToGroupCreationPage()">만들기</div>
                </div>

                <div id="myGroupBox">
                    <c:forEach items="${userGroups}" var="userGroup" >
                        <div id="myGroup" onclick="goToGroupFeed(${userGroup.g_no})">${userGroup.g_name}<small id="peopleNum">인원수</small>
                            <img id="budgetBucketIcon" src="img/budgetBucketIcon.svg"></div>
                    </c:forEach>
                </div>

                <div id>

            </div>

            <div id="footer">

            </div>
        </div>
        <script>
            function showSearchedGroups(searchValue) {
                // var searchInput = document.getElementById("searchInput");
                // var searchValue = searchInput.value;

                location.href="group/search?q=" + searchValue;
            }

            function goGroupCreationPage() {
                location.href="";  //그룹만들기 페이지로 이동
            }

            function goToGroupFeed(gNo) {
                location.href="group/feed?groupNo=" + gNo;  //그룹g_no의 피드로 이동
            }
        </script>

    </body>
</html>