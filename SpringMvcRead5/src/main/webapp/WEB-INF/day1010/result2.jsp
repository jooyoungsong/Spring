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
	<div class="alert alert-danger" style="width: 300px;">
		상품명:${shopDto.sang }<br>
		색상:<b style="color:${shopDto.color}">${shopDto.color }</b>&nbsp;<div style="width: 15px; height: 15px; background-color: ${shopDto.color}; display:inline-block;"></div><br>
		가격:<fmt:formatNumber value="${shopDto.price }" type="currency"/><br>
		선택한 이미지: <img alt="" src="../photo/${shopDto.image }.png" style="width:200px;">
	</div>
</body>
</html>