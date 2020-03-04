<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
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
	</style>
</head>
<body>
	<aside id="main_aside">
		<input id="first" type="radio" name="tab" checked="checked"/>
		<input id="second" type="radio" name="tab"/>
		<section class="buttons">
			<label for="first">First</label>
			<label for="second">Second</label>
		</section>
		<div class="tab_item">
			<ul>
				<li><a href="#">HTML5 Canvas</a></li>
				<li><a href="#">HTML5 Audio</a></li> 
				<li><a href="#">HTML5 Video</a></li>
				<li><a href="#">HTML Semantic Web</a></li>
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
</body>
</html>