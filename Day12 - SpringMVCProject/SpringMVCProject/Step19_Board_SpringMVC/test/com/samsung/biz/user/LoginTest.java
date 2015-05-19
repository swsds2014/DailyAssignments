package com.samsung.biz.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samsung.biz.user.impl.UserDAO;
import com.samsung.biz.user.vo.UserVO;

public class LoginTest {
	public static void main(String[] args) {

		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserVO vo = (UserVO)factory.getBean("userVO");
		vo.setId("guest");
		vo.setPassword("guest123");

		UserDAO dao = (UserDAO)factory.getBean("userDAO");
		UserVO user=dao.login(vo);
		
		if(user!=null){
			System.out.println(user);
		}else{
			System.out.println("User가 존재하지 않음");
		}

	}
}
