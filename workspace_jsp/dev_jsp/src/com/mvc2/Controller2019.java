package com.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.ActionForward;

public interface Controller2019 {
	//return "redirect:XXX.jsp", "forward:XXX.do"
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
	//public ActionForward execute(HttpServletRequest req);
}
