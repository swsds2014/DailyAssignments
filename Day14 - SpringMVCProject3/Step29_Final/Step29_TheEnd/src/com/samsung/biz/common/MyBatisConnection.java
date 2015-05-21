package com.samsung.biz.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnection {
	private static SqlSession sqlSession;

	static {
		String resource = "sql-map-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
					.build(reader);

			// Connecton 객체를 사용할 때 auto Commit을 사용할지 여부를 지정한다.
			// qlMapper.openSession() => auto commit 안함
			// DB 명령 실행 후 항상 commit 명령을 실행해야 적용
			// qlMapper.openSession(true) => auto commit 사용(자동 적용)
			sqlSession = sqlMapper.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getConnSession() {
		return sqlSession;
	}
}
