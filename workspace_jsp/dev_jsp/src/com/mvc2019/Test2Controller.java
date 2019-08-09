package com.mvc2019;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Test2Controller implements Controller {
	Logger  logger = Logger.getLogger(Test2Controller.class);
	String requestName = null;
	String crud = null;
	String path = null;
	public Test2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if(crud==null) {
			path="redirect:index.jsp";
		}
		return path;
	}

}
