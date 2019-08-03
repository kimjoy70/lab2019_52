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
	//�̱������� ������ �����Ѵ�. - �Ѱ�(����) - Thread(��Ĺ�������� �������.)
	public void doService(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException
	{
		// ch3/memberMgr.do?command=sel&type=xml|json
		String command = req.getParameter("command");
		String type = req.getParameter("type");
		//final static String _INS = "insert";
		//�������� �б�
		//ȸ������� �� - ins
		if("ins".equals(command)) {//equals�޼ҵ�� Object����. ���ʿ� ����� ���°��� ����
			logger.info("ȸ�����");
		}
		//ȸ������ ������ �� - upd
		else if("upd".equals(command)) {
			logger.info("ȸ������");
		}
		//ȸ������ �˻��� �� - sel
		else if("sel".equals(command)) {
			logger.info("ȸ���˻�");
			List<Map<String,Object>> memberList =
					new ArrayList<Map<String,Object>>();
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "haha");
			rMap.put("mem_name", "�̼���");
			rMap.put("mem_address", "����� ��õ�� ���굿");
			memberList.add(rMap);
			rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "apple");
			rMap.put("mem_name", "���");
			rMap.put("mem_address", "����� ������ ������");
			memberList.add(rMap);
			rMap = new HashMap<String,Object>();
			rMap.put("mem_id", "test");
			rMap.put("mem_name", "�׽�Ʈ");
			rMap.put("mem_address", "����� �������� ��������");
			memberList.add(rMap);
			req.setAttribute("memberList", memberList);
			String page = "";//xmlMemberList.jsp | jsonMemberList.jsp
			//���������� ����ϴ� ����� �������̸� �ϳ��� �޼ҵ尡 �Ѱ� ����� ó��
			if("xml".equals(type)) {//xml�������� �޴� ���
				page = "xmlMemberList.jsp";
			}
			else if("json".equals(type)){//json�������� �޴� ���
				page = "jsonMemberList.jsp";
			}
			RequestDispatcher view = 
					req.getRequestDispatcher(page);
			view.forward(req, res);
		}
		//ȸ������ ������ �� - del
		else if("del".equals(command)){
			logger.info("ȸ������");
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
