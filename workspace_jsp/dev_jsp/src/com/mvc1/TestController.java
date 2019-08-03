package com.mvc1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
import com.vo.SwDesignVO;
import com.vo.TakeExaminationVO;

public class TestController extends HttpServlet implements Action {
	Logger logger = Logger.getLogger(TestController.class);
	TestLogic tLogic = new TestLogic();
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		String viewName = null;
		boolean isRedirect = false;
		String crud = (String)req.getAttribute("crud");// member/memberInsert
		//logger.info("execute호출 성공");
		//과목별 응시료 가져오기
		if("onLineTest/examFee".equals(crud)) {
			logger.info("응시료 호출 성공");
			int fee = 0;
			String p_subcd = req.getParameter("sub_cd");
			fee = tLogic.examFee(p_subcd);
			req.setAttribute("fee", fee);
			viewName = "examFee.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		//답안지 등록
		else if("onLineTest/examPaperAdd".equals(crud)) {
			logger.info("답안지 제출 호출 성공");
			String msg = null;
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			msg = tLogic.examPaperAdd(pMap);
			req.setAttribute("msg", msg);
			viewName = "paperAdd.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		//접수 유무체크
		else if("onLineTest/isOk".equals(crud)) {
			logger.info("응시 여부 확인 호출 성공");
			String msg = null;
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			msg = tLogic.isOk(pMap);
			req.setAttribute("msg", msg);
			viewName = "isOkMsg.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		//소프트웨어 설계 시험 문제 가져오기
		else if("onLineTest/swDesignExam".equals(crud)) {
			logger.info("소프트웨어 설계 문제 조회 호출 성공");
			List<Map<String,Object>> designList = null;
			designList = tLogic.swDesignExam();
			List list = null;
			if(designList !=null) {
				list = (List)designList.get(0).get("key");
			}
			Iterator<Map<String,Object>> iter = list.iterator();
			while(iter.hasNext()) {
				SwDesignVO swdVO = (SwDesignVO)iter.next();
			}
			req.setAttribute("designList", list);
			viewName = "jsonSwDesign.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		else if("onLineTest/subjectList".equals(crud)) {
			logger.info("시험과목 조회 호출 성공");
			List<Map<String,Object>> subList = null;
			subList = tLogic.subjectList();
			req.setAttribute("subList", subList);
			viewName = "jsonSubjectList.jsp";
			isRedirect = false;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		else if("onLineTest/examReceipt".equals(crud)) {
			logger.info("시험접수 호출 성공");
			int result = -1;//시험접수 성공 여부
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			logger.info("과목코드:"+pMap.get("sub_cd"));
			result = tLogic.examReceipt(pMap);
			viewName = "index.jsp";
			isRedirect = true;
			forward.setRedirect(isRedirect);
			forward.setViewName(viewName);			
		}
		
		return forward;
	}

}
