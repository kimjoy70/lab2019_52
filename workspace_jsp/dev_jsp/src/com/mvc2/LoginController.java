package com.mvc2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginController implements Controller {
	Logger logger = Logger.getLogger(LoginController.class);
	LoginLogic loginLogic = new LoginLogic();
	String category = null;
	String work = null;
	String crud = null;
	public LoginController(String string, String crud) {
		this.work = work;
		this.crud = crud;
	}
	public LoginController(String category, String work, String crud) {
		this.category = category;
		this.work = work;
		this.crud = crud;
	}
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");//log4j.properties class, method, line
		String path = "";
		String mem_name = "";//db에서 조회된 결과를 담기-이름
		String p_id = req.getParameter("mem_id");
		String p_pw= req.getParameter("mem_pw");
		path = "redirect:/"+category+"/"+work+"/loginForm.jsp";
		mem_name=loginLogic.login(p_id, p_pw);
		Cookie cook = new Cookie("cmem_name",mem_name);
		cook.setPath("/");
		//redirect이거나 forward이거나 상관없이 유지 - 기억
		cook.setMaxAge(2*60);//30분동안 유지
		res.addCookie(cook);
		return path;
	}

}
