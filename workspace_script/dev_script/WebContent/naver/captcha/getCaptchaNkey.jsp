<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>    
<%
/*
LhOC7VgRyKY6pLvQt2ty, UaG3KaVlqj
*/
	String clientId = "LhOC7VgRyKY6pLvQt2ty";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "UaG3KaVlqj";//애플리케이션 클라이언트 시크릿값";
	try {
	    String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
	    String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
	    URL url = new URL(apiURL);
	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    con.setRequestMethod("GET");
	    con.setRequestProperty("X-Naver-Client-Id", clientId);
	    con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	    int responseCode = con.getResponseCode();
	    BufferedReader br;
	    if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	    String inputLine;
	    StringBuffer res = new StringBuffer();
	    while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	    }
	    br.close();
	    out.println(res.toString());
	} catch (Exception e) {
	    out.println(e);
	}
%>