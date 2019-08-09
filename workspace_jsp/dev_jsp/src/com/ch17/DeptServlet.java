package com.ch17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vo.DeptVO;

public class DeptServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = new DeptVO();
		dvo.setDeptno(10);
		dvo.setDname("영업부");
		dvo.setLoc("서울");
		deptList.add(dvo);
		dvo = new DeptVO();
		dvo.setDeptno(20);
		dvo.setDname("총무부");
		dvo.setLoc("서울");
		deptList.add(dvo);	
		dvo = new DeptVO();
		dvo.setDeptno(30);
		dvo.setDname("개발부");
		dvo.setLoc("제주도");
		deptList.add(dvo);			
		//담기
		req.setAttribute("deptList", deptList);
		//꺼내기
		//req.getAttribute("deptList");
		//이동처리
		//테스트 시나리오
		//이전 - getDeptList.jsp요청 - 이 페이지가 로딩 - DeptServlet경유하지 않음
		//이후 - jsp를 먼저 요청하지 말고 서블릿을 먼저 요청하자. - 담는 코드실행 -
		//    - URL은 서블릿 호출 URL그대로 유지됨.
		//주의사항 - web.xml은 서버가 기동될 때 딱 한번 스캔한 정보가 유지됨.
		//         서버를 재기동 해야 스캔한 정보 반영됨.
		//        jsp를 수정했을 땐 즉시 반영 됨
		RequestDispatcher view = req.getRequestDispatcher("jsonGetDeptList.jsp");
		view.forward(req, res);
	}
}





