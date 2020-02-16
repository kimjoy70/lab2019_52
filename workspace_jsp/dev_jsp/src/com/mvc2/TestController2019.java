package com.mvc2;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TestController2019 implements Controller2019 {
	Logger logger = Logger.getLogger(TestController2019.class);
	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView(req,res);
		mav.setViewName("board/boardList.jsp");
		List<String> list = new ArrayList<>();
		mav.addObject("list", list);
		return mav;
	}

}
