<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콘텐츠 구</title>
	<!-- 
	웹 폰트 : 사용자가 웹 페이지에 접속하는 순간 폰트를 자동으로 내려받고 해당 웹 페이지에서 사용할 수 있게 만들어주는 기능이다. 
	
	-->
	<link href="https://fonts.googleapis.com/css?family=Coiny&display=swap" rel="stylesheet">	
	<style type="text/css">
		#content{
			/* 중앙정렬 */
			width: 960px; margin: 0 auto;
			/* 수평 레이아웃 구 */
			overflow: hidden;
		}
		#content > #main_section {
			width: 750px;
			float: left;
		}
		#main_section > article.main_article{
			margin-bottom: 10px;
			padding: 20px;
			border: 1px solid black;
		}
		#content > #main_aside {
			width: 200px;
			float: right;
		}
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
		
		/* 첫번째 탭 */
		input:nth-of-type(1) { display: none;} /* input 태그는 보이지 않게 만듭니다*/
		/*input 태그가 체크되어 있지 않을 경우 뒤에 위치하는 div태그를 보이지 않게 만듭니다.*/
		input:nth-of-type(1) ~ div:nth-of-type(1) { display: none;}
		/* input 태그가 체크되어 있을 경우에는 뒤에 위치하는 div태그를 보이게 만듭니다. */
		input:nth-of-type(1):checked ~ div:nth-of-type(1) {display:block;}
		/* 번째 탭 */
		input:nth-of-type(2) { display: none;} /* input 태그는 보이지 않게 만듭니다*/
		/*input 태그가 체크되어 있지 않을 경우 뒤에 위치하는 div태그를 보이지 않게 만듭니다.*/
		input:nth-of-type(2) ~ div:nth-of-type(2) { display: none;}
		/* input 태그가 체크되어 있을 경우에는 뒤에 위치하는 div태그를 보이게 만듭니다. */
		input:nth-of-type(2):checked ~ div:nth-of-type(2) {display:block;}
		/* 탭 모양 구성 */
		section.buttons { overflow: hidden; }
		section.buttons > label { 
			/* 수평 정렬 */
			display: block; float: left;
			/* 크기 및 글자 위치 지정 */
			width: 100px; height: 30px;
			line-height: 30px;
			text-align: center;
			/* 테두리 지정 */
			box-sizing: border-box;
			border: 1px solid black;
			/* 색상 지정 */
			background: black;
			color: white;
		}
		input:nth-of-type(1):checked ~ section.buttons > label:nth-of-type(1) { 
			background: white;
			color: black;
		}
		input:nth-of-type(2):checked ~ section.buttons > label:nth-of-type(2) { 
			background: white;
			color: black;
		}
		.item{
			overflow: hidden;
			padding: 10px;
			border: 1px solid black;
			border-top: none;
		}
		.thumbnail{
			float: left;
		}
		.description{
			float: left;
			margin-left: 10px;
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
			<ul>
				<li><a href="#">Web</a></li>
				<li><a href="#">Mobile</a></li>
				<li><a href="#">Game</a></li>
				<li><a href="#">Simulation</a></li>
				<li><a href="#">Data</a></li>
			</ul>
		</nav>
		<nav id="main_lnb">
			<ul>
				<li><a href="#">HTML5</a></li>
				<li><a href="#">CSS3</a></li>
				<li><a href="#">JavaScript</a></li>
				<li><a href="#">jQuery</a></li>
				<li><a href="#">Note.js</a></li>
			</ul>
		</nav>
	</header>
	<div id="content">
		<section id="main_section">
			<article class="main_article">
				<h1>Main Section</h1>
				<p>CSS is a language that describes the style of an HTML document.<br>
                       CSS describes how HTML elements should be displayed.<br>
                       This tutorial will teach you CSS from basic to advanced. <br>
                       You can test your CSS skills with W3Schools' Exercises.
                </p>			
			</article>
			<article class="main_article">
				<h1>Main Section</h1>
				<p>CSS is a language that describes the style of an HTML document.<br>
                       CSS describes how HTML elements should be displayed.<br>
                       This tutorial will teach you CSS from basic to advanced. <br>
                       You can test your CSS skills with W3Schools' Exercises.
                </p>				
			</article>
			<article class="main_article">
				<h1>Main Section</h1>
				<p>CSS is a language that describes the style of an HTML document.<br>
                       CSS describes how HTML elements should be displayed.<br>
                       This tutorial will teach you CSS from basic to advanced. <br>
                       You can test your CSS skills with W3Schools' Exercises.
                </p>				
			</article>						
		</section>
	<aside id="main_aside">
		<input id="first" type="radio" name="tab" checked="checked"/>
		<input id="second" type="radio" name="tab"/>
		<section class="buttons">
			<label for="first">First</label>
			<label for="second">Second</label>
		</section>
		<div class="tab_item">
			<ul>
				<li class="item"><a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45*45"/>
							</div>
							<div class="description">
								<strong>HTML5 Canvas</strong>
								<p>2015-03-15</p>
							</div>
						</a>
				</li> 
				<li class="item"><a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45*45"/>
							</div>
							<div class="description">
								<strong>HTML5 Audio</strong>
								<p>2015-03-15</p>
							</div>
						</a>
				</li> 
				<li class="item"><a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45*45"/>
							</div>
							<div class="description">
								<strong>HTML5 Video</strong>
								<p>2015-03-15</p>
							</div>
						</a>
				</li> 
				<li class="item"><a href="#">
							<div class="thumbnail">
								<img src="http://placehold.it/45*45"/>
							</div>
							<div class="description">
								<strong>HTML5 Semantic Web</strong>
								<p>2015-03-15</p>
							</div>
						</a>
				</li> 
			</ul>
		</div>
		<div class="tab_item">
			<ul>
				<li><a href="#">CSS3 Transition</a></li>
				<li><a href="#">CSS3 Animation</a></li>
				<li><a href="#">CSS3 Border</a></li>
				<li><a href="#">CSS3 Box</a></li>
			</ul>
		</div>
	</aside>
	</div>
</body>
</html>