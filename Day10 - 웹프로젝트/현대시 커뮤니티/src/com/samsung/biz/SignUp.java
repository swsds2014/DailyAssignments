package com.samsung.biz;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.dao.UserDAO;
import com.samsung.vo.UserVO;

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserVO vo = new UserVO();
		
		String id = request.getParameter("id");
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date birth = Date.valueOf(request.getParameter("birth"));
		String intro = request.getParameter("intro");
				
		vo.setId(id);
		vo.setNickname(nickname);
		vo.setName(name);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setIntro(intro);
		
		// 비밀번호 확인이 불일치시
		if(!request.getParameter("password1").equals(request.getParameter("password2"))) {
			vo.setPassword(request.getParameter("password1"));
			String msg = " 불일치";
			request.setAttribute("msg", msg);
			request.setAttribute("id", id);
			request.setAttribute("nickname", nickname);
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("birth", birth);
			request.setAttribute("intro", intro);
			System.out.println("비밀번호 확인 if 문 내부");
			
			RequestDispatcher view = request
					.getRequestDispatcher("signup.jsp");
			view.forward(request, response);
			
		} else {
			vo.setPassword(request.getParameter("password1"));
			System.out.println("비밀번호 확인 else 문 내부");
			
			System.out.println(vo);
			
			UserDAO dao = new UserDAO();
			dao.signup(vo);
		
			response.sendRedirect("login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
