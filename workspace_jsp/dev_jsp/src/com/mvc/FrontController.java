package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*
 * ��� ��û�� FrontController�� �����ϵ��� ����.
 * ��û�� ���� � Ŭ������ ������� ����
 * get����̵� post����̵� ��û�� ���� ������ �ϳ��� ����
 */
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doServiceȣ�� ����");
		ActionForward forward = null;
		BookController bookCtrl = new BookController();
		forward = bookCtrl.execute(req, res);
		if(forward!=null) {
			if(forward.isRedirect()) {
				res.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher view =
						req.getRequestDispatcher(forward.getPath());
				view.forward(req, res);
			}
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);
	}
}
