package com.samsung.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class AddBoardController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		ModelAndView mav=new ModelAndView();
		
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			mav.setViewName("login.jsp");
			return mav;
		}

		String title = request.getParameter("title");
		String nickname = request.getParameter("nickname");
		String content = request.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setNickname(nickname);
		vo.setContent(content);
		vo.setUserid(userid);

		BoardDAO dao = new BoardDAO();
		dao.addBoard(vo);
		
		mav.setViewName("getBoardList.do");
		return mav;
		
	}
}
