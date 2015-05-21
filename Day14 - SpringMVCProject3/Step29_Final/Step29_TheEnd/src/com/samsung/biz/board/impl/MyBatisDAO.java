package com.samsung.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.samsung.biz.board.BoardService;
import com.samsung.biz.board.vo.BoardVO;
import com.samsung.biz.common.MyBatisConnection;

@Repository("myBatisDAO")
public class MyBatisDAO implements BoardService{
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession myBatis;

	public ArrayList<BoardVO> getBoardList(BoardVO vo) {

		System.out.println("MyBatisDAO");
		//myBatis = MyBatisConnection.getConnSession();
		
		List<Object> boardList = myBatis.selectList("getBoardList", vo);
		return (ArrayList)boardList;
	}

	public BoardVO getBoard(BoardVO vo) {
		//myBatis = MyBatisConnection.getConnSession();
		BoardVO board = myBatis.selectOne("getBoard", vo);
		return board;
	}

	public void addBoard(BoardVO vo) {
		//myBatis = MyBatisConnection.getConnSession();
		myBatis.insert("addBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		//myBatis = MyBatisConnection.getConnSession();
		myBatis.update("updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		//myBatis = MyBatisConnection.getConnSession();
		myBatis.delete("deleteBoard", vo);
	}
}
