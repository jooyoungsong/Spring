<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
   href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu:wght@700&family=Nanum+Pen+Script&family=Single+Day&display=swap"
   rel="stylesheet">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
   rel="stylesheet">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>안녕하세요 우리는 오늘부터<br>스프링 MVC에 대해 공부합니다</h2>
	<h2>StartController로 부터 포워드</h2>
	<b>이름: ${requestScope.name }</b><br> <!-- requestScope를 생략해서 사용 가능 -->
	<b>주소: ${addr }</b><br>
	
	<!-- 매핑 연습 해볼게요 -->
	<h1 class="alert alert-info">매핑연습</h1>
	<ul>
		<li><a href="apple/list">apple/list</a></li>
		<li><a href="apple/list.do">apple/list.do</a></li> <!--확장자 .do나 .nhn쓴 거는 그냥 아무거나 붙혀도 나온다는 걸 보여주기 위함  -->
		<li><a href="apple/list.nhn">apple/list.nhn</a></li>
		<li><a href="banana/insert">banana/insert</a></li>
		<li><a href="orange/delete">orange/delete</a></li>
	</ul>
	
	<h1 class="alert alert-success">이미지연습</h1>
	<ul>
		<li><a href="shop/detail">resource의 이미지출력</a></li>
		<li><a href="board/insert/data">WEB-INF의 이미지출력</a></li>
	</ul>
</body>
</html>