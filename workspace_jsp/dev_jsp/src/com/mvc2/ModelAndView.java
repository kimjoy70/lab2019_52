package com.mvc2;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	HttpServletRequest req = null;
	HttpServletResponse res = null;
	public ModelAndView() {
	}
	public ModelAndView(HttpServletRequest req, HttpServletResponse res) {
		this.req = req;
		this.res = res;
	}
	public void setViewName(String viewName) {
		try {
			RequestDispatcher view =
					req.getRequestDispatcher(viewName);
			view.forward(req, res); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void addObject(String name,Object obj) {
		req.setAttribute(name, obj);
	}
}