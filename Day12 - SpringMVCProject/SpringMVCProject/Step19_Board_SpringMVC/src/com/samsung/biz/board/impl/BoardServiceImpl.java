package com.samsung.biz.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.samsung.biz.board.service.BoardService;

@Service("boardServiceImpl")
public class BoardServiceImpl {
	
	@Autowired
	@Qualifier("fileDAO")
	private BoardService boardDAO;

	public BoardService getBoardDAO() {
		return boardDAO;
	}

	public void setBoardDAO(BoardService boardDAO) {
		this.boardDAO = boardDAO;
	}
}
