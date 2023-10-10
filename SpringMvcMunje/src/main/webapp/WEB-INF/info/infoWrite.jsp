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
<table>
	<tr>
		<th>이름</th>
		<td>${dto.name }</td>
	</tr>
	<tr>
		<th>좋아하는 색</th>
		<td>${dto.color }</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>
			<c:if test="${empty dto.hobby}">취미없음</c:if>
			<c:if test="${!empty dto.hobby}">
				<c:forEach var="hobby" items="${dto.hobby }"> <!-- forEach문은 배열의 반복문인데, 여기 스프링에서는 for문과 같은 뜻이다. -->
					[${hobby }] <!-- 위에서 var로 정의한 건 for문 안에서 사용할 단어를 정의해준 것이다. []는 이렇게 출력하려고 쓴 것 -->
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<th>가장 좋아하는 언어</th>
			<td>
				${dto.language }  <!-- select의 특징은 name=language 이용 -->
			</td>
	</tr>
</table>
</body>
</html>