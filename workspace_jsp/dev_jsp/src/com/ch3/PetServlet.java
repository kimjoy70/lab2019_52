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
 * get방식이던 post방식이든 개발자 입장에서는 모두 처리를 해야 함.
 * 창구를 일원하면 get방식 post방식 모두 테스트가 가능함.(405에러)
 */
	public void doService(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		logger.info("이름 : "+HangulConversion.toUTF(req.getParameter("name")));
		logger.info("주소 : "+HangulConversion.toUTF(req.getParameter("address")));
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
		doService(req,res);//톰캣서버가 주입해주는 객체 이므로....
	}
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException
	{
		doService(req,res);
	}	
}
