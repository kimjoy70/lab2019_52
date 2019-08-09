<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptConfirm.jsp</title>
</head>
<body>
<jsp:useBean id="dvo" scope="page" class="com.vo.DeptVO"/>
<jsp:setProperty property="*" name="dvo"/>
이름 : <jsp:getProperty property="dname" name="dvo"/>
</body>
</html>