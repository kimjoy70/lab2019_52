package com.ch3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MemberController extends HttpServlet {
	Logger logger = Logger.getLogger(MemberController.class);
	//싱글톤으로 서블릿을 관리한다. - 한개(공유) - Thread(톰캣서버관리 대신해줌.)
	public void doService(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		// ch3/memberMgr.do?command=sel&type=xml|json
		String command = req.getParameter("command");
		String type = req.getParameter("type");
		//final static String _INS = "insert";
		//업무별로 분기
		//회원등록일 때 - ins
		if("ins".equals(command)) {//equals메소드는 Object지원. 앞쪽에 상수가 오는것이 안전
			logger.info("회원등록");
		}
		//회원정보 수정일 때 - upd
		else if("upd".equals(command)) {
			logger.info("회원수정");
		}
		//회원정보 검색할 때 - sel
		else if("sel".equals(command)) {
			logger.info("회원검색");
			List<Map<String,Object>> memberList =
					new ArrayList<Map<String,Object>>();
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "haha");
			rMap.put("mem_name", "이순신");
			rMap.put("mem_address", "서울시 금천구 가산동");
			memberList.add(rMap);
			rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "apple");
			rMap.put("mem_name", "사과");
			rMap.put("mem_address", "서울시 마포구 공덕동");
			memberList.add(rMap);
			rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "test");
			rMap.put("mem_name", "테스트");
			rMap.put("mem_address", "서울시 영등포구 영등포동");
			memberList.add(rMap);
			req.setAttribute("memberList", memberList);
			String page = "";//xmlMemberList.jsp | jsonMemberList.jsp
			//유지보수를 고려하는 경우라면 가급적이면 하나의 메소드가 한개 기능을 처리
			if("xml".equals(type)) {//xml포맷으로 받는 경우
				page = "xmlMemberList.jsp";
			}
			else if("json".equals(type)){//json포맷으로 받는 경우
				page = "jsonMemberList.jsp";
			}
			RequestDispatcher view = 
					req.getRequestDispatcher(page);
			view.forward(req, res);
		}
		//회원정보 삭제할 때 - del
		else if("del".equals(command)){
			logger.info("회원삭제");
		}
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req,res);//톰캣서버가 주입해주는 객체 이므로....
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req,res);
	}
}
