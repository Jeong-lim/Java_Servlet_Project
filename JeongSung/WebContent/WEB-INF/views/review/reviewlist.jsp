<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<c:forEach var="review" items="${reviewlist}">
 <tr>
 	<td><a href="ReviewDetails.do?reviewerId=${review.reviewerId}">${review.reviewerId}</a></td>
 	<td>${review.reviewerName}</td>
 	<td>${review.reviewNumber}</td>
 	<td>${review.bookType}</td>
 	<td>${review.bookTitle}</td>
 	<td>${review.author}</td>
 	<td>${review.memo}</td>	
 </tr>
 </c:forEach>
 </table>
</body>
</html>