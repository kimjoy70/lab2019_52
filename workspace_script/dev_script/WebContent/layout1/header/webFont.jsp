<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹폰트 - webFont.jsp</title>
	<!-- 웹 폰트 : 사용자가 웹 페이지에 접속하는 순간 폰트를 자동으로 내려받고 해당 웹 페이지에서 사용할 수 있게 만들어주는 기능이다. -->
	<link href="https://fonts.googleapis.com/css?family=Coiny&display=swap" rel="stylesheet">	
	<style type="text/css">
		#title{
			font-family: 'Coiny', cursive;
		}
		#main_header{
			width: 960px;
			margin: 0 auto;
			/* 절대 좌표 */
			height: 160px;
			position: relative;
		}
		#main_header > #title{
			position: absolute;
			left: 20px; top: 30px;
		}
		#main_header > #main_gnb{
			position: absolute;
			right: 0px; top: 0px;
		}
		#main_header > #main_lnb{
			position: absolute;
			right: 0px; top: 100px;
		}
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