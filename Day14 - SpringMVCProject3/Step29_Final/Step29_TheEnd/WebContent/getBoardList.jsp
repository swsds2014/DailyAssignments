<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>

<body>
	<center>
		<h1>�� ���</h1>
		<h3>
			${sessionScope.name }�� �α��� ȯ���մϴ�...... <a href="logout.do">Log-out</a>
		</h3>

		<!-- �˻� ���� -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="TITLE">����
							<option value="CONTENT">����
					</select> 
					<input name="searchKeyword" type="text" /> 
					<input type="submit" value="�˻�" />
					</td>
				</tr>
			</table>
		</form>
		<!-- �˻� ���� -->

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">��ȣ</th>
				<th bgcolor="orange" width="200">����</th>
				<th bgcolor="orange" width="150">�ۼ���</th>
				<th bgcolor="orange" width="150">�����</th>
				<th bgcolor="orange" width="100">��ȸ��</th>
			</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<th width="100">${board.seq }</th>
				<th width="200"><a href="getBoard.do?seq=${board.seq }">${board.title }</a></th>
				<th width="150">${board.nickname }</th>
				<th width="150">${board.regdate }</th>
				<th width="100">${board.cnt }</th>
			</tr>
		</c:forEach>
		</table>
		<br> <a href="addBoard.jsp">���� ���</a>
	</center>
</body>
</html>



