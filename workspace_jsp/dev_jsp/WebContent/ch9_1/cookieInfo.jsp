<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스를 추가했을 경우[ch9_1]</title>
</head>
<body>
<%
	Cookie[] cooks = request.getCookies();
	if(cooks!=null && cooks.length!=0){
		for(int i=0;i<cooks.length;i++){//쿠키에 담긴 정보의 수만큼
			if(cooks[i].getName().equals("name1")){//쿠키 이름에 맞는 것
				String c_name = cooks[i].getValue();
				out.print("쿠키에 저장된 이름(name1) :  "+URLDecoder.decode(c_name,"utf-8"));
			}
			else if(cooks[i].getName().equals("name2")){//쿠키 이름에 맞는 것
				String c_name = cooks[i].getValue();
				out.print("쿠키에 저장된 이름(name2) :  "+URLDecoder.decode(c_name,"utf-8"));
			}
		}
	}
	out.print("요기");
%>
</body>
</html>