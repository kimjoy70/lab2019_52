<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.DeptVO" %>    
<jsp:useBean id="dvo2" scope="request" class="com.vo.DeptVO"/>
<%
//아래 인스턴스화에는 scope가 담겨 있지 않다.
	DeptVO dvo = new DeptVO();
	dvo.setDeptno(10);
	//insert here - 별도로 한글처리를 하지 않아도 된다.
	dvo.setDname("총무부");
	dvo.setLoc("부산");
	//페이지 이동으로 url이 변경되었을 경우의 상황을 확인해 보세요.
	//scope만 설정했다고 해서 값이 자동으로 담기는 게 아님.
	//반드시 따로 담아주는 코드가 필요함.
	request.setAttribute("dvo2", dvo);
//페이지 이동 후 그 값을 유지하는지에 대한 실습이므로 페이지 이동을 한다.	
	//response.sendRedirect("./p53_1Move.jsp");
	RequestDispatcher view = 
			request.getRequestDispatcher("./p53_1Move.jsp");
	view.forward(request,response);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>