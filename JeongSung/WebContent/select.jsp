<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/WEB-INF/css/select.css"%></style>
</head> 
<body>
	<div class="img_container">
		<img src="select.png" width=1200 height=600 class="select_img">
	</div>
	<br/>
	
	<div class="text1">
	정성 서재에 오신 것을 환영합니다
	</div>
	
	<div class="text2">
	프로필을 선택하세요<br><br>
	</div>	


	
	<div class="img_container">
	<center>	
	<c:forEach var="reviewer" items="${reviewerNameList}">		
			<div class="img_circle">
					<img class="profile" src="${reviewer}.png">
				</div>
				<span class="selectUser" style="position: relative; top: 30px; right: 87px;"><a
					href="Main.do?name=${reviewer}" style="text-decoration: none; color: black;">${reviewer}</a></span>
			</c:forEach>
	</center>
	</div>
	
</body>
</html>