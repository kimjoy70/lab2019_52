package com.mvc2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BookDao {
	Logger logger = Logger.getLogger(BookDao.class);
	public List<Map<String, Object>> getBookList() {
		logger.info("getBookLis 호출 성공.");
		List<Map<String, Object>> bookList = null;
		return bookList;
	}

}
