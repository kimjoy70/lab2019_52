<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>    
<%@ page import="java.util.HashMap" %>    
<%!
	int g_i = 0;
%>    
<%
    request.setCharacterEncoding("utf-8");
	String company = "한국소프트웨어 인재 개발원";
	int i = 10;//지역변수
	String tel = "02-2345-4567";
	List<Map<String,Object>> info = new ArrayList<Map<String,Object>>();
	Map<String,Object> pMap = new HashMap<String,Object>();
	pMap.put("admin","이순신");
	pMap.put("bno","111-111-12345");
	info.add(pMap);
	request.setAttribute("tel", tel);
	request.setAttribute("info", info);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="900px" height="480px">
<!-- top.jsp 시작 -->
	<tr>
		<td width="900px" height="50px">
		<jsp:include page="./top.jsp" flush="false">
			<jsp:param value="JSP프로그래밍" name="title"/>
		</jsp:include>
		</td>
	</tr>
<!-- top.jsp 끝 -->
	<tr>
		<td>
		<table width="900px" height="400px">
			<tr>
<!-- menu.jsp 시작 -->			
				<td width="250px" height="400px">
				<jsp:include page="menu.jsp" flush="false"/>
				</td>
<!-- menu.jsp 시작 끝-->		
<!-- main.jsp 시작 -->	
				<td width="650px" height="400px">
				<jsp:include page="main.jsp" flush="false"/>
				</td>
<!-- main.jsp 끝 -->	
			</tr>
		</table>
		</td>
	</tr>
<!-- bottom.jsp 시작 -->
		<td width="900px" height="30px">
		<jsp:include page="./bottom.jsp" flush="false">
			<jsp:param value="<%=company %>" name="company"/>
		</jsp:include>
		</td>
<!-- bottom.jsp 끝 -->	
</table>
</body>
</html>