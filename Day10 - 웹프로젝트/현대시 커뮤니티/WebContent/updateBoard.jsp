<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
</script>
</head>

<body>
	<center>
		<h3>글 상세</h3>
		<h3>${id }님 로그인 환영합니다...... Log-out</h3>
		<hr>
		<form action="updateBoardPro" method="post">
			<input name="bseq" type="hidden" value="${board.bseq }" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>제목</td>
					<td align="left" id="btitle"><input type="text" name="btitle"
						value="${board.btitle }" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td align="left" id="buser">${board.buser }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td align="left" id="bcontent"><textarea name='bcontent'
							cols="40" rows="10">${board.bcontent }</textarea></td>
				</tr>
			</table>
			<input type="submit" value="수정" id="submit" />&nbsp;&nbsp;&nbsp; <input
				type="reset" value="취소" />&nbsp;&nbsp;&nbsp;
		</form>
		<a href="getBoardList">목록</a>
	</center>
	<hr>
</body>
</html>










