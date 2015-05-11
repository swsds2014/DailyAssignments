package com.samsung.biz.board;

import java.util.ArrayList;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.vo.BoardVO;

public class GetBoardListTest {
	public static void main(String[] args) {
		BoardDAO dao=new BoardDAO();
		ArrayList<BoardVO> list=dao.getBoardList();
		for (BoardVO boardVO : list) {
			System.out.println(boardVO);
		}
	}
}
