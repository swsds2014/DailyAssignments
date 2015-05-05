package com.samsung.board.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

@WebServlet("/updateBoard")
public class UpdateBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		BoardVO vo= new BoardVO();
		vo.setSeq(8);
		vo.setTitle("변경된 타이틀");
		vo.setNickname("변경된 닉네임");
		vo.setContent("변경된 콘텐츠");
		
		BoardDAO dao=new BoardDAO();
		dao.updateBoard(vo);

		response.sendRedirect("getBoardList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
