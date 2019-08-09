<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 읽어오기</title>
</head>
<body>
<%
	String smem_name = (String)session.getAttribute("smem_name");
	String sreg_date = (String)session.getAttribute("sreg_date");
	Integer smem_age = (Integer)session.getAttribute("smem_age");
	out.print(smem_name);
	out.print("<br>");
	out.print(sreg_date);
	out.print("<br>");
	out.print(smem_age);
	out.print("<br>");
	Map<String,Object> target = 
			(Map<String,Object>)session.getAttribute("target");
	if(target!=null){
		out.print(target.toString());
	}
	out.print("<br>");
	List<String> urlList = 
			(List<String>)session.getAttribute("urlList");
	
	if(urlList!=null){
		out.print(urlList.toString());
	}
%>
</body>
</html>