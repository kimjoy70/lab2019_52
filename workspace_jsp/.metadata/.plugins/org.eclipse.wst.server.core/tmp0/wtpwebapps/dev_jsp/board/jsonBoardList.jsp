<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>   
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.google.gson.Gson" %>   
<%
	List<Map<String,Object>> boardList = 
	                       (List<Map<String,Object>>)request.getAttribute("boardList");
	if(boardList!=null && boardList.size()>0){
		Gson g = new Gson();
		String jsonFor = g.toJson(boardList);
		out.print(jsonFor);
	}
%>