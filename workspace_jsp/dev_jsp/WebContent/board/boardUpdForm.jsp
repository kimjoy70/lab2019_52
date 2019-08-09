<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>  
<%@ page import="java.util.HashMap" %>     
<%@ include file="../common/easyui_common.jsp" %>   
<%
	List<Map<String, Object>> boardList = 
		(List<Map<String, Object>>)request.getAttribute("boardList");
	int size = 0;
	Map<String, Object> rMap = new HashMap<String,Object>();
	if(boardList!=null){
		size = boardList.size();
		rMap = boardList.get(0);
	}
	//out.print("size:"+size);//1�̸� ���� 0�̸� ����
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ۼ���</title>
</head>
<body>
<form id="uf_board" method="post" enctype="multipart/form-data">
<input type="hidden" id="b_no" name="b_no" value="<%=rMap.get("B_NO") %>">
<input type="hidden" id="b_seq" name="b_seq" value="<%=rMap.get("B_SEQ") %>">
<input type="hidden" id="old_file" name="old_file" value="<%=rMap.get("B_FILE") %>">
<table align="center" width="650px" height="280px">
	<tr>
		<td width="120px">������</td>
		<td width="580px">
			<input id="b_title" value="<%=rMap.get("B_TITLE") %>" name="b_title" class="easyui-textbox">
		</td>
	</tr>
	<tr>
		<td width="120px">�ۼ���</td>
		<td width="580px">
			<input id="b_writer" value="<%=rMap.get("B_WRITER") %>" name="b_writer" class="easyui-textbox">
		</td>
	</tr>	
	<tr>
		<td width="120px">����</td>
		<td width="580px">
			<input id="b_content" multiline="true" value="<%=rMap.get("B_CONTENT") %>" name="b_content" class="easyui-textbox" style="width:100%;height:100px">
		</td>
	</tr>	
	<tr>
		<td width="120px">÷������</td>
		<td width="580px">
			<input id="b_file" name="b_file" class="easyui-filebox" style="width:100%">
		</td>
	</tr>	
	<tr>
		<td width="120px">���</td>
		<td width="580px">
			<input id="b_pw" name="b_pw" class="easyui-textbox" style="width:100px">
		</td>
	</tr>	
</table>
</form>
</body>
</html>