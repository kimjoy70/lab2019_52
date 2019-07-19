<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>    
<%@ page import="java.util.*, java.net.*" %>    
<%@ page trimDirectiveWhitespaces="true" %>
<%
/*
LhOC7VgRyKY6pLvQt2ty, UaG3KaVlqj
*/
	String clientId = "LhOC7VgRyKY6pLvQt2ty";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "UaG3KaVlqj";//애플리케이션 클라이언트 시크릿값";
	String key = null;
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
	    }
	    else{
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	    String inputLine;
	    StringBuffer res = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
        	res.append(inputLine);
        }
        br.close();
        key = res.toString();
        key = key.substring(8, 24);
        String apiURL2 = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
		out.print(apiURL2);
	} catch (Exception e) {
	    out.println(e);
	}
%>