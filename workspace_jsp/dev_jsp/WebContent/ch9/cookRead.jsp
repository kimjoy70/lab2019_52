<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키에 담긴 정보 읽어오기</title>
<script type="text/javascript">
	function cookDel(){
		location.href = "cookieDelete.jsp";
	}
</script>
</head>
<body>
<%
	Cookie cooks[] = request.getCookies();
	out.print(cooks[0]);
	out.print("<br>");
	out.print(cooks[0].getName()+", "+cooks[0].getValue());
	out.print("<br>");
	out.print(cooks[1].getName()+", "+cooks[1].getValue());
	out.print("<br>");
	out.print(cooks[2].getName()+", "+cooks[2].getValue());
	
%>
<input type="button" value="쿠키삭제" onClick="cookDel()">
</body>
</html>






