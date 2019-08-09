<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
	String company = request.getParameter("company");
	String tel = (String)request.getAttribute("tel");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="blue" width="100%" height="100%">
	<tr><td><%=company %>&nbsp; 전화번호:<%=tel %></td></tr>
</table>
</body>
</html>