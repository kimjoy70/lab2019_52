package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RouterController {
	private static final Logger logger = LogManager.getLogger(RouterController.class);
	@RequestMapping("router/reactNJSP.do")
	public String reactNJSP(Model model) {
		logger.info("reactNJSP 호출 성공");
		model.addAttribute("pageName", "reactNJSP");
		return "forward:reactNJSPTest.jsp";
	}
	@RequestMapping("router/{name}.do")
	public String routerTest(@PathVariable String name, Model model) {
		logger.info("routerTest 호출 성공");
		model.addAttribute("pageName", name);
		return "forward:routerTest.jsp";
	}
}