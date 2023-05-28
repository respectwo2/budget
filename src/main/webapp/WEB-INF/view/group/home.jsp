<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes;">
    <link href="${path}/resources/css/groupHome.css" rel="stylesheet" type="text/css">
    <script src="${path}/resources/js/groupHome.js" type="text/javascript"></script>
</head>
<body>
    <!-- 모달 창 -->
    <div id="groupModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2>그룹 정보</h2>
            <div id="groupInfo">
                <!-- 그룹 정보 표시 -->
            </div>
        </div>
    </div>

    <!-- 그룹 홈 페이지 -->
    <div class="container">
        <div class="header">
            <div class="time">9:40</div>
            <div class="data">
                <img src="${path}/resources/images/data.svg" alt="SVG">
            </div>
            <div class="wifi">
                <img src="${path}/resources/images/wifi.svg" alt="SVG">
            </div>
            <div class="battery">
                <img src="${path}/resources/images/battery.svg" alt="SVG">
            </div>
            <h1 class="groupLetter">그룹</h1>
        </div>

        <div class="main">
            <div class="search-box">
                <div class="search"></div>
                <form><input type="search" id="searchInput"></form>
                <img class="searchIcon" onclick="goToSearchPage('searchInput')" src="${path}/resources/images/돋보기.svg" alt="SVG">
            </div>

            <div class="myGroup-box">
                <div class="myGroupLetter">나의 그룹</div>
                <div class="createBtn"></div>
                <div class="createLetter" onclick="goToGroupCreationPage()">만들기</div>

                <c:forEach items="${groupsWithMemberCount}" var="userGroup">
                    <div class="us erGroupBtn-box">
                        <div class="userGroupBtnRec"></div>
                        <img class="budgetBucketIcon" src="${path}/resources/images/budgetBucket.svg" alt="SVG">
                        <div class="userGroupName">${userGroup.g_name}</div>
                        <div class="userGroupTag">#${userGroup.g_tag}</div>
                        <div class="userGroupPeopleNum">${userGroup.memberCount}/${userGroup.g_maxpeople}명</div>
                    </div>

                </c:forEach>
            </div>

            <div class="groupList-box"></div>
        </div>

        <div class="footer-nav"></div>
    </div>

</body>
</html>
