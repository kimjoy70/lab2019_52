<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
%>    
<table border="1" borderColor="yellow" width="100%" height="100%">
	<tr><td align="center"><%=title %></td></tr>
</table>