<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionDelete.jsp</title>
</head>
<body>
<%
	//세션에 담긴 정보 삭제하기
	session.invalidate();
	//만약 그 중에 하나만 없애고 싶으면 어떡하지?????????????
	session.removeAttribute("smem_name");		
			
%>
</body>
</html>