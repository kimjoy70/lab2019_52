package com.mvc2;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class BoardSubDao {
	Logger logger = Logger.getLogger(BoardMasterDao.class);
	private SqlSessionFactory sqlSessionFactory = null;
	public BoardSubDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
		logger.info("sqlSessionFactory: "+sqlSessionFactory);
	}
	public int boardSINS(Map<String, Object> pMap) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.update("boardSINS", pMap);
		return result;
	}
	public void boardSDelete(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		
	}

}
