package com.samsung.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if (rs != null) {try {rs.close();} catch (SQLException e) {	e.printStackTrace();}}
		if (ps != null) {try {ps.close();} catch (SQLException e) {	e.printStackTrace();}}
		if (conn != null) {try {conn.close();} catch (SQLException e) {	e.printStackTrace();}}
	}
	
	public static void close(Connection conn, PreparedStatement ps){
		if (ps != null) {try {ps.close();} catch (SQLException e) {	e.printStackTrace();}}
		if (conn != null) {try {conn.close();} catch (SQLException e) {	e.printStackTrace();}}
	}
}
