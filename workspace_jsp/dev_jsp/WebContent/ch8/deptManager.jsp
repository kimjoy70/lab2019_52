<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptManager.jsp</title>
</head>
<body>
<form name="f_dept" id="f_dept" method="post" action="deptConfirm.jsp">
<input type="text" name="dname" id="dname">
<input type="submit">
</form>
<!-- 
jsp페이지 주석을 언제 사용하나요?
html주석과 jsp페이지 주석은 다르다.
jsp의 역할이 json포맷이거나 xml포맷인 경우라면 반드시 jsp주석을 사용할 것.
 -->
<%-- <jsp:forward page="deptMove.jsp"/> --%>
</body>
</html>







