<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hmenu.jsp-수평메뉴 </title>
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
		#main_gnb > ul > li > a{ }
		#main_lnb > ul { overflow: hidden;}
		#main_lnb > ul > li { float: left;}
		#main_lnb > ul > li > a{ }
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