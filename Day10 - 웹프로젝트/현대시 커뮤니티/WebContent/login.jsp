<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style type="text/css">

body {
	text-align: center;
	margin-top: 40%;
}

table {
	margin: auto;
}
tr, td {
	padding: 3px;
	border: hidden;
}
input {
	padding: 2px;
	margin: auto;
	vertical-align: middle;
}

</style>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#signup').on("click", function() {
			location.href = "signup.jsp";
		});
	});
</script>
<body>
	<h1>시 커뮤니티</h1>
	<form action="login" method="post">
		<table>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인" />&nbsp;
					<input type="button" id="signup" name="signup" value="회원가입" /></td>
			</tr>
		</table>
	</form>

</body>
</html>