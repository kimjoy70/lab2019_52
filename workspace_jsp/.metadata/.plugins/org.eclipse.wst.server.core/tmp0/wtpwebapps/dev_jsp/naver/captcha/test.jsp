<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function getCaptchaKey(){
		$.ajax({
			method:"post"
		   ,url:"getCaptchaImageVer2.jsp"
		   ,success:function(result){
			   //alert("result:"+result+"11");
			   //location.href=result;
			   $("#captchaIMG").attr("src",result);
			   //$("#d_captcha").html(str);
		   }
		});
	}
</script>
</head>
<body onLoad="getCaptchaKey()">
<img id='captchaIMG' width='200px' height='90px'/>
</body>
</html>