package com.samsung.biz.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardTest {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BoardVO vo= (BoardVO)factory.getBean("boardVO");
		vo.setSeq(1);
		
		BoardDAO dao = (BoardDAO)factory.getBean("boardDAO");
		BoardVO board=dao.getBoard(vo);
		
		if(board!=null){
				System.out.println(board);
		}else{
			System.out.println("board에 내용이 존재하지 않음");
		}
	}
}
