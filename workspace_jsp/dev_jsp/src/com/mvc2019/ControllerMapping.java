package com.mvc2019;

public class ControllerMapping {
	static String crud = "";
	/***************************************************************
	 * 
	 * @param command /onLineTest/getSubjectList.mo?work=onLineTest
	 * @param crud
	 * @return
	 **************************************************************/
	public static Controller getController(String command, String crud) {
		ControllerMapping.crud = crud;
		Controller controller = null;
		String commands[] = command.split("/");
		String work = commands[0];
		String requestName = commands[1];
		if("onLineTest".equals(work)) {
			controller = new Test2Controller(requestName,ControllerMapping.crud);
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName,ControllerMapping.crud);
		}
		return controller;
	}
}





