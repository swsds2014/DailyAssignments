package com.samsung.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class DeleteBoardTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BoardVO vo= (BoardVO)factory.getBean("boardVO");
		vo.setSeq(28);
		
		BoardDAO dao = (BoardDAO)factory.getBean("boardDAO");
		dao.deleteBoard(vo);
	}
}
