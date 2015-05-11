package com.samsung.biz.board.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardVO vo=new BoardVO();
		vo.setSeq(seq);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO dao= new BoardDAO();
		dao.updateBoard(vo);
		
		response.sendRedirect("getBoardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
