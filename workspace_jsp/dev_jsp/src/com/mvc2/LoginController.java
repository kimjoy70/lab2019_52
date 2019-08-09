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
		logger.info("execute ȣ�� ����");//log4j.properties class, method, line
		String path = "";
		String mem_name = "";//db���� ��ȸ�� ����� ���-�̸�
		String p_id = req.getParameter("mem_id");
		String p_pw= req.getParameter("mem_pw");
		path = "redirect:/"+category+"/"+work+"/loginForm.jsp";
		mem_name=loginLogic.login(p_id, p_pw);
		Cookie cook = new Cookie("cmem_name",mem_name);
		cook.setPath("/");
		//redirect�̰ų� forward�̰ų� ������� ���� - ���
		cook.setMaxAge(2*60);//30�е��� ����
		res.addCookie(cook);
		return path;
	}

}
