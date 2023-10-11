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
	<h2>제목:${title }</h2>
	<h2>업로드한 실제 경로:${path }</h2>
	<h2>업로드한 이미지들</h2>
	
	<c:forEach var="ims" items="${files }">  <!-- NaverController에서 arraylist에 담아놨던 files를 꺼내오는 것!,
	 반복문에서 배열주소 0번지 1번지...담아놓았던 걸 여기서 꺼내온다  -->
	 
		<img alt="" src="../photo/${ims}" style="width: 100px; height: 100px; border: 1px solid gray;">
	</c:forEach>
</body>
</html>