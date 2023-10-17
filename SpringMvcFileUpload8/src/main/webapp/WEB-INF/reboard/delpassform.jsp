<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- updatepassform 복사 후 action명 변경 -->
<div style="margin: 200px 200px;">
		<form action="deletepass" method="post">
			<input type="hidden" name="num" value="${num }">
			<input type="hidden" name="currentPage" value="${currentPage }">
			
			<div class="alert alert-danger" style="width: 300px; font-size: 1.3em;">
				<b>비밀번호를 입력해주세요</b>
			</div>
			<div class="d-inline-flex">
				<input type="password" name="pass" class="form-control"
				style="width: 120px;" required="required">
				<br>	
				<button type="submit" class="btn btn-outline-danger">삭제하기</button>
				<button type="button" class="btn btn-outline-info"
				onclick="history.back()">이전으로</button>  <!-- 여기서는 location.href 안써요! 그니깐 history.back() 쓸 때는 그냥 쓴다. -->
			</div>
		</form>
	</div>
</body>
</html>