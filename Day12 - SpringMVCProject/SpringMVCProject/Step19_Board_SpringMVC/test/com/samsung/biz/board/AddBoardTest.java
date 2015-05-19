package com.samsung.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class AddBoardTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BoardVO vo= (BoardVO)factory.getBean("boardVO");
		vo.setTitle("테스트 1");
		vo.setNickname("테스트 1");
		vo.setContent("테스트 1");
		vo.setUserid("guest");
		
		BoardDAO dao = (BoardDAO)factory.getBean("boardDAO");
		dao.addBoard(vo);
	}
}
