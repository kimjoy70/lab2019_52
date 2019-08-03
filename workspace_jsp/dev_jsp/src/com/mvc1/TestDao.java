package com.mvc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	public TestDao() {
		sqlSessionFactory=mcf.getSqlSessionFactory();		
	}
	public List<Map<String, Object>> subjectList() {
		List<Map<String, Object>> subList = new ArrayList<>();
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			subList = sqlSession.selectList("subjectList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subList;
	}
	public String getExamNo() {
		String exam_no=null;
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			exam_no = sqlSession.selectOne("getExamNo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exam_no;
	}
	public int examReceipt(Map<String, Object> pMap) {
		int result = 0;
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			result = sqlSession.update("examReceipt",pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Map<String, Object>> swDesignExam() {
		logger.info("swDesignExam 호출 성공");
		List<Map<String, Object>> designList = new ArrayList<>();
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			Map<String,Object> pMap = new HashMap<>();
			designList = sqlSession.selectList("swDesignExam",pMap);
			logger.info("pMap ==> "+pMap);
			designList.add(pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return designList;
	}
	public String isOk(Map<String, Object> pMap) {
		logger.info("isOk 호출 성공");
		String msg=null;
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			msg = sqlSession.selectOne("isOk", pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String examPaperAdd(Map<String, Object> pMap) {
		logger.info("examPaperAdd 호출 성공");
		String msg=null;
		int result=0;
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			result = sqlSession.update("proc_exampaper", pMap);
			logger.info("result: "+result+", msg:"+pMap.get("msg1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public int examFee(String p_subcd) {
		logger.info("examFee 호출 성공");
		int fee=0;
		try {
			SqlSession sqlSession = 
					sqlSessionFactory.openSession();
			fee = sqlSession.selectOne("examFee", p_subcd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fee;
	}

}
