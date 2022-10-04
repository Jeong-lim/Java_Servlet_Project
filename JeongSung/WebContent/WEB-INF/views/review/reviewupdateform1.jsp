<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 정보 수정 양식</h1>
<form action="ReviewUpdate.do" method="post">
<table border=1>
<tr>
	<td>사용자 아이디</td>
	<td><input type="number" name="reviewerId" value="${review.reviewerId}" readonly></td>
</tr>
<tr>
	<td>작성자</td>
	<td><input type="text" name="reviewerName" value="${review.reviewerName}" readonly></td>
</tr>
<tr>
	<td>게시글 번호</td>
	<td><input type="number" name="reviewNumber" value="${review.reviewNumber}" readonly></td>
</tr>
<tr>
	<td>책 타입</td>
	<td><input type="text" name="bookType" value="${review.bookType}"></td>
</tr>
<tr>
	<td>책 제목</td>
	<td><input type="text" name="bookTitle" value="${review.bookTitle}"></td>
</tr>
<tr>
	<td>책 저자</td>
	<td><input type="text" name="author" value="${review.author}"></td>
</tr>
<tr>
	<td>메모</td>
	<td><input type="text" name="memo" value="${review.memo}"></td>
</tr>
<tr>
	<td colspan=2>
		<input type="submit" value=" 저 장 ">
		<input type="reset" value=" 취 소 ">
	</td>
	</tr>
</table>
</form>
</body>
</html>