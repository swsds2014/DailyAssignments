package com.samsung.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBCUtil.JDBCUtils;

import com.samsung.biz.board.vo.BoardVO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BoardVO board = null;

	public void addBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();

			String sql = "";
			if (vo.getRegdate() == null) {
				sql = "insert into board (seq, title, nickname, content, regdate, userid)"
						+ "values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate, 'guest')";
			} else {
				sql = "insert into board (seq, title, nickname, content, regdate, userid)"
						+ "values ((select nvl(max(seq), 0)+1 from board), ?, ?, ?, ?, 'guest')";
			}

			ps = conn.prepareStatement(sql);
			if (vo.getRegdate() == null) {
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getNickname());
				ps.setString(3, vo.getContent());
			} else {
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getNickname());
				ps.setString(3, vo.getContent());
				ps.setDate(4, vo.getRegdate());
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps);
		}
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtils.getConnection();
			String sql = "update board set title=?, content=? where seq=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
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

	// ResultSet 값을 적절히 처리해서 넘겨야 한다.
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
				board.setContent(rs.getString("content"));
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

	// 모든 ResultSet 값을 적절히 처리해서 넘겨야 한다.
	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "";
			if (vo.getSearchCondition().equals("TITLE")) {
				sql = "select * from board where title like '%'||?||'%' order by seq";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getSearchKeyword());
			} else if (vo.getSearchCondition().equals("CONTENT")) {
				sql = "select * from board where content like '%'||?||'%' order by seq";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getSearchKeyword());
			} else {
				sql = "select * from board order by seq";
				ps = conn.prepareStatement(sql);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				board = new BoardVO();
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
