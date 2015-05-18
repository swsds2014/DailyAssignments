package com.samsung.biz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.dao.BoardDAO;
import com.samsung.vo.BoardVO;

public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getBoard");
		int bseq=Integer.parseInt(request.getParameter("bseq"));
		BoardDAO dao = new BoardDAO();
		BoardVO board=dao.getBoard(bseq);
		System.out.println(board);
		request.setAttribute("board", board);
		request.getRequestDispatcher("boardDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
