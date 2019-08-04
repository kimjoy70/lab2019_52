<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" import="com.vo.MemberVO,com.mvc1.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.vo.SNSMessageSet" %>
<%
	Map<String,Object> pMap = null;
	if(request.getAttribute("pMap")!=null){
		pMap = (Map<String,Object>)request.getAttribute("pMap");
	}
	// 기본 파라미터 정리
	// 컨트롤러 요청 action 코드 값
	String action = request.getParameter("action");

	// 다음 페이지 요청 카운트
	String cnt = request.getParameter("cnt");

	// 특정 회원 게시물 only
	String suid = request.getParameter("suid");
	
	// 홈 URL
	String home;
	
	// 메시지 페이지 카운트
	int mcnt;
	
	if((cnt != null) && (suid !=null)) {
		// 각 action 처리후 메인으로 되돌아가기 위한 기본 url
		home = "sns_control.jsp?action=getall&cnt="+cnt+"&suid="+suid;
		mcnt = Integer.parseInt(request.getParameter("cnt"));
	}
	else {
		// 게시글 작성시에는 현재 상태와 상관 없이 전체 게시물의 첫페이지로 이동 하기 위한 url
		home = "sns_control.jsp?action=getall";
		// 첫페이지 요청인 경우, 기본 게시물 5개씩
		mcnt = 5;
	}
	
	// 댓글이 달린 게시물 위치 정보 -> accordion 상태 유지 목적
	request.setAttribute("curmsg", request.getParameter("curmsg"));

	// 새로운 메시지 등록
/* 	if (action.equals("newmsg")) {
		if (msgdao.newMsg(msg))
			response.sendRedirect(home);
		else
			throw new Exception("메시지 등록 오류!!");
	} */
	// 댓글 등록
/* 	} else if (action.equals("newreply")) {
		if (msgdao.newReply(reply))
			pageContext.forward(home);
		else
			throw new Exception("댓글 등록 오류!!");
	} 
	// 메시지 삭제
	else if (action.equals("delmsg")) {
		if(msgdao.delMsg(msg.getMid())) 
			response.sendRedirect(home);			
		else
			throw new Exception("메시지 등록 오류!!");;
	} 
	// 댓글 삭제
	else if (action.equals("delreply")) {
		if(msgdao.delReply(reply.getRid())) {
			pageContext.forward(home);
		}
		else
			throw new Exception("메시지 등록 오류!!");;
	}  */
	// 전체 게시글 가져오기
	if (action.equals("getall")) {
		//ArrayList<SNSMessageSet> datas = msgdao.getAll(mcnt,suid);
		//ArrayList<String> nusers = new MemberDAO().getNewMembers();

		// 게시글 목록
		//request.setAttribute("datas", datas);

		// 신규 회원 목록
		//request.setAttribute("nusers", nusers);	

		// 특정 회원 only 인 경우 회원 uid 를 request  scope 에 저장
		//request.setAttribute("suid",suid);
		
		// 현재 페이지 카운트 정보 저장
		//request.setAttribute("cnt",mcnt);

		pageContext.forward("sns_main.jsp");
	}
	// 좋아요 추가
/* 	else if(action.equals("fav")) {
		msgdao.favorite(msg.getMid());
		pageContext.forward(home);
	} */
%>
