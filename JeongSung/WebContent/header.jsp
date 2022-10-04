<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style><%@include file="/WEB-INF/css/header.css"%></style>
</head>
<body>
	<header class="main_header_container">
		<a href="main.do">
		<img src="logo.png" width=150 height=80 class="logo">
		</a>
		<div class="header_container">
			<div class="book_button_wrapper">
				
				<img src="book.png" width=15 height=15 /> 
				<a href="ReviewAll.do" class="book_button">정성의 서재 둘러보기</a>
				<form name="form1" action="ReviewList.do" method="GET">
				<input type=hidden value="checking">
				<div class="select123" onchange="javascript:document.form1.submit();">
				<select name="reviewerName" style="width:150px;height:30px;">
					<c:forEach var="name" items="${namelist}">
					<option value="${name}">${name}</option>
					</c:forEach>
				</select>
				</div>
				</form>
				
			</div>
			<div class="header_menu_container">
				<img src="pencil.png" width=15 height=15 /> 
				<a href="ReviewInsert.do" class="write_button">좋은 글 나누기</a>	
			</div>
		</div>
		<br />
		<br />
		<br />
	</header>
</body>
</html>