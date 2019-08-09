package com.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BookDao {
	Logger logger = Logger.getLogger(BookDao.class);

	public List<Map<String, Object>> getBookList() {
		logger.info("getBookList»£√‚");
		List<Map<String,Object>> bookList = 
				new ArrayList<Map<String,Object>>();
		logger.info(bookList.size());//0
		return bookList;
	}

	public int bookInsert(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return 1;
	}

	public int bookUpdate(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return 1;
	}

	public int bookDelete(Map<String, Object> pMap) {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
