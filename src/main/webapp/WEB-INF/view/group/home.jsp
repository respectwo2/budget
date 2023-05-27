<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <span>
        <form>
            <input type="search" id="searchInput">
        </form>
    </span>
    <img id="searchIcon" onclick="goToSearchPage('searchInput')" src="${path}/resources/images/돋보기.svg">
    <hr>

    <b id="myGroupBar"> 나의 그룹&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <span id="createButton" onclick="goToGroupCreationPage()">만들기</span>
    </b>
    <br><br>

    <c:forEach items="${groupsWithMemberCount}" var="userGroup">
        <div id="myGroup" onclick="goToGroupFeed(${userGroup.g_no})">
            <b>${userGroup.g_name}&nbsp;&nbsp;&nbsp;</b>
            <small id="peopleNum">${userGroup.memberCount}/${userGroup.g_maxpeople}명</small>&nbsp;&nbsp;&nbsp;
            <small>#${userGroup.g_tag}</small>
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
            <b onclick="openModal(${group.g_no})">
                ${group.g_name}</b>&nbsp;&nbsp;&nbsp;<small>#${group.g_tag}</small>
            <br><br>
        </c:forEach>
    </div>
</body>
</html>