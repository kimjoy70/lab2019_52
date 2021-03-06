package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDeptController {
	private static final Logger logger = LogManager.getLogger(RestDeptController.class);
	@RequestMapping("dept/resDeptList")
	public String restDeptList() {
		logger.info("resDeptList호출 성공");
		return "dept/resDeptList";
	}
}
