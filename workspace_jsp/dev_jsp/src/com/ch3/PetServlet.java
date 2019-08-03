package com.ch3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HangulConversion;

public class PetServlet extends HttpServlet {
	Logger logger = Logger.getLogger(PetServlet.class);
/*
 * get����̴� post����̵� ������ ���忡���� ��� ó���� �ؾ� ��.
 * â���� �Ͽ��ϸ� get��� post��� ��� �׽�Ʈ�� ������.(405����)
 */
	public void doService(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("�̸� : "+HangulConversion.toUTF(req.getParameter("name")));
		logger.info("�ּ� : "+HangulConversion.toUTF(req.getParameter("address")));
		logger.info(req.getParameter("pet"));
		Enumeration<String> en = req.getParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			logger.info("name:"+name);//name, address, pet
			logger.info(name+": value"+HangulConversion.toUTF(req.getParameter(name)));
		}
		Map<String,String[]> pMap = req.getParameterMap();
		String names[] = (String[])pMap.get("pet");
		for(String str:names) {
			logger.info("str : "+str);
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
