package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TestServlet extends HttpServlet {
	Logger logger = Logger.getLogger(TestServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		req.setAttribute("mem_id", "lion");
		String mem_id = (String)req.getAttribute("mem_id");
		logger.info("mem_id[doGet에서]:"+mem_id);//lion
		doService(req,res);
	}
	private void doService(HttpServletRequest req, HttpServletResponse res) {
		String mem_id = (String)req.getAttribute("mem_id");
		logger.info("mem_id[doService에서]:"+mem_id);//lion
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		doService(req,res);
	}
}
