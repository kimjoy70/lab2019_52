package com.di;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ListController extends MultiActionController {
	Logger logger = Logger.getLogger(ListController.class);
	public ModelAndView getInsaList() {
		logger.info("getInsaList 호출 성공");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("di/insaList");
		return mav;
	}
}
