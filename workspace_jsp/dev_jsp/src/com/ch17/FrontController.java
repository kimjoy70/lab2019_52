package com.ch17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		String requestURI = req.getRequestURI();//dev_jsp/ch17/login.do
		String contextPath = req.getContextPath();//dev_jsp
		//ch17/login.do
		String command = requestURI.substring(contextPath.length());
		if("/ch17/login.kosmo".equals(command)) {
			logger.info("로그인 처리 호출 성공");
		}
		else if("/ch17/member.kosmo".equals(command)) {
			logger.info("회원관리 처리 호출 성공");
		}
		else if("/ch17/board.kosmo".equals(command)) {
			logger.info("게시판관리 처리 호출 성공");
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
