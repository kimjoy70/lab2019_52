<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxMemberList.jsp</title>
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		var param = "command=sel";
		$.ajax({
			type:"post"
		   ,data:param
		   ,url:"/ch3/memberMgr.do"
		   ,success:function(result){
			   //alert(result);
   			   var html="<table border='1'>";
			   $(result).find('record').each(function(){
				  var $entry = $(this);
				  html+="<tr>";
				  html+="<td>";
				  html+=$entry.find("id").text();
				  html+="</td>";
				  html+="<td>";
				  html+=$entry.find("name").text();
				  html+="</td>";
				  html+="<td>";
				  html+=$entry.find("address").text();
				  html+="</td>";
				  html+="</tr>";
			   });
			   html+="</table>";
			   $("#d_member").append(html);
		   }
		});
	});
</script>
<div id="d_member"></div>
</body>
</html>