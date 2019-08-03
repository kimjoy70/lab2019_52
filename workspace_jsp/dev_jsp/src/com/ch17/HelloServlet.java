package com.ch17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
/*
 * ������ ��� �ڹٿ��� ó�� �ܼ�â�� ���� ����� �� ���� �����.
 * �׷��� Apache�׷쿡�� �����ϴ� ���¼ҽ� �߿��� log4j.jar������ Ȱ���ؼ�
 * �α׸� ����� �� �ִ� ȯ���� �����մϴ�.
 * ��¿� �ʿ��� ������ ���� ������ �տ��� ������ log4j.properties������ 
 * �̸� �۾��� �ؼ� �����߾��.
 * �� ������ �ݵ�� src������ �����սô�.
 * �ֳ��ϸ� ������ �⵿�� �� ���� ��Ĺ �������� �ڹ� ���ϵ��� �Ź� ������ �Ͽ� ���Ӱ�
 * WEB-INF/classes������ �����ϰ� �Ǵµ� �̶� �� ������ �ִ� ���ϵ��� ��� ������ ��
 * ���� �ξ����� ������.
 * �׸��� �ν��Ͻ�ȭ �Ҷ� �α׸� ����� Ŭ�����̸��� �Ķ���ͷ� �Ѱ� ��.
 * �׸��� ���������� web.xml������ �� �αװ��� ������ �߰���.
 * ��Ĺ ������ �� ó�� �⵿�� �� web.xml������ ��ĵ�ϹǷ� �� �� log4j.properties
 * ������ ����. 
 * 
 * Map<key,value>
 * Properties prop = new Properties("�̸�","��");
 * request.setAttribute("�̸�","��");
 * session.setAttribute("�̸�","��");
 * appplication.setAttribute("�̸�","��");
 * 
 */
@WebServlet(urlPatterns="/ch17/hello2.do")
public class HelloServlet extends HttpServlet {
	Logger logger = Logger.getLogger(HelloServlet.class);
	//������ ����� ���� �޼ҵ忡 �Ķ���ͷ� ������ req,res�� ��ü ������ ���� �� ����.
	//@Override
	public void methodA(HttpServletRequest req, HttpServletResponse res) {
		
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doGet ȣ�� ����");
		TestDao tdao = new TestDao();
		String time = null;
		time = tdao.getCurrentTime(null);
		logger.info("time:"+time);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doPost ȣ�� ����");
		
	}
}





