<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 
	웹 폰트 : 사용자가 웹 페이지에 접속하는 순간 폰트를 자동으로 내려받고 해당 웹 페이지에서 사용할 수 있게 만들어주는 기능이다. 
	
	-->
	<link href="https://fonts.googleapis.com/css?family=Coiny&display=swap" rel="stylesheet">	
	<style type="text/css">
		#title{
			font-family: 'Coiny', cursive;
		}
		/* 자손에 float속성을 사용했으므로 부모의 overflow 속성에 hidden 키워드를 적용했다. */
		#main_gnb > ul { overflow: hidden;}
		#main_gnb > ul > li { float: left;}
		#main_gnb > ul > li > a{
			display: block;
			padding: 2px 10px;
			border: 1px solid black;
		}
		#main_gnb > ul > li > a:hover{
			background: black;
			color: white;
		}
		#main_gnb > ul > li:first-child > a { border-radius: 10px 0 0 10px;}
		#main_gnb > ul > li:last-child > a { border-radius: 0 10px 10px 0;}
		#main_lnb > ul { overflow: hidden;}
		#main_lnb > ul > li { float: left;}
		#main_lnb > ul > li > a{
			display: block;
			padding: 10px 20px;
			border: 1px solid black;
		}
		/*
		a태그에 block속성을 사용한 이유는 만약 li태그에 padding 속성과 border속성을 사용하면 a태그가 버튼의 일부 영역만 차지하므로
		클릭하는 영역을 확장하고자 a태그에 padding속성을 사용했습니다.
		
		*/
		#main_lnb > ul > li > a:hover{
			background: black;
			color: white;
		}
		#main_lnb > ul > li:first-child > a { border-radius: 10px 0 0 10px;}
		#main_lnb > ul > li:last-child > a { border-radius: 0 10px 10px 0;}
	</style>
</head>
<body>
	<header id="main_header">
		<div id="title">
			<h1>Rint Development</h1>
			<h2>HTML5 + CSS3 Basic</h2>
		</div>
		<nav id="main_gnb">
			<ul style="list-style-type:none;">
				<li><a href="#">Web</a></li>
				<li><a href="#">Mobile</a></li>
				<li><a href="#">Game</a></li>
				<li><a href="#">Simulation</a></li>
				<li><a href="#">Data</a></li>
			</ul>
		</nav>
		<nav id="main_lnb">
			<ul style="list-style-type:none;">
				<li><a href="#">HTML5</a></li>
				<li><a href="#">CSS3</a></li>
				<li><a href="#">JavaScript</a></li>
				<li><a href="#">jQuery</a></li>
				<li><a href="#">Note.js</a></li>
			</ul>
		</nav>
	</header>
</body>
</html>