<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<html>
<head>
<style>
<%@include file="/WEB-INF/css/reviewform.css"%>
</style>
</head>
<body>
	<div class="top">
		<img src="select.png" width=300 height=200 class="select_img">
	</div>
	
	<div class="top">
		<h1>어떤 책을 읽으셨나요?</h1>

		<h2>헤리언과 공유하고 싶은 책이 있으신가요?</h2>
		<h2>정림님이 적어주시는 내용은 정성 서재를 통해 모두와 공유됩니다.</h2>
	</div>

	<div class="form_css">
		<form action="ReviewUpdate.do" method="post">
					
					<input type="hidden" name="reviewerId" value="${review.reviewerId}" readonly>
					
					<!--  
					Librarian
					<select name="reviewerName"  style="width:100px; height:30px;">
					<c:forEach var="name" items="${namelist}">
					<option value="${name}">${name}</option>
					</c:forEach>
					</select>
					-->
					 
					 <input type="hidden" name="reviewerName" value="${review.reviewerName}" readonly></td>
					 
					 <input type="hidden" name="bookType" value="${review.bookType}" readonly></td>
					
					<!--  
					<span class="type_box">
					종류
					<select name="type"  style="width:100px;height:30px; text-align: center;">
					<option value="인문">인문</option>
					<option value="소설">소설</option>
					<option value="자기계발">자기계발</option>
					<option value="경제">경제</option>
					<option value="경영">경영</option>
					<option value="과학">과학</option>
					</select>					
					</span>
					-->
					<div style="text_box">
					글번호 ${review.reviewNumber}
					</div>
					<input type="hidden" name="reviewNumber" value="${review.reviewNumber}" readonly>
					
					<div style="text_box">
					제목</br>
					<input type="text" name="bookTitle" value="${review.bookTitle}" style="width:500px; height:30px;"></br></br>
				
					저자</br>
					<input type="text" name="author" value="${review.author}" style="width:500px; height:30px;"></br></br>
					
					메모</br>
					<textarea name="memo" style="width:500px; height:200px; resize:none;">${review.memo}</textarea></br></br>
				
								
					<input type="submit" value=" 내 서가에 더하기 " style="width:500px;height:30px;">
									
					</div>
							
							
<!--  						
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
</form>-->
		</form>
		</div>
	
</body>
</html>