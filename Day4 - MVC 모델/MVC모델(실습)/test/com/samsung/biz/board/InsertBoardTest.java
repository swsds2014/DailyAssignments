package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.vo.BoardVO;

public class InsertBoardTest {
	public static void main(String[] args) {
		BoardVO vo= new BoardVO();
		vo.setTitle("테스트 타이틀");
		vo.setNickname("테스트 이름");
		vo.setContent("테스트 내용");
		
		BoardDAO dao=new BoardDAO();
		dao.addBoard(vo);
	}
}
