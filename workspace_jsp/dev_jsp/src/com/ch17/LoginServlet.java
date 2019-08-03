package com.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
@WebServlet(urlPatterns="/ch17/login2.nhn")
public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doPost 호출 성공");
		String mem_id = req.getParameter("mem_id");
		logger.info("아이디:"+mem_id);
		String mem_pw = req.getParameter("mem_pw");
		logger.info("비번:"+mem_pw);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doGet 호출 성공");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String mem_id = req.getParameter("mem_id");
		logger.info("아이디:"+mem_id);
		String mem_pw = req.getParameter("mem_pw");
		logger.info("비번:"+mem_pw);
		out.print("<table border='1' width='300px'><tr><td>");
		out.print(mem_id);
		out.print("</td><td>");
		out.print(mem_pw);
		out.print("</td></tr></table>");
		res.sendRedirect("./loginActionResult.jsp?mem_name=김민성");
	}
}
