package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReactController {
	@GetMapping("/{name}.cs")
	public String tableDom(@PathVariable String name, Model model) {
		model.addAttribute("pageName", name);
		return "forward:tableDomPage.jsp";
	}
	@GetMapping("/{name}.html")
	public String page(@PathVariable String name, Model model) {
		model.addAttribute("pageName", name);
		return "page";
	}
}
