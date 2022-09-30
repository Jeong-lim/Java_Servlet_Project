<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세 정보창</h1>
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