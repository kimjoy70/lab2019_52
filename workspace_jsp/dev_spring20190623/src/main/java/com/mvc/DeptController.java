package com.mvc;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
@Controller
public class DeptController {
    @GetMapping("getDeptList")
    public String getDeptList(Model model) {
        return "redirect:index.jsp";
    }
 
}
