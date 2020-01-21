package com.mvc2019;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		//==> dev_jsp/onLineTest/test.mo?crud=select
		//==> /onLineTest/test.mo?crud=select
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();// => /dev_jsp or /
		//아래 코드에서 경로 앞에 슬래쉬가 빠짐
		//     onLineTest/test.mo?crud=select
		String command = requestURI.substring(contextPath.length()+1);
		Controller controller = null;
		String crud = req.getParameter("crud");
		try {
			controller = ControllerMapping.getController(command, crud);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(controller !=null) {
			//return "redirect:XXX.jsp";
			String pageMove[] = null;//return "forward:XXX.jsp";
			try {
				String ret = controller.execute(req,res);
				pageMove = ret.split(":");
				//pageMove[0]= redirect or forward
				//pageMove[1]= 실제 요청 이름
			} catch (Exception e) {
				// TODO: handle exception
			}

			if(pageMove!=null) {
				String path = pageMove[1];
				if("redirect".equals(pageMove[0])) {//sendRedirect일 때
					res.sendRedirect(path);
				}
				else {//forward
					if("forward".equals(pageMove[0])) {
						RequestDispatcher view = 
								req.getRequestDispatcher(path);
						view.forward(req, res);
					}else {
						res.sendRedirect("/error/pageMoveFail.jsp");
					}
				}
			}
		}	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException{
		doService(req,res);		
	}
}