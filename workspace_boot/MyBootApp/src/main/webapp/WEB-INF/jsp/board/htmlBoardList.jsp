<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
	//List<Map<String, Object>> boardList = (List<Map<String, Object>>)request.getParameter("boardList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 - html활용</title>
</head>
<body>
	게시판 목록 페이지입니다.
	<div id="d_list"></div>
	<script src="/js/react/${pageName}.bundle.js"></script>
</body>
</html>