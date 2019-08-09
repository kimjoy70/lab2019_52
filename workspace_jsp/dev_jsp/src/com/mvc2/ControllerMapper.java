package com.mvc2;

import org.apache.log4j.Logger;

public class ControllerMapper {
	static Logger logger = Logger.getLogger(ControllerMapper.class);
	static String crud = "";
	//command => /ioc/getBookList.do?command=sel
	//command => /ch9/member/login.mvc
	public static Controller getController(String command, String crud) {
		ControllerMapper.crud = crud;
		logger.info("command:"+command +", crud:"+ControllerMapper.crud);
		Controller  controller = null;
		String commands[] = command.split("/");
	
		for(String str:commands) 
		{
			logger.info("commands:"+str); //board와 boardList.mvc
		}
		if(commands.length==2) {
			String work = commands[0];//board 폴더명
			String requestName = commands[1];// - boardList.mvc?crud=sel
			if("board".equals(work)) {
				controller = new BoardController(requestName,ControllerMapper.crud);
			}
		}
		/*
		else if(commands.length==3) {
			String category = commands[0];//ch9
			String work = commands[1];//member
			crud = commands[2];//login.mvc
			if("book".equals(category)) {
				controller = new BookController(category,crud);
			}
			else if("member".equals(work)) {
				controller = new LoginController(category,work,crud);
			}
			else if("order".equals(category)) {
				//controller = new OrderController(work,crud);
			}
		}
		*/
		return controller;
	}
}
