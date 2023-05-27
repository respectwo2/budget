<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<html>
<head>
     <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>
<body>
    <div onclick="goToGroupMissionPage(${bgmNo})">미션: ${groupMissionBanner}</div>
<hr>

<c:forEach items="${consumes}" var="consume">
<tr>
	<td>${consume.user_name}</td>
    <td>${consume.c_date}</td>
	<td>${consume.c_money}</td>
	<td>${categoryMap.get(consume.c_categoryid)}</td>
	<td>${consume.c_content}</td>
	<c:if test="${not empty consume.c_image}"><img src="${path}/resources/jpg/${consume.c_image}" width="20" height="20"></c:if>
	<div onclick="goToComment(${consume.c_no})">댓글(${consume.commentNum})</div>
	<div data-consume-no="${consume.c_no}" onclick="increaseLikeCount(${consume.c_no})">
	    like ${consume.c_like}
	</div>
</tr>
<hr>
</c:forEach>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // 좋아요 수를 증가시키는 Ajax 요청
    function increaseLikeCount(consumeNo) {
      $.ajax({
        type: 'POST',
        url: '/consume/increaseLikeCount',
        data: { consumeNo: consumeNo },
        success: function() {
          // 성공적으로 처리되었을 때의 동작
          console.log('좋아요 수 증가 완료');
          // 업데이트된 좋아요 수를 가져와서 화면에 업데이트
          updateLikeCount(consumeNo);
        },
        error: function() {
          // 요청이 실패했을 때의 동작
          console.error('좋아요 수 증가 실패');
        }
      });
    }

    // 업데이트된 좋아요 수를 가져와서 화면에 업데이트하는 함수
    function updateLikeCount(consumeNo) {
      $.ajax({
        type: 'GET',
        url: '/consume/getConsume',
        data: { consumeNo: consumeNo },
        success: function(response) {
          const updatedLikeCount = response.c_like;
          const likeElement = $('div[data-consume-no="' + consumeNo + '"]');
          likeElement.text('like ' + updatedLikeCount);
        },
        error: function() {
          console.error('Failed to fetch updated data');
        }
      });
    }

    function goToComment(consumeNo) {
        location.href="/group/feed/comment?consumeNo=" + consumeNo;  // 댓글 등록 및 조회 페이지로 이동
    }

    function goToGroupMissionPage(bgmNo) {
        // 슬래쉬 없애야하나?
        // location.href=“/bgm/now{bgm_n}”;
        location.href="/bgm/now" + bgmNo;
    }
</script>

</body>
</html>