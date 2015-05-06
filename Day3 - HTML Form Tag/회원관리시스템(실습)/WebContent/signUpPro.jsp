<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="JDBCUtil.JDBCUtils"%>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	int age = Integer.parseInt(request.getParameter("age"));
	int gender = Integer.parseInt(request.getParameter("gender"));
	String[] interests = request.getParameterValues("interests");

	System.out.println(name + " " + password + " " + email + " " + age
			+ " " + gender + " ");

	Connection conn = JDBCUtils.getConnection();

	String sql = "Insert into husers (seq, name, password, email, age, gender, interest) values ((select nvl(max(seq), 0)+1 from husers), ?, ?, ?, ?, ?, ?)";

	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, password);
	ps.setString(3, email);
	ps.setInt(4, age);
	ps.setInt(5, gender);
	String interest = "";
	for (String str : interests) {
		interest += str + " ";
	}
	ps.setString(6, interest);

	ps.executeUpdate();
	JDBCUtils.close(conn, ps);
	response.sendRedirect("getMemberList.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signUpPro.jsp</title>
</head>
<body>

</body>
</html>