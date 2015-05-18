<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
<style type="text/css">
body {
	text-align: center;
	margin-top: 10%;
}

#header {
	width: 600px;
	margin: 0 auto;
}

#title {
	text-align: left;
	font-size: 30pt;
	font-weight: bold;
}

#msg {
	text-align: right;
	font-size: 10pt;
	color: gray;
}

a {
	color: inherit;
	text-decoration: none;
}

a:HOVER {
	color: aqua;
	text-decoration: underline;
}

.search {
	margin-bottom: 5px;
}

table {
	text-align: center;
	border-collapse: collapse;
	width: 600px;
	margin: auto;
}

table,td,tr,th {
	border: solid gray 1px;
	padding: 2px 5px;
}

table th {
	background-color: lightblue;
}

table#list {
	border-style: hidden;
}
</style>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>

<body>
	<div id="header">
		<div id="title">글 목록</div>
		<div id="msg">
			${id }님 로그인 환영합니다!!!&nbsp;&nbsp;&nbsp;<a href="logout">LOGOUT</a>
		</div>
	</div>

	<!-- 검색 시작 -->
	<form class="search" action="getBoardList.do" method="post">
		<table id="list">
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

	<table>
		<tr>
			<th width="100">번호</th>
			<th width="200">제목</th>
			<th width="150">작성자</th>
			<th width="150">등록일</th>
			<th width="100">조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td width="100">${board.bseq }</td>
				<td align="left" width="200"><a
					href='getBoard?bseq=${board.bseq }'>${board.btitle }</a></td>
				<td width="150">${board.buser }</td>
				<td width="150">${board.bdate }</td>
				<td width="100">${board.bcnt }</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<a href="addBoard.jsp">새글 등록</a>
</body>
</html>



