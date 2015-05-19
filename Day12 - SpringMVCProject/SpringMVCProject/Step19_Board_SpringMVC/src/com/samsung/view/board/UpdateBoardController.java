package com.samsung.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.board.service.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class UpdateBoardController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav=new ModelAndView();
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("id");
		if (userid == null) {
			mav.setViewName("login.jsp");
			return mav;
		}

		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);

		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
		mav.setViewName("getBoardList.do");
		return mav;
	}
}
