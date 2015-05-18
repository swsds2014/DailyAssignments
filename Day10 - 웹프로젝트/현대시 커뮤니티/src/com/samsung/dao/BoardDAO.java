package com.samsung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.samsung.util.JDBCUtil;
import com.samsung.vo.BoardVO;
import com.samsung.vo.ReplyVO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	BoardVO board = null;
	ReplyVO reply=null;

	public ArrayList<BoardVO> getBoardList() {

		ArrayList<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();

			String sql = "Select * from board order by bseq desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				board = new BoardVO();
				board.setBseq(rs.getInt("bseq"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBuser(rs.getString("buser"));
				board.setBdate(rs.getDate("bdate"));
				board.setBcnt(rs.getInt("bcnt"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps, rs);
		}
		return boardList;
	}

	public BoardVO getBoard(int bseq) {
		try {
			conn = JDBCUtil.getConnection();

			String sql = "Select * from board where bseq=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bseq);
			rs = ps.executeQuery();

			if (rs.next()) {
				board = new BoardVO();
				board.setBseq(rs.getInt("bseq"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBuser(rs.getString("buser"));
				board.setBdate(rs.getDate("bdate"));
				board.setBcnt(rs.getInt("bcnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps, rs);
		}
		return board;
	}

	public void addBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into board values((select nvl(max(bseq), 0)+1 from board), ?, ?, ?, sysdate, 0)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getBtitle());
			ps.setString(2, vo.getBcontent());
			ps.setString(3, vo.getBuser());
			int cnt=ps.executeUpdate();

			if(cnt==1){
				System.out.println("등록 성공");
			}else{
				System.out.println("등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, ps);
		}
	}

	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();

			String sql = "update board set btitle=?, bcontent=? where bseq=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getBtitle());
			ps.setString(2, vo.getBcontent());
			ps.setInt(3, vo.getBseq());
			int cnt = ps.executeUpdate();
			if (cnt == 1) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 미완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(conn, ps);
		}
	}

	public void deleteBoard(int bseq) {
		try {
			conn = JDBCUtil.getConnection();

			String sql = "delete from board where bseq=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bseq);
			int cnt = ps.executeUpdate();
			if (cnt == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 미완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(conn, ps);
		}
	}

	public ArrayList<ReplyVO> getReplyList(int bseq){
		
		ArrayList<ReplyVO> replyList= new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();

			String sql = "select r.rseq, r.rcontent, r.ruser, r.rdate, r.rlevel, r.rstep, r.bseq from reply r, board b where r.bseq=b.bseq AND r.bseq=?" +
					"order by r.rstep, r.rlevel, rseq";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bseq);
			rs=ps.executeQuery();
			while(rs.next()){
				reply=new ReplyVO();
				reply.setRseq(rs.getInt("rseq"));
				reply.setRcontent(rs.getString("rcontent"));
				reply.setRuser(rs.getString("ruser"));
				reply.setRdate(rs.getDate("rdate"));
				reply.setRlevel(rs.getInt("rlevel"));
				reply.setRstep(rs.getInt("rstep"));
				reply.setBseq(rs.getInt("bseq"));
				replyList.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.close(conn, ps, rs);
		}
		return replyList;
	}
	
	public void addReply(ReplyVO vo) {
		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into reply values ((select nvl(max(rseq), 0)+1 from reply),?,?,sysdate,?," +
					"(select nvl(max(rstep), 0)+1 from reply),?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getRcontent());
			ps.setString(2, vo.getRuser());
			ps.setInt(3, vo.getRlevel());
			ps.setInt(4, vo.getBseq());
			int cnt=ps.executeUpdate();
			if(cnt==1){
				System.out.println("댓글 등록 완료");
			}else{
				System.out.println("댓글 등록 실패");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps);
		}
	}

	public void addReply2(ReplyVO vo){
		try {
			conn = JDBCUtil.getConnection();

			String sql = "insert into reply values ((select nvl(max(rseq), 0)+1 from reply),?,?,sysdate,?," +
					"?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getRcontent());
			ps.setString(2, vo.getRuser());
			ps.setInt(3, vo.getRlevel()+1);
			ps.setInt(4, vo.getRstep()+1);
			ps.setInt(5, vo.getBseq());
			ps.executeUpdate();

			sql="update reply set rstep=rstep+1 where bseq=? and rstep >= ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getBseq());
			ps.setInt(2, vo.getRstep()+1);
			ps.executeUpdate();
			
			int cnt=ps.executeUpdate();
			if(cnt==1){
				System.out.println("댓글2 등록 완료");
			}else{
				System.out.println("댓글2 등록 실패");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, ps);
		}
	}
	
	public void updateReply() {
	}

	public void deleteReply() {
	}
}
