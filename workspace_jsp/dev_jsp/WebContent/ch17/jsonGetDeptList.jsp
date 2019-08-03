<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.DeptVO" %>    
<%@ page import="com.google.gson.Gson" %>    
<%
//테스트 시나리오 작성하기
/*
데이터를 생성한 클래스가 누구지? - DeptServlet
getDeptList.nhn요청 - DeptServlet doGet호출 - 데이터생성(List) - request
- 이동할 페이지 이름(getDeptList.jsp->jsonGetDeptList.jsp) forward - jsonGetDeptList.jsp
*/
//스크립틀릿
	List<DeptVO> deptList = 
		(List<DeptVO>)request.getAttribute("deptList");
	Gson g = new Gson();
	String jsonDept = g.toJson(deptList);
	out.print(jsonDept);
%>