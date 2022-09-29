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
		<form action="ReviewInsert.do" method="post">
					
					Librarian
					<select name="reviewerName"  style="width:100px;height:30px;">
					<c:forEach var="name" items="${namelist}">
					<option value="${name}">${name}</option>
					</c:forEach>
					</select>
					
					<span class="type_box">
					종류
					<select name="bookType"  style="width:100px;height:30px;">
					<option value="bookType">인문</option>
					<option value="bookType">소설</option>
					<option value="bookType">자기계발</option>
					<option value="bookType">경제</option>
					<option value="bookType">경영</option>
					<option value="bookType">과학</option>
					</select>					
					</span>
					<span class="type_box">
					글번호 ${reviewNumber}</br></br>
					</span>
					<div style="text_box">
					제목</br>
					<input type="text" name="bookTitle" style="width:500px;height:30px;"></br></br>
				
					저자</br>
					<input type="text" name="author" style="width:500px;height:30px;"></br></br>
					
					메모</br>
					<textarea name="memo"  style="width:500px; height:200px; resize:none;"></textarea></br></br>
					
								
					<input type="submit" value=" 내 서가에 더하기 " style="width:500px;height:30px;">
					
					</div>
	</div>


</body>
</html>