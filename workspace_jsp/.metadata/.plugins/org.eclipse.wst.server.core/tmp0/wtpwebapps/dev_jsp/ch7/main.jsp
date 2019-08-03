<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>    
<%@ page import="java.util.HashMap" %>      
<%
	int i= 100;
	List<Map<String,Object>> info = 
			(List<Map<String,Object>>)request.getAttribute("info");
	for(Map pMap:info){
		out.print(pMap.get("admin")+", "+pMap.get("bno"));
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="brown" width="100%" height="100%">
	<tr><td><%=i %></td></tr>
</table>
</body>
</html>