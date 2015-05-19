package com.samsung.biz.board;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.board.impl.BoardServiceImpl;
import com.samsung.biz.board.service.BoardService;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardListTest {
	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

		BoardVO vo= (BoardVO)factory.getBean("boardVO");
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		BoardServiceImpl boardServiceImpl = (BoardServiceImpl)factory.getBean("boardServiceImpl");
		BoardService dao=boardServiceImpl.getBoardDAO();
		
		ArrayList<BoardVO> boardList=dao.getBoardList(vo);
		if(boardList!=null){
			for (BoardVO boardVO : boardList) {
				System.out.println(boardVO);
			}
		}else{
			System.out.println("board에 내용이 존재하지 않음");
		}
	}
}
