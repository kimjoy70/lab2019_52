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
	SqlSessionFactory  sqlMap = null;//드라이버 로딩, 커넥션
	SqlSession session = null;//커밋이나 롤백, 필요한 DML구문 호출하는 메소드 제공	
	public String login(String p_id, String p_pw) {
		logger.info("login호출 성공");
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
			logger.info("이름 : "+pMap.get("r_name"));
			//위에서 이름 정보는 출력을 확인했으므로 지역변수 mem_name에
			//pMap에 담긴 이름 정보를 mem_name에 담아 줘야 하겠지요...
			mem_name = pMap.get("r_name").toString();
		}catch(Exception e) {
			logger.info("Exception:"+e.toString());
		}
		return mem_name;
	}
	/*
	 * public List<Map<String,Object>> my_proc() { logger.info("my_proc 호출 성공"); try
	 * { String resource = "com/mybatis/MapperConfig.xml"; Reader reader = null;
	 * reader = Resources.getResourceAsReader(resource); sqlMap = new
	 * SqlSessionFactoryBuilder().build(reader); session = sqlMap.openSession();
	 * Map<String,Object> pMap = new HashMap<String,Object>();
	 * session.selectOne("proc_login", pMap);
	 * logger.info("이름 : "+pMap.get("r_name")); //위에서 이름 정보는 출력을 확인했으므로 지역변수
	 * mem_name에 //pMap에 담긴 이름 정보를 mem_name에 담아 줘야 하겠지요... mem_name =
	 * pMap.get("r_name").toString(); }catch(Exception e) {
	 * logger.info("Exception:"+e.toString()); } return mem_name; }
	 */
	
}
