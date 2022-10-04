<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/header.jsp"%>
<style><%@include file="/WEB-INF/css/reviewdetails.css"%></style>
</head>
<body>

	<div style="background-color: grey">
		<div class="header_all_container">
			<div style="line-height: 0.6" class="header_content_container">
				<h1 class="header_name">${review.reviewerName}</h1>
				<h1 class="header_nim">의 서재</h1>
				<br /> <br /> <br /> <br /> <br /> <br />

				<h1>시간날 때 읽어보세요🧐</h1>
				<div class="header_content">
					${name}팀의 마음이 차곡차곡 쌓이는 정성 서재,
					<p></p>
					서로에게 카톡으로, 전화로, 말로 추천해주던 책과 기사를 이곳에서 나눠주세요.
					<p></p>
					정성 서재는 오늘도 함께 성장합니다.
				</div>
			</div>
			
		</div>
	</div>




</br> </br> </br> </br>

<c:if test="${not empty review}">
 	${review.reviewNumber}
 	${review.bookType}
 	${review.bookTitle}
 	${review.author}
 	${review.memo}	
 	<a href="ReviewUpdate.do?reviewNumber=${review.reviewNumber}">정보 수정</a>
	<a href="ReviewDelete.do?reviewNumber=${review.reviewNumber}">정보 삭제</a>
	

</c:if>
</body>
</html>