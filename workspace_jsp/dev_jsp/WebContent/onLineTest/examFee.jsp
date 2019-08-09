<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int fee =(Integer)request.getAttribute("fee");
	out.clear();
	out.print(fee);
	out.flush();
%>