package com.util;

import java.io.FileNotFoundException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {
	private static SqlSessionFactory sqlSessionFactory = null;
	public static void init() {
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			/* String resource = "com/mybatis/Configuration.xml"; */
			Reader reader = Resources.getResourceAsReader(resource);
			if(sqlSessionFactory==null) {
				sqlSessionFactory = 
						new SqlSessionFactoryBuilder().build(reader, "development");
			}
		} catch (FileNotFoundException ffe) {
			ffe.getMessage();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory;
	}
	
}
