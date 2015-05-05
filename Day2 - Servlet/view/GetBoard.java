package com.samsung.board.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.board.impl.BoardDAO;
import com.samsung.board.vo.BoardVO;

import Utils.JDBCUtils;

@WebServlet("/getBoard")
public class GetBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out= response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta chraset=\"UTF-8\">");
		out.println("<html>");
		out.println("<title>GetBoard</title>");
		out.println("</body>");
		out.println("</head>");

		BoardVO vo=new BoardVO();
		BoardDAO dao=new BoardDAO();
		BoardVO board=dao.getBoard(vo);
		
		out.println(board.getSeq()+"-"+board.getTitle()+"-"+board.getNickname()+"-"+board.getContent()+"-"+board.getRegdate()+"-"+board.getCnt()+"-"+board.getUserid());
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
