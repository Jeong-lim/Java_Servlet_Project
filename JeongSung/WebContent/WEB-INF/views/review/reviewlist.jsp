<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../../header/header.jsp"%>
<style><%@include file="../css/reviewlist.css"%></style>
</head>
<body>

	<div class="list_header_container">
		<div class="list_title_container">
			<h1 class="list_header_title2">성호의 서재</h1>
		</div>

		<h3>안녕하세요. 성호의 서재입니다!</h3>
	</div>


	<c:forEach var="review" items="${reviewlist}">
		<div class="list_container">
			<div class="d1">
				<div class="_container">
					<div class="bookTitle">${review.bookTitle}</div>
					<div class="bookType">${review.bookType}</div>
					<br /> <br />
					<div class="content_container">
						<div class="author">${review.author}</div>
						<div class="memo">${review.memo}</div>
					</div>
				</div>
			</div>
		</div>



		<%--  <tr>
 	<td><a href="ReviewDetails.do?reviewNumber=${review.reviewNumber}">${review.reviewNumber}</a></td>
 	<td>${review.reviewerName}</td>
 	<td>${review.bookType}</td>
 	<td>${review.bookTitle}</td>
 	<td>${review.author}</td>
 	<td>${review.memo}</td>	
 </tr> --%>
 </c:forEach>
 	
</body>
</html>