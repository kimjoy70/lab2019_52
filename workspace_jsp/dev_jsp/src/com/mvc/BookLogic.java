package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BookLogic {
	Logger logger = Logger.getLogger(BookLogic.class);
	BookDao bDao = new BookDao();
	/*
	 * 스프링 프레임워크를 사용하는 경우 DI활용한다.
	 * 차이점은 객체에 대한 라이프 사이클관리를 받는다.
	 * 좋은점:필요한 시점에 객체를 주입 받으므로 NullPointerException을 피할 수 있다.
	private BookDao bDao = null;
	public void setbDao(BookDao bDao) {
		this.bDao = bDao;
	}
	*/
	public List<Map<String,Object>> getBookList(Map<String, Object> pMap){
		logger.info("getBookList 호출");
		List<Map<String,Object>> bookList = null;
		bookList = bDao.getBookList();
		return bookList;
	}
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert 호출");
		int result = 0;
		result = bDao.bookInsert(pMap);
		return result;
	}
	public int bookUpdate(Map<String, Object> pMap) {
		logger.info("bookUpdate 호출");
		int result = 0;
		result = bDao.bookUpdate(pMap);
		return result;
	}
	public int bookDelete(Map<String, Object> pMap) {
		logger.info("bookDelete 호출");
		int result = 0;
		result = bDao.bookDelete(pMap);
		return result;
	}

}
