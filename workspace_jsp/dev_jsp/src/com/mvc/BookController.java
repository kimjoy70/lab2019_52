package com.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class BookController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(BookController.class);
	BookLogic bLogic = new BookLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String gubun = req.getParameter("gubun");
		ActionForward forward = new ActionForward();
		String path = null;//이동할 페이지 이름
		boolean isRedirect = false;//redirect 인지 forward인지
		//조회일때-select 책이름 from 도서 where 도서번호=값
		Map<String,Object> pMap = new HashMap<String,Object>();
		//사용자로 부터 입력한 값을 받아 올 때 request.getParameter()를 반복해야
		//하므로 공통 코드로 만들어서 사용하자.
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		List<Map<String,Object>> bookList = null;
		if("sel".equals(gubun)) {
			bookList = bLogic.getBookList(pMap);
			req.setAttribute("bookList", bookList);
			path ="getBookList.jsp";
			isRedirect = false;
		}
		//입력일때-insert into 도서 value(?,?.....)
		else if("ins".equals(gubun)) {
			int result = 0;
			result = bLogic.bookInsert(pMap);
			if(result==1) {
				path ="bookInsertSuccess.jsp";
			}else {
				path ="bookInsertFail.jsp";
			}
			isRedirect = true;
		}
		//수정일때-update 도서 set 컬럼명=값 where 도서번호=값
		else if("upd".equals(gubun)) {
			int result = 0;
			result = bLogic.bookUpdate(pMap);
			if(result==1) {
				path ="bookUpdateSuccess.jsp";
			}
			else {
				path ="bookUpdateFail.jsp";
			}
			isRedirect = true;
		}
		//삭제일때
		else if("del".equals(gubun)) {
			int result = 0;
			result = bLogic.bookDelete(pMap);
			if(result==1) {
				path ="bookDeleteSuccess.jsp";
			}
			else {
				path ="bookDeleteFail.jsp";
			}
			isRedirect = true;
		}
		forward.setPath(path);
		forward.setRedirect(isRedirect);//forward - 유지 - select
		logger.info(forward.getPath());
		//forward.setPath("./getBookList.jsp");
		return forward;
	}

}
