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
<!-- updateform은 writeform 복사해서 수정해주는 데, input type=hidden이 이미 있어서 value값을 써준다.-->
<!-- 근데, value 쓰기 위해서는 dto를 만들어야 해서 BoardUpdateController에서 BoardDto dto=dao.getDataReboard(num);를 만들어줌 -->
<div style="margin: 50px 100px;">
	<form action="update" method="post" enctype="multipart/form-data">
		
		<!-- 답변형 게시판은 2개를 hidden으로 넘겨준다 -->
		<input type="hidden" name="num" value="${dto.num }">
		<input type="hidden" name="currentPage" value="${currentPage }">
			
		<table class="table table-bordered" style="width: 500px;">
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" class="form-control" required="required"
					style="width: 120px;" value="${dto.writer}">
				</td>
			</tr>
	
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" class="form-control" required="required"
					style="width: 120px;" value="${dto.subject}">
				</td>
			</tr>
			
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="uimage" class="form-control" 
					style="width: 220px;" multiple="multiple">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea style="width: 480px; height: 130px;"
					name="content" required="required"  class="form-control">${dto.content}</textarea>  <!-- content는 태그 밖에 하기  -->
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-info"
					style="width: 100px;">수정</button>
					<button type="button" class="btn btn-info"
					style="width: 100px;" onclick="location.href='list?currentPage=${currentPage}'">목록</button>  <!-- 글이 있던 해당 페이지로 이동  -->
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>