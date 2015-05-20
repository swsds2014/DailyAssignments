package com.samsung.biz.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.samsung.biz.board.service.BoardService;
import com.samsung.biz.board.vo.BoardVO;
import com.samsung.biz.common.JDBCUtils;

@Repository("fileDAO")
public class FileDAO implements BoardService{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BoardVO board = null;

	public ArrayList<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("FileDAO");
		conn = JDBCUtils.getConnection();
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
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
				board.setUserid(rs.getString("userid"));
				board.setCnt(rs.getInt("cnt"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
		return boardList;
	}

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
				board.setUserid(rs.getString("userid"));
				board.setCnt(rs.getInt("cnt"));
				board.setTitle(rs.getString("title"));
				board.setNickname(rs.getString("nickname"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getDate("regdate"));
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
			String sql = "insert into board (seq, title, nickname, content, userid)"
					+ "values ((select nvl(max(seq), 0)+1 from board),?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getNickname());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getUserid());
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
}
