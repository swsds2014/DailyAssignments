<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.JDBCUtils"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.html</title>
</head>
<body>

<div align="center">
<h3>회원 가입</h3>
<form action="signUpPro.jsp" method="post">
	 이름: <input type="text" name="name" placeholder="이름을 입력하세요."><br>
	 패스워드: <input type="password" name="password" placeholder="패스워드를 입력하세요."><br>
	 이메일: <input type="email" name="email" placeholder="이메일을 입력하세요."><br><br>
	 나이: <input type="number" name="age" min="0" max="150" step="1">&nbsp;
	 성별:<input type="radio" name="gender" value="0">남<input type="radio" name="gender" value="1">여
	 <br><br>
	 
	 관심사: 
	 <input type="checkbox" name="interests" value="IT">IT
	 <input type="checkbox" name="interests" value="디자인">디자인
	 <input type="checkbox" name="interests" value="음악">음악
	 <input type="checkbox" name="interests" value="영화">영화
	 <input type="checkbox" name="interests" value="스포츠">스포츠
	 <br><br>
	 <input type="submit" value="회원가입">
	 <input type="reset" value="취소"><br>
	</form>
	 <button onclick="location.href='index.html'">메인 페이지로</button>
</div>
</body>
</html>