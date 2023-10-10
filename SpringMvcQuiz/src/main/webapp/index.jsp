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
<button onclick="location.href='ilike/movie'" class="btn btn-outline-info">제목을 메세지로 받아서 출력하고 그아래 이미지_ result1에 출력</button><br>
<button onclick="location.href='school/myinfo'" class="btn btn-outline-success">get방식 테이블 출력(이름,학교,학년,학교 주소)_result2</button><br>
<button onclick="location.href='shop/ipgo'" class="btn btn-outline-danger">post방식_dto_ 테이블 출력(상품명,카테고리,색상,가격)_result3</button><br>
<button onclick="location.href='myshinsang'" class="btn btn-outline-warning">post방식 Map출력(이름,나이,혈액형,주소)_result4</button><br>
<!-- 출력은 아무렇게나 하면 됩니다. 에러만 안나면 된다.  -->
</body>
</html>