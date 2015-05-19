package com.samsung.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

//spring Controller도 handleRequest를 구현하도록 되어 있고
//리턴타입이 ModelAndView 객체로 지정되어 있다.
//Model과 View가 함께 지정 가능한 객체
//Model는 request객체에 값을 저장해 주는 기능
//View는 String타입으로 이동할 페이지를 설정하는 기능
//Return 되는 ModelAndView객체는 web.xml에 등록된
//Spring의 DispatcherServlet 객체가 받아 model은 request에 view는 RequestDispatcher에 담아
//처리하도록 한다.

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav=new ModelAndView();

		String id= request.getParameter("id");
		String password=request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		UserVO user = dao.login(vo);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			mav.setViewName("getBoardList.do");
		}else{
			mav.setViewName("login.jsp");
		}
		return mav;
	}
}
