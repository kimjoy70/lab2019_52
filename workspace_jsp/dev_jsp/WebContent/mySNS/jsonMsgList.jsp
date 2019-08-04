<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%@ page import="com.google.gson.Gson,com.vo.SNSMessageVO" %>    
<%
	List<SNSMessageVO> msgAllList = null;
    msgAllList = 
			(List<SNSMessageVO>)request.getAttribute("msgAllList");
	String imsi = null;
	if(msgAllList.size()>0){
		Gson g = new Gson();
		imsi = g.toJson(msgAllList);
	}else{
		imsi="";
	}
	out.print(imsi);
%>