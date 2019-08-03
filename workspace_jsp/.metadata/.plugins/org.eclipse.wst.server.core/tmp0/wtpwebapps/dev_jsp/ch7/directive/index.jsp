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
	int i2 = 10;//지역변수
	String tel = "02-2345-4567";
	List<Map<String,Object>> info2 = new ArrayList<Map<String,Object>>();
	Map<String,Object> pMap2 = new HashMap<String,Object>();
	pMap2.put("admin","이순신");
	pMap2.put("bno","111-111-12345");
	info2.add(pMap2);
	request.setAttribute("tel", tel);
	request.setAttribute("info", info2);
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
		<%@ include file="./top.jsp"%>
		</td>
	</tr>   
<!-- top.jsp 끝 -->
	<tr>
		<td>
		<table width="900px" height="400px">
			<tr>
<!-- menu.jsp 시작 -->			
				<td width="250px" height="400px">
				<%@ include file="menu.jsp"%>
				</td>
<!-- menu.jsp 시작 끝-->		
<!-- main.jsp 시작 -->	
				<td width="650px" height="400px">
				<%@ include file="main.jsp"%>
				</td>
<!-- main.jsp 끝 -->	
			</tr>
		</table>
		</td>
	</tr>
<!-- bottom.jsp 시작 -->
		<td width="900px" height="30px">
		<%@ include file="bottom.jsp"%>
		</td>
<!-- bottom.jsp 끝 -->	
</table>
</body>
</html>