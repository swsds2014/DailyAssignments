package com.samsung.view.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.biz.board.BoardService;
import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.impl.BoardServiceFactory;
import com.samsung.biz.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardService")
	private BoardServiceFactory dao;
	
	@RequestMapping("addBoard.do")
	public String addBoard(@RequestParam("sample1") String sample1, @RequestParam("sample2") String sample2,  BoardVO vo, HttpSession session ) {
		System.out.println(sample1 + " : " + sample2);

		String id = (String)session.getAttribute("id");
		
		if(id == null){
			return "login.jsp";
		}
		dao.addBoard(vo);

		return "getBoardList.do";
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo,  HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		if(id == null){

			return "login.jsp";
		}
		
		dao.deleteBoard(vo);

		return "getBoardList.do";
	}
	
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo, HttpSession session) {
		String id = (String)session.getAttribute("id");

		if(id == null){
			
			return "login.jsp";
		}
		
		dao.updateBoard(vo);

		return "getBoardList.do";
	}
	
	
	@RequestMapping("getBoard.do")
	public String getBoard(BoardVO vo, HttpSession session, Model md) {
		String id = (String) session.getAttribute("id");

		if (id == null) {

			return "login.jsp";
		}

		BoardVO board = dao.getBoard(vo);

		md.addAttribute("board", board);
		return "getBoard.jsp";
	}

	
	@RequestMapping("getBoardList.do")
	public String getBoardList(BoardVO vo, HttpSession session, Model md) {

		String id = (String)session.getAttribute("id");
		if(id == null){	
			return "login.jsp";
		}
		
		if(vo.getSearchCondition() == null ){
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword() == null ){
			vo.setSearchKeyword("");
		}
		
		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		
		md.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
}
