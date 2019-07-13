package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeptController {
	private static final Logger logger = LogManager.getLogger(DeptController.class);
	@RequestMapping("getDeptList")
	public String getDeptList() {
		logger.info("getDeptList 호출 성공");
		return "dept/getDeptDetail";
	}
	@RequestMapping("getDeptDetail")
	public String getDeptDetail() {
		logger.info("getDeptDetail 호출 성공");
		return "dept/getDeptDetail";
	}
	@GetMapping("/{name}")
	public String deptInsert(@PathVariable String name) {
		logger.info("deptInsert 호출 성공");
		return "deptInsert";
	}

}
