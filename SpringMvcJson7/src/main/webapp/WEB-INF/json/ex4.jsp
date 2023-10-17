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
<h3 class="alert alert-success">ex4번 예제</h3>
<br>
<h4>직업을 입력 후 엔터를 눌러주세요</h4>
<input type="text" id="search" class="form-control" style="width: 150px;"> <!-- input태그 안에 onkeypress 넣을 수도 있음.(엔터키 누른 후 이벤트 주는 함수)  -->
<br><br>
<h2 id="clubname"></h2>
<img alt="" src="" id="photo">
<!-- jsontest2controller에서 처리해볼게요 -->

<script type="text/javascript">

	$("#search").keyup(function(e){   //$("#search").keyup(function(e){})로 해도 됨. 그러면 위에 onkeypress="return enterkey(event)"값 주지 않아도 된다.
		
		if(e.keyCode==13){  //enter키는 13이다!! 즉, 엔터를 누르면 값이 나오도록 함
			
			var name=$(this).val();
			alert(name);
			
			
			$.ajax({
				
				type: "get",
				dataType:"json",
				url:"list4",
				data:{"name":name},
				success:function(res){
					
					$("#clubname").text(res.name); //append는 계속 추가해줘서 여러개 출력 됨,html(res.name)은 덮어써서 하나만 출력 됨//선생님은 $("#clubname").text(res.name);으로 함
					$("#photo").attr("src","image/"+res.photo);
					$("#search").val('');
				}
			});
		}
	});

</script>
</body>
</html>