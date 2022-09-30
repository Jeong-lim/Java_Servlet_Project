<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function removeCheck() {

	 if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	     document.removefrm.submit();
	 }else{   //취소
	     return false;
	 }
	}
</script>
<h1>사원정보 삭제</h1>
<h3>삭제할 사원의 이메일을 입력하세요</h3>
<form action="ReviewDelete.do" method="post">
<input type="button" name="reviewNumber" value="${review.reviewNumber}">
</form>
</body>
</html>