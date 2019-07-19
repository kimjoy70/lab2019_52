package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardLogic {
	private static final Logger logger = LogManager.getLogger(BoardLogic.class);
	@Autowired
	public BoardDao boardDao = null;
	public List<Map<String, Object>> getBoardList() {
		logger.info("getBoardList 호출 성공");
		List<Map<String, Object>> boardList = boardDao.getBoardList();
		return boardList;
	}
	
	
	
}
