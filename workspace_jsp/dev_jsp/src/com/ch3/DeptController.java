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
			logger.info("�μ��˻�");
			List<Map<String,Object>> deptList = 
					new ArrayList<Map<String,Object>>();
			Map<String,Object> pMap = new HashMap<String,Object>();
			pMap.put("deptno", 10);
			pMap.put("dname", "�ѹ���");
			pMap.put("loc", "��õ");
			//����� ���� �ݵ�� �ڷᱸ���� �����ϱ�
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
		doService(req,res);//��Ĺ������ �������ִ� ��ü �̹Ƿ�....
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req,res);
	}
}
