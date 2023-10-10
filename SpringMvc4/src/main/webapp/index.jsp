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
	<a href="board/form1">폼</a>
	<%-- <c:redirect url="board/form1"/> --%>
	<!-- 위에 a태그처럼 사용도 가능하고 c:redirect도 가능하다! 비교
	 // a태그 경로는 폼이라는 글자를 눌러야 board/form1으로 주소가 들어가지는 데, c:redirect는 index페이지의 주소가 바로 board/form1이라는 곳으로 들어간다.-->
	 
	<a href="board/result2">이미지 css js연습_#1</a>
	<a href="shop/list">이미지 css js연습_#2</a>
	<a href="shop/form2">폼 데이터읽기_dto</a>
	<a href="shop/form3">폼 데이터읽기_map</a>
</body>
</html>