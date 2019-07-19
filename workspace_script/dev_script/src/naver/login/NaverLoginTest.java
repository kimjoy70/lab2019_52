package naver.login;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/naver/login/naverLogin.do")
public class NaverLoginTest extends HttpServlet {
	Logger logger = Logger.getLogger(NaverLoginTest.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException
	{
		logger.info("doService 호출 성공");
		// 상태 토큰으로 사용할 랜덤 문자열 생성
		String state = generateState();
		logger.info("state : "+state);
		// 세션 또는 별도의 저장 공간에 상태 토큰을 저장
		//request.session().attribute("state", state);
		HttpSession session = req.getSession();
		session.setAttribute("state", state);
		//return state;	
	}
	public String generateState()
	{
	    SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	}


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException
	{
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException
	{
		doService(req,res);
	}
}
