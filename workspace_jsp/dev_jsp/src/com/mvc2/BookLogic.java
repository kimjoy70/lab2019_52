package com.mvc2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BookLogic {
	Logger logger = Logger.getLogger(BookLogic.class);
	BookDao bookDao = null;
	List<Map<String,Object>> bookList = null;
	BookLogic(){
		this.bookDao = bookDao;
	}
	public List<Map<String,Object>> getBookList() {
		bookList = bookDao.getBookList();
		return bookList;
	}

}
