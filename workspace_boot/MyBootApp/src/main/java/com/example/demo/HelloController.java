package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	public String index() {
		return "Hello Spring-Boot World!!";
	}
	@RequestMapping("/{num}")
	public String test(@PathVariable int num) {
		int res = 0;
		for(int i=1;i<=num;i++) {
			res+=i;
		}
		return "total: "+res;
	}
	
}
