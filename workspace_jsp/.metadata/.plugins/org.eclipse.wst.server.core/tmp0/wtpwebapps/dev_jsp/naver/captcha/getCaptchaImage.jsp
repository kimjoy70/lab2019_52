<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>    
<%@ page import="java.util.*, java.net.*" %>    
<%
	String clientId = "NgGcR4fyyW6AGlPvu4_M";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "OGR0UIiLHD";//애플리케이션 클라이언트 시크릿값";
	String key = null;
	try {
/* 키 발급 관련 코드 입양 시작 */
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
	    br.close();          //123456789              24
	    key = res.toString();//{"key":"hdXHBrw4F9JCivnj"}
	    key = key.substring(8,24);
	    //out.print(key);
	    //캡챠 이미지를 꺼내주는 URL이 머지?
	    String imgURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
		/* 키 발급 관련 코드 입양  끝   */
		out.print(imgURL);
	} catch (Exception e) {
	    out.println(e);
	}
%>