<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���۵��</title>
</head>
<body>
<center>
	<h3>���� ����ϱ�............<a href='logout.do'>LOG-OUT</a></h3>
	<hr>
		<form action="addBoard.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>����</td><td align="left"><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>Sample1</td><td align="left"><input type="text" name="sample1"/></td>
			</tr>
			<tr>
				<td>Sample2</td><td align="left"><input type="text" name="sample2"/></td>
			</tr>
			<tr>
				<td>�ۼ���</td><td align="left"><input type="text" name="nickname" size="10"/></td>
			</tr>
			<tr>
				<td>����</td><td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value=" ���� ��� "/></td>
			</tr>
		</table>
		</form>
	<hr>
</center>
</body>
</html>