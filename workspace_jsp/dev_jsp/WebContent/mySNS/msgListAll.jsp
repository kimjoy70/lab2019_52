<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%@ page import="com.google.gson.Gson,com.vo.SNSMessageVO" %> 
<%@ page import="com.vo.SNSMessageSet, com.vo.SNSReplyVO" %> 
<%-- <jsp:include page="/common/JEasyUICommon.jsp" />  --%>  
<%
	List<SNSMessageSet> msgAllList = null;
    msgAllList = 
			(List<SNSMessageSet>)request.getAttribute("msgAllList");
    int size = 0;
    if(msgAllList!=null){
    	size = msgAllList.size();
    }
    
%>    
<div class="easyui-accordion" style="width:500px;height:300px;">
<%
	for(int i=0;i<size;i++){
		SNSMessageSet smSet = msgAllList.get(i);
		SNSMessageVO smVO = smSet.getMsgVO();
		List<SNSReplyVO> reList = smSet.getReList();
		int rsize = 0;
		if(reList!=null){
			rsize = reList.size();
		}
%>
	<div style="overflow:auto;padding:10px;border:solid 1px #CCCCCC">
	<table width="100%">
		<thead>
			<tr>
			<td bgColor='#CCCCCC'><%=smSet.getMsgVO().getMsg() %>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">삭제</a>
			</td>
			</tr>
		</thead>
<%
	if(rsize==0){
%>	
<!-- 		<tr>
		<td>댓글 없음.</td>
		</tr> -->
<%
	}else{
		for(int x=0;x<rsize;x++){	
			SNSReplyVO srVO = reList.get(x);
%>		
		<tr>
		<td><%=srVO.getMsg() %></td>
		</tr>
<%
		}
	}
%>		
	</table>
	</div>
<%
	}
%>	
</div>