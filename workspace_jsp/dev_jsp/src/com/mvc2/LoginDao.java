package com.mvc2;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class LoginDao {
	Logger logger = Logger.getLogger(LoginDao.class);
	SqlSessionFactory  sqlMap = null;//����̹� �ε�, Ŀ�ؼ�
	SqlSession session = null;//Ŀ���̳� �ѹ�, �ʿ��� DML���� ȣ���ϴ� �޼ҵ� ����	
	public String login(String p_id, String p_pw) {
		logger.info("loginȣ�� ����");
		String mem_name = "";
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = null;//IO
			reader = Resources.getResourceAsReader(resource);
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMap.openSession(); 
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("mem_id", p_id);
			pMap.put("mem_pw", p_pw);
			session.selectOne("proc_login", pMap);	
			logger.info("�̸� : "+pMap.get("r_name"));
			//������ �̸� ������ ����� Ȯ�������Ƿ� �������� mem_name��
			//pMap�� ��� �̸� ������ mem_name�� ��� ��� �ϰ�����...
			mem_name = pMap.get("r_name").toString();
		}catch(Exception e) {
			logger.info("Exception:"+e.toString());
		}
		return mem_name;
	}
	/*
	 * public List<Map<String,Object>> my_proc() { logger.info("my_proc ȣ�� ����"); try
	 * { String resource = "com/mybatis/MapperConfig.xml"; Reader reader = null;
	 * reader = Resources.getResourceAsReader(resource); sqlMap = new
	 * SqlSessionFactoryBuilder().build(reader); session = sqlMap.openSession();
	 * Map<String,Object> pMap = new HashMap<String,Object>();
	 * session.selectOne("proc_login", pMap);
	 * logger.info("�̸� : "+pMap.get("r_name")); //������ �̸� ������ ����� Ȯ�������Ƿ� ��������
	 * mem_name�� //pMap�� ��� �̸� ������ mem_name�� ��� ��� �ϰ�����... mem_name =
	 * pMap.get("r_name").toString(); }catch(Exception e) {
	 * logger.info("Exception:"+e.toString()); } return mem_name; }
	 */
	
}
