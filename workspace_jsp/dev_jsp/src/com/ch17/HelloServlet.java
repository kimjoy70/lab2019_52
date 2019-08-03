package com.ch17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
/*
 * 서블릿의 경우 자바에서 처럼 콘솔창에 값을 출력해 볼 수가 없어요.
 * 그래서 Apache그룹에서 제공하는 오픈소스 중에서 log4j.jar파일을 활용해서
 * 로그를 출력할 수 있는 환경을 설정합니다.
 * 출력에 필요한 정보에 대한 설정은 앞에서 배포한 log4j.properties문서에 
 * 미리 작업을 해서 배포했어요.
 * 이 파일은 반드시 src폴더에 배포합시다.
 * 왜냐하면 서버를 기동할 때 마다 톰캣 서버에서 자바 파일들을 매번 컴파일 하여 새롭게
 * WEB-INF/classes폴더에 배포하게 되는데 이때 그 폴더에 있는 파일들이 모두 삭제된 후
 * 새로 부어지기 때문임.
 * 그리고 인스턴스화 할때 로그를 출력할 클래스이름을 파라미터로 넘겨 줌.
 * 그리고 마지막으로 web.xml문서에 이 로그관련 설정을 추가함.
 * 톰캣 서버가 맨 처음 기동할 때 web.xml문서를 스캔하므로 이 때 log4j.properties
 * 파일을 읽음. 
 * 
 * Map<key,value>
 * Properties prop = new Properties("이름","값");
 * request.setAttribute("이름","값");
 * session.setAttribute("이름","값");
 * appplication.setAttribute("이름","값");
 * 
 */
@WebServlet(urlPatterns="/ch17/hello2.do")
public class HelloServlet extends HttpServlet {
	Logger logger = Logger.getLogger(HelloServlet.class);
	//서블릿에 사용자 정의 메소드에 파라미터로 선언한 req,res는 객체 주입을 받을 수 없다.
	//@Override
	public void methodA(HttpServletRequest req, HttpServletResponse res) {
		
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doGet 호출 성공");
		TestDao tdao = new TestDao();
		String time = null;
		time = tdao.getCurrentTime(null);
		logger.info("time:"+time);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doPost 호출 성공");
		
	}
}





