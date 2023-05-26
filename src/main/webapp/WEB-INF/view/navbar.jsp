<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
  nav {
   display: flex;
    justify-content: center;
    position: fixed; 
    bottom: 0;
    left: 0;
    width: 100%;
    background-color: #f0f0f0; 
    z-index: 1; /* 버튼들이 다른 요소 위에 쌓이도록 층위 조절 */
     
   
  }
  
 
  
  ul {
    display: flex;
    list-style-type: none;
    padding: 0;
  }
  
  li {
    margin: 0 10px;
  }
  
  a {
    text-decoration: none;
    color: #333;
  }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<nav>
  <ul>
    <li><a href="/home">홈</a></li>
    <li><a href="/page2">그룹</a></li>
    <li><a href="/consume/create">+</a></li>
    <li><a href="/budget/main">버찌</a></li>
    <li><a href="/Buser/mypage">마이페이지</a></li>
  </ul>
</nav>
</body>
</html>