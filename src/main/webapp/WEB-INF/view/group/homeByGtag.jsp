<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
    <style>
    /* 모달 스타일 */
    .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .modal-content {
        background-color: #fefefe;
        margin: 10% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 80%;
    }

    .close {
        color: #aaaaaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
    }

    .close:hover,
    .close:focus {
        color: #000;
        text-decoration: none;
        cursor: pointer;
    }
    </style>
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

    <span>
        <form>
            <input type="search" id="searchInput">
        </form>
    </span>
    <img id="searchIcon" onclick="goToSearchPage('searchInput')" src="/images/돋보기.svg">
    <hr>

    <b id="myGroupBar"> 나의 그룹&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="createButton" onclick="goToGroupCreationPage()">만들기</span></b>
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
        <span id="청소년" onclick="showGroupsByTag('청소년')">#청소년&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span id="대학생" onclick="showGroupsByTag('대학생')">#대학생&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span id="취준생" onclick="showGroupsByTag('취준생')">#취준생&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span id="직장인" onclick="showGroupsByTag('직장인')">#직장인</span>
    </div>
    <br>

    <div>
        <c:forEach items="${groupsByGtag}" var="group">
            <b onclick="openModal(${group.g_no})">${group.g_name}</b>&nbsp;&nbsp;&nbsp; <small>#${group.g_tag}</small>
            <br><br>
        </c:forEach>
    </div>

    <script>
    // 모달 열기
    function openModal(groupNo) {
        var modal = document.getElementById("groupModal");
        modal.style.display = "block";

        // 그룹 정보를 가져와서 모달에 표시하는 AJAX 요청
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var groupInfo = document.getElementById("groupInfo");
                groupInfo.innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "/group/info?groupNo=" + groupNo, true);
        xhttp.send();
    }

    // 모달 닫기
    function closeModal() {
        var modal = document.getElementById("groupModal");
        modal.style.display = "none";
    }

    function goToSearchPage(searchInput) {
        var searchTmp = document.getElementById(searchInput);
        var searchValue = searchTmp.value;

        location.href = "/group/search?q=" + searchValue;
    }

    function goToGroupCreationPage() {
         location.href = "/group/create";  //그룹만들기 페이지로 이동
    }

    function goToGroupFeed(gNo) {
         location.href = "/group/feed?groupNo=" + gNo;  //그룹g_no의 피드로 이동
    }

    function showGroupsByTag(tag) {
        location.href = "/group/list?tag=" + tag;  //태그로 그룹 조회해서 그룹메인 보여주기
    }

    //그룹정보 페이지로 이동
    function goToGroupInfoPage(groupNo) {
        location.href = "/group/info?groupNo=" + groupNo;
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
