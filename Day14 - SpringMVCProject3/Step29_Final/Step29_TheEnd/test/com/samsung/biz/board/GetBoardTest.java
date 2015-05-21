package com.samsung.biz.board;

import com.samsung.biz.board.impl.MyBatisDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardTest {
	public static void main(String[] args) {
		
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		
		MyBatisDAO dao = new MyBatisDAO();
		BoardVO board = dao.getBoard(vo);
		System.out.println(board);
	}
}
