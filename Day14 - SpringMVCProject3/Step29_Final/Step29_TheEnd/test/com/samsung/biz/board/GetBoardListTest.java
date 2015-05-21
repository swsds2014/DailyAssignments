package com.samsung.biz.board;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.board.impl.MyBatisDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardListTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("a");
		
		//MyBatisDAO dao = new MyBatisDAO();
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MyBatisDAO dao = (MyBatisDAO)factory.getBean("myBatisDAO");
		
		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
	}

}
