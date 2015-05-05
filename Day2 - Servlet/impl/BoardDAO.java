package com.samsung.board.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.samsung.board.vo.BoardVO;

import Utils.JDBCUtils;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BoardVO board=null;

	public BoardVO getBoard(BoardVO vo) {

		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from board where seq=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSeq());
			rs = ps.executeQuery();

			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return board;
	}

	public void addBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into board (seq, title, nickname, content, regdate, userid)"
					+ "values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 'guest')";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getNickname());
			ps.setString(3, vo.getContent());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps);
		}
	}

	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();
			
			String sql = "delete from board where seq=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vo.getSeq());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps);
		}
	}
	
	public void updateBoard(BoardVO vo){
		try {
			
			conn = JDBCUtils.getConnection();
			String sql = "update board set title=?, nickname=?, content=? where seq=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getNickname());
			ps.setString(3, vo.getContent());
			ps.setInt(4, vo.getSeq());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps);
		}
	}
	
	public ArrayList<BoardVO> getBoardList(){
		
		ArrayList<BoardVO> list=new ArrayList<BoardVO>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from Board";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				board=new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setUserid(rs.getString("userid"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return list;
	}
}
