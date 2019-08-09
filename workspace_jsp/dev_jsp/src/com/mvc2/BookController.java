package com.mvc2;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class BookController implements Controller {
	Logger logger = Logger.getLogger(BookController.class);
	BookLogic bookLogic = null;
	String work = null;
	String crud = null;
	public BookController(String work, String crud) {
		logger.info("work:"+work+", crud:"+crud);
		this.work = work;
		this.crud = crud;
		bookLogic = new BookLogic();
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute호출 성공");
		String path = null;
		if("sel".equals(crud)) {
			logger.info("조회 요청 호출 성공");
			List<Map<String,Object>> bookList = null;
			bookList = bookLogic.getBookList();
			path = "forward:XXX.jsp";
		}
		else if("ins".equals(crud)) {
			
		}
		else if("upd".equals(crud)) {
			
		}
		else if("del".equals(crud)) {
			
		}
		return path;
	}

}
