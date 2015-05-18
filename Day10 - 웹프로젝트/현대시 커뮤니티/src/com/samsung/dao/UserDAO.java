package com.samsung.dao;

import java.sql.*;

import com.samsung.util.JDBCUtil;
import com.samsung.vo.UserVO;

public class UserDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void signup(UserVO vo) {
		
		System.out.println("UserDAO > signup(vo)");
		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into users values(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getNickname());
			ps.setString(5, vo.getEmail());
			ps.setDate(6, vo.getBirth());
			ps.setString(7, vo.getIntro());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps);
		}
	}

	public UserVO login(UserVO vo) {

		UserVO user = null;
		
		System.out.println("UserDAO > login(vo)");
		try {

			conn = JDBCUtil.getConnection();
			String sql = "select * from users where id=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());

			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				user.setBirth(rs.getDate("birth"));
				user.setIntro(rs.getString("intro"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		
		return user;
	}

}
