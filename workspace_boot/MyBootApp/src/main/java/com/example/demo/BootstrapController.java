package com.example.demo;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BootstrapController {
	private static final Logger logger = LogManager.getLogger(BootstrapController.class);
	@RequestMapping("bootstrap4/helloBootstrap.do")
	public String helloBootstrap(Model model) {
		logger.info("helloBootstrap 호출 성공");
		model.addAttribute("pageName", "helloBootstrap");
		return "redirect:helloBootstrap.jsp";
	}
}
