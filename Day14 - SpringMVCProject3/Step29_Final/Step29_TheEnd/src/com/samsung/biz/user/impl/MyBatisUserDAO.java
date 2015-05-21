package com.samsung.biz.user.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.samsung.biz.common.MyBatisConnection;
import com.samsung.biz.user.vo.UserVO;

@Repository("myBatisUserDAO")
public class MyBatisUserDAO {
	
	@Autowired
	@Qualifier("sqlSession")
	private SqlSession myBatis = null;
	
	public UserVO login(UserVO vo){
		//myBatis = MyBatisConnection.getConnSession();
		UserVO user = myBatis.selectOne("getUser", vo);
		return user;
	}
}
