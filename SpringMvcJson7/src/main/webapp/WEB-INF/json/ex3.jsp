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
<h3>ex3번 예제</h3>
<br>
<button type="button" id="btn3" class="btn btn-info">list3 json 배열 데이터</button>
<div id="out1"></div>  <!-- id는 사실 안 바꿔도 됨.(ex1,2,3파일과 같아도 됨_왜? 해당 파일에서만 사용할 거라서!) -->

<script type="text/javascript">
	
	$("#btn3").click(function(){
		
		$.ajax({
			
			type: "get",
			dataType:"json",
			url:"list3",
			success:function(res){
				
				var s="";
				
				$.each(res,function(i,elt){
					
					s+="<figure>";
					s+="<img src='image/"+elt.photo+"' width=100>";
					s+="<figcaption><b>";
					s+=elt.name;
					s+="</b></figcaption";
					s+="</figure>";
					
				});
				
				$("#out1").html(s);
			}
		});
	});
</script>
</body>
</html>