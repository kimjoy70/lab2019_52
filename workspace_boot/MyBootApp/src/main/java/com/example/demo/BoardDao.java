package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	private static final Logger logger = LogManager.getLogger(BoardDao.class);	
	protected static final String NAMESPACE = "com.example.demo.";

	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> getBoardList() {
		logger.info("getBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = sqlSession.selectList(NAMESPACE + "getBoardList");
		logger.info("boardList.size():"+boardList.size());
		return boardList;
	}
}
