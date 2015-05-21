package com.samsung.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samsung.biz.user.impl.MyBatisUserDAO;
import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;
//@Controller는 해당 클래스를 DispatcherServlet이 관리하는 Class로 등록을 한다. 
//등록된 클래스는 클래스가 포함하고 있는 메소드에 @RequestMapping("URL요청이름")을 할당하여 mapping에 등록하게 된다.
//또한 @Controller annotation은 해당 클래스에 구현할 인터페이스를 요구하지 않으므로 메소드 이름을 자유롭게 할당가능

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("myBatisUserDAO")
	private MyBatisUserDAO dao;
	
	@RequestMapping(method=RequestMethod.POST, value="/login.do")
	public String login(UserVO vo, HttpSession session){

		UserVO user = dao.login(vo);
		
		if(user != null){

			session.setAttribute("name", user.getName());
			session.setAttribute("id", user.getId());
			
			return "getBoardList.do";

		}else{
			return "login.jsp";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		//HttpSession session = request.getSession();
		session.invalidate();
		
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("login.jsp");
		//return mav;
		
		return "login.jsp";
	}
}
