package com.samsung.biz.users.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.samsung.biz.users.vo.UserVO;

import JDBCUtil.JDBCUtils;

public class UserDAO {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	UserVO user=null;
	
	public UserVO login(UserVO vo){
		try{
			conn=JDBCUtils.getConnection();
			
			String sql="select * from users where id=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			
			
			rs=ps.executeQuery();
			if(rs.next()){
				user=new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				System.out.println(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(conn, ps, rs);
		}
		return user;
	}
}
