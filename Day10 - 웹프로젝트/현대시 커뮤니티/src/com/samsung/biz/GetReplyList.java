package com.samsung.biz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.dao.BoardDAO;
import com.samsung.util.JSONUtil;
import com.samsung.vo.ReplyVO;

public class GetReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("getReplyList");
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		BoardDAO dao = new BoardDAO();
		ArrayList<ReplyVO> replyList = dao.getReplyList(bseq);

		System.out.println("replyList : " + replyList);
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(JSONUtil.listToJsonArray(replyList, dao));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
