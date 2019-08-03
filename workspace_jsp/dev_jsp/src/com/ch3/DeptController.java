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

public class DeptController extends HttpServlet {
	Logger logger = Logger.getLogger(DeptController.class);
	public void doService(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		// ch3/deptMgr.do?command=sel
		String command = req.getParameter("command");
		if("sel".equals(command)) {
			logger.info("부서검색");
			List<Map<String,Object>> deptList = 
					new ArrayList<Map<String,Object>>();
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("deptno", 10);
			pMap.put("dname", "총무부");
			pMap.put("loc", "인천");
			//덮어쓰기 전에 반드시 자료구조에 저장하기
			deptList.add(pMap);	
			logger.info("size():"+deptList.size());
			req.setAttribute("deptList", deptList);
			RequestDispatcher view = 
					req.getRequestDispatcher("getDeptList.jsp");
			view.forward(req, res);
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
