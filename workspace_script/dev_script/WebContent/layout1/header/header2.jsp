<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
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
			right: 0; top: 0;
		}
		#main_header > #main_lnb{
			position: absolute;
			right: 0; bottom: 10px;
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