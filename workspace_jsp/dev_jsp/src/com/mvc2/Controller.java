package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.ActionForward;

public interface Controller {
	//return "redirect:XXX.jsp", "forward:XXX.do"
	public String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	//public ActionForward execute(HttpServletRequest req);
}
