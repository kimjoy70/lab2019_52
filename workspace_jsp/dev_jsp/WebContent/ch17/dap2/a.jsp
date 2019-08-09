<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = "test";
	request.setAttribute("mem_id", mem_id);//담기
	//URL이 바뀌었으므로 상태가 유지 않음.- 그니까 null
	//response.sendRedirect("b.jsp");
	//어떻게 해?
	RequestDispatcher view = request.getRequestDispatcher("b.jsp");
	view.forward(request, response);
	//문제 
	//a.jsp페이지에서 생성한 객체 mem_id를 b.jsp에서 사용하고 싶다 
	//어떡하지?
%>    
<!DOCTYPE html>
<!-- 
이 페이지를 실행해 봤나요?
무엇을 봤는지 말해 봅시다.
1)먼저 주소창에 a.jsp페이지를 요청함.
2)버튼을 클릭하면 b.jsp페이지로 이동함.
3)b.jsp페이지의 내용이 출력됨.
4)url이 변경되었음.
  :기존 요청이 끊어지고 새로운 요청이 발생함.
  :a.jsp페이지에서 담은 정보를 b.jsp페이지에서 사용할 수 없음.
  
이전 페이지로 이동하기
location.go(-1);

다음 페이지로 이동하기
location.go(1);   
 -->
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
<script type="text/javascript">
	function move(){
		location.href="b.jsp";
	}
	function nextPage(){
		history.go(1);
	}
</script>
</head>
<body>
여기는 a.jsp<br>
<input type="button" value="b.jsp이동" onClick="move()"> 
<input type="button" value="다음" onClick="nextPage()"> 
</body>
</html>