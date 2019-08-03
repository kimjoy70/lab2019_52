<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹서버에서 쿠키 생성하기</title>
</head>
<body>
<%
	Cookie cook1 = new Cookie("notebook","삼성N9");
	cook1.setMaxAge(60);
	Cookie cook2 = new Cookie("hp","아이폰XS");
	cook2.setMaxAge(60*60);
	//만일 별도로 시간을 부여하지 않으면 브라우저가 종료될 때 자동으로 삭제됨.
	Cookie cook3 = new Cookie("coffee","바닐라라떼");
	response.addCookie(cook1);//새로운 쿠키를 생성하면 브라우저에 전송함.
	response.addCookie(cook2);
	response.addCookie(cook3);
%>
</body>
</html>