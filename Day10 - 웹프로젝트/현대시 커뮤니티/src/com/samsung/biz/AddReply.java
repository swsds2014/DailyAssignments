package com.samsung.biz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samsung.dao.BoardDAO;
import com.samsung.util.JSONUtil;
import com.samsung.vo.ReplyVO;

public class AddReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addReply");
		int bseq=Integer.parseInt(request.getParameter("bseq"));
		String rcontent=request.getParameter("rcontent");
		int rlevel= Integer.parseInt(request.getParameter("rlevel"));
		HttpSession hs=request.getSession();
		String ruser=(String)hs.getAttribute("id");
		
		ReplyVO vo = new ReplyVO();
		vo.setBseq(bseq);
		vo.setRcontent(rcontent);
		vo.setRlevel(rlevel);
		vo.setRuser(ruser);
		BoardDAO dao = new BoardDAO();
		dao.addReply(vo);
		ArrayList<ReplyVO> replyList=dao.getReplyList(bseq);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(JSONUtil.listToJsonArray(replyList, dao));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
