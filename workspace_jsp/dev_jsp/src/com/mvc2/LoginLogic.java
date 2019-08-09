package com.mvc2;

import org.apache.log4j.Logger;

public class LoginLogic {
	Logger logger = Logger.getLogger(LoginLogic.class);
	LoginDao loginDao = new LoginDao();
	public String login(String p_id, String p_pw) {
		String mem_name = "";
		mem_name = loginDao.login(p_id,p_pw);
		return mem_name;
	}
	
}
