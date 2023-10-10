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
<form action="result" method="post">  <!-- action에는 가짜주소인 result로 쓴 것_진짜 출력할 거는 infoWrite에서 쓸 것이다 //임의이름 정해놓는 건 주소에 result로 뜨기 위한 것도 있음-->
<table style="width: 500px;" class="table table-bordered">
	<caption align="top"><b>정보 입력</b></caption>
	<tr>
		<th>이름</th>
			<td>
				<input type="text" style="width: 100px;" name="name" class="form-control">
			</td>
	</tr>
	<tr>
		<th>좋아하는 색</th>
			<td>
				<input type="color" style="width: 50px;" name="color" class="form-control">
			</td>
	</tr>
	<tr>
		<th>취미</th>
			<td>
				<input type="checkbox" name="hobby" value="독서">독서
				<input type="checkbox" name="hobby" value="그림">그림
				<input type="checkbox" name="hobby" value="영화">영화
				<input type="checkbox" name="hobby" value="스포츠">스포츠
				<input type="checkbox" name="hobby" value="게임">게임
			</td>
	</tr>
	<tr>
		<th>가장 좋아하는 언어</th>
			<td>
				<select name="language">
					<option value="java">java</option>
					<option value="html">html</option>
					<option value="oracle">oracle</option>
					<option value="jsp">jsp</option>
					<option value="spring">spring</option>
				</select>
			</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="전송" class="btn btn-info">
		</td>
	</tr>
</table>
</form>
</body>
</html>