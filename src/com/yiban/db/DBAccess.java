package com.yiban.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类
 */
public class DBAccess {
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		
		// 通过配置信息构建一个SQLsessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		// 通过sqlsession打开数据库会话
		SqlSession sqlSession = sqlSession = sqlSessionFactory.openSession();
		
		// 返回SQLsession
		return sqlSession;
	}
}
