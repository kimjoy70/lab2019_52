package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MarkdownController {
	private static final Logger logger = LogManager.getLogger(MarkdownController.class);
	@RequestMapping("react_basic/{name}.do")
	public String markdown(@PathVariable String name, Model model) {
		logger.info("markdown 호출 성공");
		model.addAttribute("pageName", name);
		return "forward:markdown.jsp";
	}
}
