package com.samsung.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.samsung.biz.common.JDBCUtils;
import com.samsung.biz.user.vo.UserVO;
@Repository("userDAO")
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public UserVO login(UserVO vo){
		//System.out.println(vo);
		
		UserVO user = null; //값을 넣어 리턴하기위해 생성
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//Connection conn = DriverManager.getConnection(url, "hr","hr");
			
			conn = JDBCUtils.getConnection();
			
			String sql = "select * from users where id=? and password=?";
			stmt = conn.prepareStatement(sql); // stmt객체는 값을 세팅하기위해 생성
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()){	//rs값이 비어있는지 검사
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, stmt, rs);
		}
		
		return user;
	}
	
	public void logout(){
		
	}

}
