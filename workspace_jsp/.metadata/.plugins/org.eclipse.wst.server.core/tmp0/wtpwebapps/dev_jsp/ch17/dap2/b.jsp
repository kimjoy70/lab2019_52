<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = (String)request.getAttribute("mem_id");
	out.print(mem_id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp</title>
<script type="text/javascript">
	function previous(){
		history.go(-1);
		//history.back();
	}
</script>
</head>
<body>
여기는 b.jsp<br>
<input type="button" value="이전" onClick="previous()">
</body>
</html>