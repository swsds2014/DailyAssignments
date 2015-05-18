package com.samsung.biz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.dao.BoardDAO;
import com.samsung.vo.BoardVO;

public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getBoardList");
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> boardList=dao.getBoardList();
		System.out.println(boardList);
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
