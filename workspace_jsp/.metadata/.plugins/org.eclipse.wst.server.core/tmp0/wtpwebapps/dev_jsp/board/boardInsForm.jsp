<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%
//read.jsp?b_no=15&b_group=2&b_pos=0&b_step=0
//�۹�ȣ�� 0�̸� ���� �ƴϸ� ����̹Ƿ� �ݵ�� ������ �Ѱ���.
	String pb_no = "0";
//�θ���� �а� ����� ����� �� ���� �������� �� �� �ڿ� �ִ����� updateó���ؾ� �ϹǷ�
//b_group�� �ݵ�� �ѱ� ��.
	String pb_group = "0";
//b_pos�� ��� ������ �� ������ 0������ ����� ��� ������ �ִ� ���� 1�� ���Ѱ����� ����
//�ؾ� �ϹǷ� �ݵ�� �ѱ� ��.
	String pb_pos = "0";
//�� ���� ����鶧 �� �ڿ� �ִ� ������ 1�� �������� �ڷ� �о�� �ϹǷ� �ݵ�� �ѱ��.
	String pb_step = "0";
	if(request.getParameter("b_no")!=null){
		pb_no = request.getParameter("b_no");
	}
	if(request.getParameter("b_group")!=null){
		pb_group = request.getParameter("b_group");
	}
	if(request.getParameter("b_pos")!=null){
		pb_pos = request.getParameter("b_pos");
	}
	if(request.getParameter("b_step")!=null){
		pb_step = request.getParameter("b_step");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾���</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../demo/demo.css">
<script type="text/javascript" src="../js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/datagrid-detailview.js"></script> 
</head>
<body>
<form id="f_board" method="post" enctype="multipart/form-data">
<input type="hidden" id="b_no" name="b_no" value="<%=pb_no %>">
<input type="hidden" id="b_group" name="b_group" value="<%=pb_group %>">
<input type="hidden" id="b_pos" name="b_pos" value="<%=pb_pos %>">
<input type="hidden" id="b_step" name="b_step" value="<%=pb_step %>">
<table align="center" width="650px" height="280px">
	<tr>
		<td width="120px">������</td>
		<td width="580px">
			<input id="b_title" name="b_title" class="easyui-textbox">
		</td>
	</tr>
	<tr>
		<td width="120px">�ۼ���</td>
		<td width="580px">
			<input id="b_writer" name="b_writer" class="easyui-textbox">
		</td>
	</tr>	
	<tr>
		<td width="120px">����</td>
		<td width="580px">
			<input id="b_content" multiline="true" name="b_content" class="easyui-textbox" style="width:100%;height:100px">
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






