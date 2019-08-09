<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>    
<%@ page import="java.util.Map, java.util.HashMap" %>    
<%@ page import="java.util.List, java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 생성하기</title>
</head>
<body>
<%
	session.setAttribute("smem_name", "이순신");
	Date time = new Date();
	SimpleDateFormat format =
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	session.setAttribute("sreg_date", format.format(time));
	session.setAttribute("smem_age", 30);
	Map<String,Object> target = new HashMap<String,Object>();
	target.put("url","/ch10/getEmpList.jsp");
	target.put("method","getEmpList");
	session.setAttribute("target", target);
	List<String> urlList = new ArrayList<String>();
	urlList.add("/ch10/getEmpList.jsp");
	urlList.add("getEmpList");
	session.setAttribute("urlList", urlList);
	//Cookie cook1 = new Cookie("target",target);
	//Cookie cook2 = new Cookie("target","target");
	
%>
</body>
</html>