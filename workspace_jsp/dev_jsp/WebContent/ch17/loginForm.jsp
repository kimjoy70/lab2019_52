<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 무엇을 작성할 수 있지? java(서블릿) : 실행주체가 서버다.-->    
<%
//스크립틀릿이다.
//service메소드에 들어가는 코드이다.
//서버측에서 실행된 후 그 결과가 로컬에 다운로드 된다.
//인스턴스화를 할 수 있다.
//그러나 권장사항은 아니다.
//이유:재사용성이 떨어짐.유지가 안된다.
//위치:어디든 상관없지만 일단 page direcive 다음에 사용하자.
//    어차피 서버에서 먼저 실행된(결정됨-정적이다.) 후 로컬에 다운로드 되어 실행되니까.....
	request.getParameter("mem_id");
	//req.getParameter("mem_id");
%>
<!DOCTYPE html>
<!-- html영역 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function login(){
		$("#f_login").attr("method","post");
		/* $("#f_login").attr("action","loginAction.jsp"); */
		/* $("#f_login").attr("action","login.do"); */
		$("#f_login").attr("action","login2.nhn");
		$("#f_login").submit();
	}
</script>
</head>
<body>
<form id="f_login">
<!-- <form id="f_login" method="get|post" action="목적지.jsp|XXX.do"> -->
	아이디 : <input type="text" id="mem_id" name="mem_id" size="10"><br>
	비밀번호 : <input type="text" id="mem_pw" name="mem_pw" size="10"><br>
	<input type="button" id="btn_login" value="로그인" onClick="login()"><br>
</form>
</body>
</html>