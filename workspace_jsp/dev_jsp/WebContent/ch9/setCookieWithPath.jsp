<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성시 패스 정보 테스트</title>
</head>
<body>
<%
	Cookie cook1 = 
		new Cookie("name1",URLEncoder.encode("이순신","utf-8"));
	//cook1.setPath("/ch9_1");
	Cookie cook2 = 
		new Cookie("name2",URLEncoder.encode("김유신","utf-8"));
	cook2.setPath("/ch9");
	cook2.setMaxAge(20);
	response.addCookie(cook1);
	response.addCookie(cook2);
%>
</body>
</html>