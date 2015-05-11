<%@page import="java.util.ArrayList"%>
<%@page import="com.samsung.biz.board.vo.BoardVO"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.JDBCUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>) request
			.getAttribute("list");
	HttpSession hs = request.getSession();
	String id = (String) hs.getAttribute("id");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>

<body>
	<center>
		<h1>글 목록</h1>
		<h3>
			<%=id %>님 로그인 환영합니다...... <a href="logout">Log-out</a>
		</h3>

		<!-- 검색 시작 -->
		<form action="getBoardList" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="TITLE">제목
							<option value="CONTENT">내용
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="검색" /></td>
				</tr>
			</table>
		</form>
		<!-- 검색 종료 -->

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<%
				for (BoardVO b : list) {
			%>
			<tr>
				<th width="100"><%=b.getSeq()%></th>
				<th width="200"><a href="getBoard?seq=<%=b.getSeq()%>"><%=b.getTitle()%></a></th>
				<th width="150"><%=b.getNickname()%></th>
				<th width="150"><%=b.getRegdate()%></th>
				<th width="100"><%=b.getCnt()%></th>
			</tr>
			<%
				}
			%>
		</table>
		<br> <a href="addBoard.jsp">새글 등록</a>
	</center>
</body>
</html>



