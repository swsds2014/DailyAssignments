<%@page import="com.samsung.biz.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.*"%>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
	HttpSession hs = request.getSession();
	String id = (String) hs.getAttribute("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>

<body>
	<center>
		<h3>글 상세</h3>
		<h3><%=id %>님 로그인 환영합니다...... <a href="logout">Log-out</a></h3>
		<hr>
		<form action="updateBoard" method="post">
			<input name="seq" type="hidden" value="<%=board.getSeq()%>" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>제목</td>
					<td align="left"><input name="title" type="text"
						value="<%=board.getTitle()%>" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left"><%=board.getNickname()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"><%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td align="left"><%=board.getRegdate()%></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="addBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; <a
			href="deleteBoard?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList">글목록</a>
	</center>
</body>
</html>










