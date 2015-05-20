package com.samsung.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

@Controller
public class UserController {

	//Web.xml에 등록된 DispatcherServlet은 페이지 이동은 ModelAndView의 setViewName("pageName")로
	//받는 문자열 뿐만 아니라, 일반 문자열도 처리가 가능하다.
	
	//따라서 모든 메소드의 리턴 타입이 String이어도 문제될 것이 없다!
	
	@RequestMapping(method=RequestMethod.POST, value="login.do")
	public String login(ModelAndView mav, UserDAO dao, UserVO vo, HttpSession session){
		
		UserVO user = dao.login(vo);
		if(user!=null){
			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			return "getBoardList.do";
		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping("logout.do")
	public String handleRequest(ModelAndView mav, HttpSession session) {
		session.invalidate();
		return "login.jsp";
	}
}
