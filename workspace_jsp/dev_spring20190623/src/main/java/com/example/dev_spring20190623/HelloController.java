package com.example.dev_spring20190623;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
@Controller
public class HelloController {
	@RequestMapping("/{num}")
	public String test(@PathVariable int num) {
		int res = 0;
		for(int i=1;i<=num;i++) {
			res+=i;
		}
		return "total: "+res;
    }
    @GetMapping("/{name}.html")
    public String page(@PathVariable String name, Model model) {
        model.addAttribute("pageName", name);
        return "totalPrint";
    }
}