package com.samsung.board.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

import Utils.JDBCUtils;

@WebServlet("/getBoardList")
public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta chraset=\"UTF-8\">");
		out.println("<html>");
		out.println("<title>GetBoardList</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>게시물 목록</h3>");
		
		BoardDAO dao=new BoardDAO();
		ArrayList<BoardVO> list=dao.getBoardList();
		
		for (BoardVO b : list) {
			out.println(b.getSeq()+" "+b.getTitle()+" "+b.getNickname()+" "+b.getContent()+"<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
