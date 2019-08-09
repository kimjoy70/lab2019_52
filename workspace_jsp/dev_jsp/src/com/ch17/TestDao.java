package com.ch17;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	SqlSessionFactory  sqlMap = null;//����̹� �ε�, Ŀ�ؼ�
	SqlSession session = null;//Ŀ���̳� �ѹ�, �ʿ��� DML���� ȣ���ϴ� �޼ҵ� ����
	public String getCurrentTime(String param){
		logger.info("getCurrentTime ȣ�� ����");
		String time = null;
		try {
			String resource = "com/mybatis/Configuration.xml";
			Reader reader = null;
			reader = Resources.getResourceAsReader(resource);
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMap.openSession(); 
			time = session.selectOne("getCurrentTime", param);
			logger.info("time:"+time);
		} catch (Exception e) {
				e.printStackTrace();
		}
		return time;
	}	
}
