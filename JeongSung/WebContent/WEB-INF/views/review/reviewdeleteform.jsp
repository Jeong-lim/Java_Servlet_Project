<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원정보 삭제</h1>
<h3>삭제할 사원의 이메일을 입력하세요</h3>
<form action="ReviewDelete.do" method="post">
<input type="text" name="reviewNumber" value="${review.reviewNumber}">
</form>
</body>
</html>