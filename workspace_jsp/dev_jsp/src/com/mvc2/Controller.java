package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.ActionForward;

public interface Controller {
	//return "redirect:XXX.jsp", "forward:XXX.do"
	//ActionForward af = null;
	//String str = "";//피할 수 있다.
	//String str = null;//NullPointerException
	//int result = 0|-1|1
	public String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	//public ActionForward execute(HttpServletRequest req);
}
