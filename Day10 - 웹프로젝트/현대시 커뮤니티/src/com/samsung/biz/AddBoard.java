package com.samsung.biz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samsung.dao.BoardDAO;
import com.samsung.vo.BoardVO;

public class AddBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addBoard");
		
		HttpSession hs=request.getSession();
		String id=(String)hs.getAttribute("id");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		BoardVO vo=new BoardVO();
		vo.setBuser(id);
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		
		BoardDAO dao = new BoardDAO();
		dao.addBoard(vo);
		response.sendRedirect("getBoardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
