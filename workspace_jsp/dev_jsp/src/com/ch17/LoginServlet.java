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
		logger.info("doPost ȣ�� ����");
		String mem_id = req.getParameter("mem_id");
		logger.info("���̵�:"+mem_id);
		String mem_pw = req.getParameter("mem_pw");
		logger.info("���:"+mem_pw);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		logger.info("doGet ȣ�� ����");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String mem_id = req.getParameter("mem_id");
		logger.info("���̵�:"+mem_id);
		String mem_pw = req.getParameter("mem_pw");
		logger.info("���:"+mem_pw);
		out.print("<table border='1' width='300px'><tr><td>");
		out.print(mem_id);
		out.print("</td><td>");
		out.print(mem_pw);
		out.print("</td></tr></table>");
		res.sendRedirect("./loginActionResult.jsp?mem_name=��μ�");
	}
}
