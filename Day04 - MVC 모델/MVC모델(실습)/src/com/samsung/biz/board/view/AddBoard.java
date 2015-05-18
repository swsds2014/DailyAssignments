package com.samsung.biz.board.view;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.biz.board.impl.BoardDAO;
import com.samsung.biz.board.vo.BoardVO;

public class AddBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title= request.getParameter("title");
		String nickname= request.getParameter("nickname");
		String content= request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setNickname(nickname);
		vo.setContent(content);
		
		Date today=null;
		if(request.getParameter("regdate")!=null){
			//request.getParameter는 무조건! 무조건! 스트링 타입으로 넘어온다!! 그래서 반드시 형변환을 해주어야 한다!!
			today=Date.valueOf(request.getParameter("regdate"));
			vo.setRegdate(today);
		}
		
		BoardDAO dao=new BoardDAO();
		dao.addBoard(vo);
		
		response.sendRedirect("getBoardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
