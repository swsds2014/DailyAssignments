<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>새글등록</title>
</head>
<body>
<center>
	<h3>새글 등록하기............<a href=''>LOG-OUT</a></h3>
	<hr>
		<form action="addBoard" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>제목</td><td align="left"><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>작성자</td><td align="left"><input type="text" name="nickname" size="10"/></td>
			</tr>
			<tr>
				<td>내용</td><td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value=" 새글 등록 "/></td>
			</tr>
		</table>
		</form>
	<hr>
</center>
</body>
</html>