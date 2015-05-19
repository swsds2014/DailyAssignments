package com.samsung.view.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardListController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav=new ModelAndView();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			mav.setViewName("login.jsp");
			return mav;
		}
		
		String searchCondition="";
		String searchKeyword="";
		
		if(request.getParameter("searchCondition")==null){
			searchCondition="TITLE";
		}else{
			searchCondition=request.getParameter("searchCondition");
		}
		
		if(request.getParameter("searchKeyword")==null){
			searchKeyword="";
		}else{
			searchKeyword=request.getParameter("searchKeyword");
		}

		BoardDAO dao = new BoardDAO();
		
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);

		ArrayList<BoardVO> boardList = dao.getBoardList(vo);
		mav.addObject("boardList", boardList);
		
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
