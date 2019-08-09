package com.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/*
 * 모든 요청은 FrontController를 경유하도록 하자.
 * 요청에 대해 어떤 클래스가 담당인지 결정
 * get방식이든 post방식이든 요청에 대한 접수는 하나로 통일
 */
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		logger.info("doService호출 성공");
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
