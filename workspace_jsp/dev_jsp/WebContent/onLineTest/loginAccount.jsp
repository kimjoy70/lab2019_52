<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.vo.MemberVO, java.util.Map" %>
<%
	Map<String,Object> pMap = (Map<String,Object>)session.getAttribute("pMap");
	//out.print(rmVO.getMem_id());
%>
    <form class="navbar-form navbar-right" action="/logout.jsp">
        <label for="msg">
          	<font color="white"><%=pMap.get("mem_name") %>님 환영합니다.</font>
        </label>
        <button type="button" class="btn btn-dark" onclick="logoutAction()">LogOut</button>
    </form>