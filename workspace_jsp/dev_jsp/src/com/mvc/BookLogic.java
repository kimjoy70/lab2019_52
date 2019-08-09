package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BookLogic {
	Logger logger = Logger.getLogger(BookLogic.class);
	BookDao bDao = new BookDao();
	/*
	 * ������ �����ӿ�ũ�� ����ϴ� ��� DIȰ���Ѵ�.
	 * �������� ��ü�� ���� ������ ����Ŭ������ �޴´�.
	 * ������:�ʿ��� ������ ��ü�� ���� �����Ƿ� NullPointerException�� ���� �� �ִ�.
	private BookDao bDao = null;
	public void setbDao(BookDao bDao) {
		this.bDao = bDao;
	}
	*/
	public List<Map<String,Object>> getBookList(Map<String, Object> pMap){
		logger.info("getBookList ȣ��");
		List<Map<String,Object>> bookList = null;
		bookList = bDao.getBookList();
		return bookList;
	}
	public int bookInsert(Map<String, Object> pMap) {
		logger.info("bookInsert ȣ��");
		int result = 0;
		result = bDao.bookInsert(pMap);
		return result;
	}
	public int bookUpdate(Map<String, Object> pMap) {
		logger.info("bookUpdate ȣ��");
		int result = 0;
		result = bDao.bookUpdate(pMap);
		return result;
	}
	public int bookDelete(Map<String, Object> pMap) {
		logger.info("bookDelete ȣ��");
		int result = 0;
		result = bDao.bookDelete(pMap);
		return result;
	}

}
