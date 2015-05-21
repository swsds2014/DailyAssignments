package com.samsung.biz.board.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.samsung.biz.board.vo.BoardVO;

// 어떤 클래스(FileDAO, BoardDAO)를 생성해서 그 클래스가
// 가지고 있는 메소드를 호출 할 것인가만 결정

@Service("boardService")
public class BoardServiceFactory {
	@Autowired
	@Qualifier("myBatisDAO")
	private MyBatisDAO boardDAO;
	
	public void addBoard(BoardVO vo){
		boardDAO.addBoard(vo);
	}
	public void updateBoard(BoardVO vo){
		boardDAO.updateBoard(vo);
	}
	public void deleteBoard(BoardVO vo){
		boardDAO.deleteBoard(vo);
	}
	
	public BoardVO getBoard(BoardVO vo){
		return boardDAO.getBoard(vo);
	}
	
	public ArrayList<BoardVO> getBoardList(BoardVO vo){
		return boardDAO.getBoardList(vo);
	}
	
}
