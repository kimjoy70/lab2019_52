<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <form name="loginform" method="post" action="user_control.jsp"> -->
<form name="loginform" method="post" action="/member/snsLogin.kos">
<c:choose>
<c:when test="${s_memname != null}">
	<li><a href="#"> :: </a></li>
	<li><a href="sns_control.jsp?action=getall&suid=${s_memname}">${s_memname}님 글 모아보기</a></li>
	<input type="hidden" name="action" value="logout">
	<input type="submit" value="로그아웃">
</c:when>
<c:otherwise>
	<li><a href="#"> :: </a></li>
		<li><a href="#">Login</a></li>
			<input type="hidden" name="work" value="member">
	  &nbsp;<input type="text" id="mem_id" name="mem_id" size="10" placeholder="아이디" style="font-size:16px">
		    <input type="password" id="mem_pw" name="mem_pw" size="10" placeholder="비밀번호" style="font-size:16px">
	        <input type="submit" value="로그인">
</c:otherwise>
</c:choose>
</form>