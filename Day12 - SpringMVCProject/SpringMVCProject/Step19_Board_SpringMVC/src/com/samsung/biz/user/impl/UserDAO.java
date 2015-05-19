package com.samsung.biz.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.samsung.biz.common.JDBCUtils;
import com.samsung.biz.user.vo.UserVO;

//DB 처리 관련 클래스에 작성하는 annotation.
//Respository를 사용하면 DB와 연결되어 발생하는 sql에러들을 처리하여 스프링 에러들로 변환해 준다.
@Repository("userDAO")
public class UserDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	UserVO user=null;

	public UserVO login(UserVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "hr", "hr");
			
			String sql="select * from users where id=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			
			rs=ps.executeQuery();
			if(rs.next()){
				user=new UserVO();
				String id=rs.getString("id");
				String password=rs.getString("password");
				String name= rs.getString("name");
				String role= rs.getString("role");
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setRole(role);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.close(conn, ps);
		}
		return user;
	}

	public void addBoard() {

	}

	public void getBoard() {

	}

	public void getBoardList() {

	}
}
