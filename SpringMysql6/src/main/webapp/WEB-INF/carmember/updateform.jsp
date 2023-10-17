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
<form action="update" method="post">
<input type="hidden" name="num" value="${dto.num }">
<table class="table table-bordered" style="width: 500px;">
	<tr>
		<th>고객명</th>
		<td>
			<input type="text" name="name" class="form-control" required="required" style="width: 100px;" value="${dto.name }">
		</td>
	</tr>
	<tr>
		<th>핸드폰번호</th>
		<td>
			<input type="text" name="hp" class="form-control" required="required" style="width: 150px;" value="${dto.hp }">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="addr" class="form-control" required="required" style="width: 150px;" value="${dto.addr }">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정" class="btn btn-info">
			<input type="button" value="목록" class="btn btn-success" onclick="location.href='list'"> 
			<!-- CarMemberController에서 정의해준 가상경로를 onclick에 써준다. list만!-->
		</td>
	</tr>
</table>
</form>
</body>
</html>