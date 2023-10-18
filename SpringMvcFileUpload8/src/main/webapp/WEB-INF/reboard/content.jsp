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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">  <!-- 부트스트랩아이콘 추가 _ day1018 -->
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
		
		<!-- 댓글 -->  <!-- day1018 -->
		<tr>
			<td colspan="4">
				<div id="answer">  <!-- answer이라는 구역을 줌 -->
					<b>댓글: ${acount }</b>
					<hr>
					<c:forEach var="a" items="${alist }">
						<b>${a.nickname }</b> : ${a.content }&nbsp;&nbsp;
						<span style="color: gray; font-size: 0.9em;">
							<fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd HH:mm"/>
						</span>
						&nbsp;&nbsp;
						<%-- <a href="adelete?idx=${a.idx}&num=${a.num}&currentPage=${currentPage}" style="text-decoration: none;"><i class="bi bi-trash3" style="cursor: pointer"></i></a><br> --%>
						<i class="adel bi bi-trash3" style="cursor: pointer" idx="${a.idx }"></i><br>
					</c:forEach>
				</div>
				<br>
				<form action="ainsert" method="post" style="width: 600px;">
					<!-- 반드시 hidden으로 num 넣어줘야 한다.  -->
					<input type="hidden" name="num" value="${dto.num }">
					<input type="hidden" name="currentPage" value="${currentPage }">
					
					<div class="d-inline-flex">
					
					<b>닉네임:&nbsp; </b>
					<input type="text" name="nickname" class="form-control"
					style="width: 120px;" required="required">
					
					&nbsp;&nbsp;
					<b> 비밀번호:&nbsp; </b>
					<input type="password" name="pass" class="form-control"
					style="width: 120px;" required="required">
					</div>
					
					<br><br>
					<input type="text" name="content" class="form-controller"
					style="width: 500px;" placeholder="댓글내용을 입력해주세요">
					<button type="submit" class="btn btn-outline-info">확인</button>
				</form>
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
	
	<script type="text/javascript">
		//댓글삭제
		$("i.adel").click(function(){
			
			var idx=$(this).attr("idx");
			//alert(idx);
			
			var pass=prompt("비밀번호를 입력해주세요");
			//alert(pass);
			
			if(pass==null)
				return;
			
			$.ajax({
				
				type:"get",
				dataType:"json",
				url:"adelete",  //여기서 url 쓴 걸 controller에서 쓰는 것
				data:{"idx":idx,"pass":pass},
				success:function(res){
					
					if(res.check==0){
						alert("비밀번호가 다릅니다");
					}else{
						alert("댓글을 삭제합니다");
						location.reload();
					}
				}
			});
		});
	</script>
</body>
</html>