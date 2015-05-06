<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.JDBCUtils"%>
<%
	Connection conn = JDBCUtils.getConnection();
	String sql = "select * from husers order by seq";
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getMemberList.jsp</title>
</head>
<body>
	<div align="center">
		<h3>회원 리스트</h3>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">회원번호</th>
			<th bgcolor="orange" width="200">이름</th>
			<th bgcolor="orange" width="150">이메일</th>
			<th bgcolor="orange" width="100">나이</th>
			<th bgcolor="orange" width="100">성별</th>
			<th bgcolor="orange" width="500">관심사</th>
		</tr>
		<%
			while (rs.next()) {
				int seq = rs.getInt("seq");
				String gender = "";
				if(rs.getInt("gender")==0){
					gender="남";					
				}else{		
					gender="여";					
				}
		%>
		<tr>
			<th width="100"><%=seq%></th>
			<th width="200"><%=rs.getString("name")%></th>
			<th width="150"><%=rs.getString("email")%></th>
			<th width="100"><%=rs.getInt("age")%></th>
			<th width="100"><%=gender%></th>
			<th width="500"><%=rs.getString("interest")%></th>
		</tr>
		<%
			}
			JDBCUtils.close(conn, ps, rs);
		%>
	</table>
	<br>
	<button onclick="location.href='signUp.jsp'">회원가입</button>
	</div>
</body>
</html>