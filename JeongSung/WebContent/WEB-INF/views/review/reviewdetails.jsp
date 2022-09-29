<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty member}">
		<table border=1>
			<tr>
				<th>리뷰어아이디</th>
				<th>리뷰어이름</th>
				<th>리뷰글번호</th>
				<th>책타입</th>
				<th>책제목</th>
				<th>저자</th>
				<th>메모</th>
			</tr>

			<tr>
				<td><a href="ReviewDetails.do?reviewerId=${review.reviewerId}">${review.reviewedId}</a></td>
				<td>${review.reviewerName}</td>
				<td>${review.reviewerNumber}</td>
				<td>${review.bookType}</td>
				<td>${review.bookTitle}</td>
				<td>${review.author}</td>
				<td>${review.memo}</td>
			</tr>
		</table>
		<a href="ReviewUpdate.do?empid=${review.reviewerId}">사원정보 수정</a>
		<a href="ReviewDelete.do?empid=${review.reviewerId}">사원정보 삭제</a>
	</c:if>

	<c:if test="${empty emp}">
사원정보가 없습니다.
</c:if>
</body>
</html>