package com.samsung.biz.board.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String searchCondition = "";
		if (request.getParameter("searchCondition") != null) {
			searchCondition = (String) request.getParameter("searchCondition");
		}

		String searchKeyword = "";
		if (request.getParameter("searchKeyword") != null) {
			searchKeyword = (String) request.getParameter("searchKeyword");
		}
		
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList(vo);
		System.out.println(list);

		request.setAttribute("list", list);
		request.getRequestDispatcher("getBoardList.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
