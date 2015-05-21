package com.samsung.biz.board;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.impl.MyBatisDAO;
import com.samsung.biz.board.vo.BoardVO;

public class UpdateBoardTest {
	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("New Title");
		vo.setContent("New Content");
		vo.setSeq(10);
		
		MyBatisDAO dao = new MyBatisDAO();
		dao.updateBoard(vo);
	}
}
