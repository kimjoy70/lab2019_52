<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg =(String)request.getAttribute("msg");
	out.clear();
	out.print(msg);
	out.flush();
%>