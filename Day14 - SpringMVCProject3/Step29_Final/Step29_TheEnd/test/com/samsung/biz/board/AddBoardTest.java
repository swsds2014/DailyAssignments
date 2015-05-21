package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.impl.MyBatisDAO;
import com.samsung.biz.board.vo.BoardVO;

public class AddBoardTest {
	public static void main(String[] args) {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 1");
		vo.setNickname("테스트 1");
		vo.setContent("테스트 1");
		vo.setUserid("guest");
		
		MyBatisDAO dao = new MyBatisDAO();
		dao.addBoard(vo);
		
		
	}
}
