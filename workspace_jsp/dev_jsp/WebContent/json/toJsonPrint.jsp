<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String jsonStr = (String)request.getAttribute("jsonStr");
	out.print(jsonStr);
%>