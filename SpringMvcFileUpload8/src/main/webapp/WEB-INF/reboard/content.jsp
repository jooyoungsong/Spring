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
	<table class="table table-bordered" style="width: 600px">
		<tr>
			<th>${dto.num }</th>
			<th>${dto.subject }</th>
			<th><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/></th>
			<th>${dto.writer }</th>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:forEach var="p" items="${dto.photo }">
					<c:if test="${dto.photo!='no'}">
						<img alt="" src="../upload/${p }" style="width: 200px; height: 200px;">
					</c:if>
					<c:if test="${dto.photo=='no'}">
						<img alt="" src="../photo/noimage.jpg">
					</c:if>
				</c:forEach>
			</td>
			<td colspan="2">
				${dto.content }
			</td>
		</tr>
		<tr>
			<td align="right" colspan="4">
				<button class="btn btn-outline-success" onclick="location.href='writeform'">글쓰기</button>
				<button class="btn btn-outline-success" onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
				<button class="btn btn-outline-success" onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
				<button class="btn btn-outline-success" onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				<button class="btn btn-outline-success" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>