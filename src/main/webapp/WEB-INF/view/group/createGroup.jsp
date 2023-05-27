<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
</head>
<body>
    <h1>그룹 만들기</h1>
    <form action="/group/create" method="post">
        그룹 명<br><input type="text" name="g_name"><br>
        그룹 인원<br><input type="text" name="g_maxpeople">(최대 30명)<br>
        <div>
            필수 태그<br>
            <div onclick="selectRtag('청소년')" class="tag-button" id="tagButton1">청소년</div>
            <div onclick="selectRtag('대학생')" class="tag-button" id="tagButton2">대학생</div>
            <div onclick="selectRtag('취준생')" class="tag-button" id="tagButton3">취준생</div>
            <div onclick="selectRtag('직장인')" class="tag-button" id="tagButton4">직장인</div>
            <input type="hidden" name="g_rtag" id="selectedRtag" value="">
            <br>
        </div>
        해시 태그<br><input type="text" name="g_tag"><br>
        그룹 설명<br><textarea name="g_content" cols="30" rows="3"></textarea><br>
        <button type="submit" name="bgroupcommit">생성 완료</button>
    </form>

    <script>
        function selectRtag(value) {
            document.getElementById("selectedRtag").value = value;

            // 선택된 버튼 스타일 변경
            var buttons = document.getElementsByClassName("tag-button");
            for (var i = 0; i < buttons.length; i++) {
                if (buttons[i].innerText === value) {
                    buttons[i].style.backgroundColor = "#999";
                    buttons[i].style.fontWeight = "bold";
                } else {
                    buttons[i].style.backgroundColor = "#ccc";
                    buttons[i].style.fontWeight = "normal";
                }
            }
        }
    </script>

    <style>
        .tag-button {
            display: inline-block;
            padding: 5px 10px;
            margin-right: 10px;
            background-color: #ccc;
            cursor: pointer;
        }
    </style>
</body>
</html>
