<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
<%
	Cookie[] cooks = request.getCookies();
	if(cooks!=null && cooks.length!=0){
		for(int i=0;i<cooks.length;i++){//쿠키에 담긴 정보의 수만큼
			//쿠키에 저장된 웹 브라우저의 세션 아이디값을 출력해 볼 수 있다.
			//따로 쿠키를 생성하는 페이지를 호출하지 않아도 JSESSIONID하나는 들어있다.
			String c_name = cooks[i].getValue();
			out.print(c_name);
		}
	}
%>
</body>
</html>