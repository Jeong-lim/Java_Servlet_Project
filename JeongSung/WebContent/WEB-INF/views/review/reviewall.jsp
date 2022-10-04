<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/header.jsp"%>
<style><%@include file="/WEB-INF/css/reviewlist.css"%></style>
</head>
<body>

	<div class="list_header_container">
		<div class="list_title_container">
			<h1 class="list_header_title2">정성의 서재</h1>
		</div>

		<h3>안녕하세요. 정성의 서재입니다!</h3>
	</div>


	<c:forEach var="review" items="${allreviewlist}">
		<div class="list_container">
			<div class="d1">
				<div class="_container">
					<div class="bookTitle">${review.reviewerName}</div>
					<div class="bookTitle">${review.bookTitle}</div>
					<div class="bookType">${review.bookType}</div>
					<br /> <br />
					<div class="content_container">
						<div class="author">${review.author}</div>
						<div class="memo">${review.memo}</div>
						<br/><br/>
					<!-- 삭제 -->						
					<form action="ReviewDelete.do" method="POST">
              		<input type="hidden" name="reviewNumber" value=${review.reviewNumber}>
              		<input type="submit" value="delete" style="background: #CEF6D8">
             		</form>
             		<!-- 수정 -->			
             		<a href="ReviewUpdate.do?reviewNumber=${review.reviewNumber}">update</a>
             				             		
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