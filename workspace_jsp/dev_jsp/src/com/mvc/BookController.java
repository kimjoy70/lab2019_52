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
		String path = null;//�̵��� ������ �̸�
		boolean isRedirect = false;//redirect ���� forward����
		//��ȸ�϶�-select å�̸� from ���� where ������ȣ=��
		Map<String,Object> pMap = new HashMap<String,Object>();
		//����ڷ� ���� �Է��� ���� �޾� �� �� request.getParameter()�� �ݺ��ؾ�
		//�ϹǷ� ���� �ڵ�� ���� �������.
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		List<Map<String,Object>> bookList = null;
		if("sel".equals(gubun)) {
			bookList = bLogic.getBookList(pMap);
			req.setAttribute("bookList", bookList);
			path ="getBookList.jsp";
			isRedirect = false;
		}
		//�Է��϶�-insert into ���� value(?,?.....)
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
		//�����϶�-update ���� set �÷���=�� where ������ȣ=��
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
		//�����϶�
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
		forward.setRedirect(isRedirect);//forward - ���� - select
		logger.info(forward.getPath());
		//forward.setPath("./getBookList.jsp");
		return forward;
	}

}
