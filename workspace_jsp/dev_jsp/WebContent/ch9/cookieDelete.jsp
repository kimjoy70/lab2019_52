<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
<%
	Cookie cook = new Cookie("notebook","");
    cook.setMaxAge(0);
    response.addCookie(cook);
%>
</body>
</html>