package com.samsung.view.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samsung.biz.board.service.BoardService;
import com.samsung.biz.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("fileDAO")
	private BoardService dao;
	
	@RequestMapping("addBoard.do")
	public String addBoard(@RequestParam("sample1") String sample1, @RequestParam("sample2") String sample2, Model m, BoardVO vo, HttpSession session) {

		System.out.println(sample1);
		System.out.println(sample2);
		
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			return "login.jsp";
		}
		vo.setUserid(userid);
		dao.addBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("updateBoard.do")
	public String UpdateBoard(Model m, BoardVO vo, HttpSession session) {

		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			return "login.jsp";
		}

		dao.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(Model m, BoardVO vo, HttpSession session) {

		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			return "login.jsp";
		}
		dao.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("getBoard.do")
	public String getBoard(Model m, BoardVO vo, HttpSession session) {

		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			return "login.jsp";
		}
		BoardVO board = dao.getBoard(vo);
		m.addAttribute("board", board);
		return "getBoard.jsp";	
				
	}
	
	@RequestMapping("getBoardList.do")
	public String getBoardList(Model m, BoardVO vo, HttpSession session) {

		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			return "login.jsp";
		}
		
		if(vo.getSearchCondition()==null){
			vo.setSearchCondition("TITLE");
		}
		
		if(vo.getSearchKeyword()==null){
			vo.setSearchKeyword("");
		}
		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		m.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
}
