<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<hr>
	<form action="memberJoinOk" method="post">
		아이디 <br> <input type="text" name="id" value="${memberDto.id }"> <br>
		비밀번호 <br> <input type="password" name="password"> <br>
		비밀번호 확인 <br> <input type="password" name="confirmPassword"> <br>
		이름 <br> <input type="text" name="name" value="${memberDto.name }"> <br>
		나이 <br> <input type="text" name="age" value="${memberDto.age }"> <br>
		이메일 <br> <input type="text" name="email" value="${memberDto.email }"> <br>
		<input type="submit" value="회원가입">
	</form>
	
	<hr>
	<c:if test="${not empty signupError}">
		<span style="color:red;">${signupError}</span><br>
		<ul>
		<c:forEach items="${errorMsg }" var="errorM">
			<li>${errorM}</li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>