package com.mvc2019;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mvc1.MemberLogic;
import com.vo.MemberVO;

public class Member2Controller implements Controller {
	Logger  logger = Logger.getLogger(Member2Controller.class);
	String requestName = null;
	String crud = null;
	String path = null;
	MemberLogic memLogic = new MemberLogic();
	public Member2Controller(String requestName, String crud) {
		this.requestName = requestName;
		this.crud = crud;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("execute 호출 성공");
		if("login".equals(crud)) {
			MemberVO mVO = new MemberVO();
			mVO.setMem_id(req.getParameter("mem_id"));
			mVO.setMem_pw(req.getParameter("mem_pw"));
//			MemberVO rmVO = memLogic.login(mVO);
			//프로시저 사용할 때
			Map<String,Object> pMap = memLogic.proc_login(mVO);
			logger.info("이름 : "+pMap.get("mem_name"));
			logger.info("아이디(r_status) : "+pMap.get("r_status"));
			HttpSession session=req.getSession();
			session.setAttribute("pMap", pMap);			
			path="redirect:/onLineTest/loginAccount.jsp";
		}
		return path;
	}

}
