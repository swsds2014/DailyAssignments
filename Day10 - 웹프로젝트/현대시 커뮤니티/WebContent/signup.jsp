<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>signup.jsp</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
	<h3>회원가입 페이지</h3>

	<form action="signUp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${id}"></td>
			</tr>
			<tr>
				<td>필명</td>
				<td><input type="text" name="nickname" value="${nickname}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${name}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="password2">${msg}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" value="${email}"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" value="${birth}"></td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td><textarea name="intro" rows="3" cols="50">${intro}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="reset" value="초기화">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>