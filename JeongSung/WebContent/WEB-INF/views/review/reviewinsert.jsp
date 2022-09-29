<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ReviewInsert.do" method="post">
	<table border=1>
	<tr>
		<td>회원아이디</td>
		<td><input type="number" name="reviewerId"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="reviewerName"></td>
	</tr>
	<tr>
		<td>리뷰번호</td>
		<td><input type="number" name="reviewNumber"></td>
	</tr>
	<tr>
		<td>책타입</td>
		<td><input type="text" name="bookType"></td>
	</tr>
	<tr>
		<td>책제목</td>
		<td><input type="text" name="bookTitle"></td>
	</tr>
	<tr>
		<td>저자</td>
		<td><input type="text" name="author"></td>
	</tr>
	<tr>
		<td>메모</td>
		<td><input type="text" name="memo"></td>
	</tr>
	<tr>
		<td colspan=2>
		<input type="submit" value="저장">
		</td>
	</tr>
	</table>
	</form>
</body>
</html>