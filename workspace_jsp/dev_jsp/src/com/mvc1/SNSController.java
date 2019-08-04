package com.mvc1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vo.SNSMessageSet;
import com.vo.SNSMessageVO;

public class SNSController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(SNSController.class);
	SNSLogic sLogic = new SNSLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String)req.getAttribute("crud");// member/memberInsert
		if("mySNS/getAll".equals(crud)) {
			logger.info("메세지 목록 호출 성공");
			List<SNSMessageSet> msgAllList = null;
			String mem_id = req.getParameter("mem_id");
			msgAllList= sLogic.getAll(mem_id);
			
			req.setAttribute("msgAllList", msgAllList);
			viewName = "msgListAll.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		return forward;
	}

}
