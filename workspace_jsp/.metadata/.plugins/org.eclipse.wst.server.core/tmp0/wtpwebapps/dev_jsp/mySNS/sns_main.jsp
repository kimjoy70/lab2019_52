<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.vo.SNSMessageSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sns"%>
<%
	Map<String,Object> pMap = null;
	String s_memname = null;
	String s_rstatus = null;
	if(session.getAttribute("pMap")!=null){
		pMap = (Map<String,Object>)session.getAttribute("pMap");
		s_memname = (String)pMap.get("mem_name");
		s_rstatus = (String)pMap.get("r_status");
	}
	//out.print(s_memname);
	/*
	varStatus - 반복 상태값이 있는 변수
	var - 현재 아이템이 있는 변수
	items - 반복을 위한 데이터를 가진 아이템의 컬렉션
	step - 반복의 증가분
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My SNS</title>
<link rel="stylesheet" href="/css/styles.css" type="text/css" media="screen" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js" ></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->
<script>
	$(function() {
		$("#accordion").accordion({
			heightStyle : "content",
			active : parseInt("${curmsg == null ? 0:curmsg}")
		});
	});

	function newuser() {
		window
				.open(
						"new_user.jsp",
						"newuser",
						"titlebar=no,location=no,scrollbars=no,resizeable=no,menubar=no,toolbar=no,width=300,height=240");
	}
</script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>

<body>
	<header>
		<div class="container1">
			<h1 class="fontface" id="title">My Simple SNS</h1>
		</div>
	</header>

	<nav>
		<div class="menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="javascript:newuser()">New User</a></li>
				<li><a href="sns_control.jsp?action=getall">전체글보기</a>
				<li>
<%
	if(s_memname==null){
%>				
				<span id="login">
				<form name="loginform" method="post" action="/member/snsLogin.kos">
					<li><a href="#"> :: </a></li>
					<li><a href="#">Login</a></li>
					<input type="hidden" name="work" value="member">&nbsp;
		  	        <input type="text" id="mem_id" name="mem_id" size="10" placeholder="아이디" style="font-size:16px">
			    	<input type="password" id="mem_pw" name="mem_pw" size="10" placeholder="비밀번호" style="font-size:16px">
		        	<input type="submit" value="로그인">	
		        </form>					
				</span>
<%
	}
	else{
%>				
		<script type="text/javascript">
			$.ajax({
				method:"get"
			   ,url:"getAll.kos?work=mySNS&timestamp="+new Date().getTime()
			   ,success:function(data){
				   //alert(data);
				   $("#d_msg").html(data);
				   
			   }
			});
		</script>
				<span id="logout">
				<form name="loginform" method="post" action="/member/logout.jsp">
					<li><a href="#"> :: </a></li>
					<li><a href="sns_control.jsp?action=getall&suid=<%=s_rstatus%>"><%=s_memname %>님 글 모아보기</a></li>
					<input type="hidden" name="action" value="logout">
					<input type="submit" value="로그아웃">					
				</form>	
				</span>				
<%
	}
%>				
				</li>
			</ul>
		</div>
	</nav>

	<div id="wrapper">
		<section id="main">
			<section id="content">
				<b>내소식 업데이트</b>
				<form class="m_form" method="post" action="sns_control.jsp?action=newmsg">
					<input type="hidden" name="uid" value="${uid}">
					<sns:write type="msg"/>
					<button class="submit" type="submit">등록</button>
				</form>
				<br>
				<br>
				<h3>친구들의 최신 소식</h3>
				<div id="d_msg">111
				</div>
			
				<div align="center"><a href="sns_control.jsp?action=getall&cnt=${cnt+5}&suid=${suid}">더보기&gt;&gt;</a></div>

			</section>
			<aside id="sidebar2">
				<!-- sidebar2 -->
				<h2>새로운 친구들.!!</h2>
				<c:forEach items="${nusers}" var="n">
					<ul>
						<li><a href="sns_control.jsp?action=getall&suid=${n}">${n}</a></li>
					</ul>
				</c:forEach>

				<br> <br>
				<h3>We're Social Too!!</h3>
				<img src="facebook_32.png"> <img src="twitter_32.png">
				<img src="youtube_32.png"> <br> <br>
				<br> <br>

				<h3>Links</h3>
				<ul>
					<li><a href="#">한빛미디어</a></li>
					<li><a href="#">가천대학교</a></li>
					<li><a href="#">가천대학교 길병원</a></li>
				</ul>

			</aside>
			<!-- end of sidebar -->
		</section>
	</div>

	<footer>
		<div class="container1">
			<section id="footer-area">

			<section id="footer-outer-block">
					<aside class="footer-segment">
							<h4>About</h4>
								<ul>
									<li><a href="#">About My Simple SNS</a></li>
									<li><a href="#">Copyright</a></li>
									<li><a href="#">Author</a></li>
								</ul>
					</aside><!-- end of #first footer segment -->

					<aside class="footer-segment">
							<h4>Java Web Programming</h4>
								<ul>
									<li><a href="#">Book Information</a></li>
									<li><a href="#">Table of contents</a></li>
									<li><a href="#">Book History</a></li>
								</ul>
					</aside><!-- end of #second footer segment -->

					<aside class="footer-segment">
							<h4>Contact Us</h4>
								<ul>
									<li><a href="#">Book Support</a></li>
									<li><a href="#">Publication</a></li>
									<li><a href="#">Investor Relations</a></li>
									</ul>
					</aside><!-- end of #third footer segment -->
					
					<aside class="footer-segment">
							<h4>Hee Joung Hwang</h4>
								<p>&copy; 2014 <a href="#">dinfree.com</a> </p>
					</aside><!-- end of #fourth footer segment -->

				</section>
				<!-- end of footer-outer-block -->

			</section>
			<!-- end of footer-area -->
		</div>
	</footer>
</body>
</html>