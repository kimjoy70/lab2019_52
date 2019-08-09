package com.mvc2019;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception;
}
