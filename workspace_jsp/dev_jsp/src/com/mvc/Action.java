package com.mvc;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
}
