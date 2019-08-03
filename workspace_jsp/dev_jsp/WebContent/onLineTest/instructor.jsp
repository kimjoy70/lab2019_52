<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>강사진 - 코딩놀이</title>
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap1.css">
</head>
<body>
<!-- 
======================================================================================================================
													top 영역 시작
======================================================================================================================
 -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">코딩놀이</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">소개</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Front-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">HTML5</a></li>
          <li><a href="#">CSS</a></li>
          <li><a href="#">JavaScript</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Back-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Java</a></li>
          <li><a href="#">서블릿</a></li>
          <li><a href="#">JSP</a></li>
          <li><a href="#">Spring</a></li>
          <li><a href="#">안드로이드</a></li>
        </ul>
      </li>
     </ul>
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right" action="/action_page.php">
          <div class="form-group">
            <input type="text" class="form-control" id="usrname" size="10" placeholder="아이디">
          </div>
          <div class="form-group">
            <input type="text" class="form-control" id="psw" size="10" placeholder="비밀번호">
          </div>
          <button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
        </form>
      </div>
  </div>
</nav>
<!-- 
======================================================================================================================
													top 영역  끝
======================================================================================================================
 -->
     <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            <span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;나신입
                        </h3>
                    </div>
                    <div class="panel-body">
                        <div class="media">
                            <div class="media-left">
                            <a href="#">
                                <img class="media-object" src="../images/여진구.jpeg" alt="개발자이미">
                            </a>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">김유신</h4><br>
                                한국소프트웨어 인재 개발원 대표 강사입니다.
                            </div>
                        </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>강사명</th>
                                <th>강의 번호</th>
                                <th>강의 제목</th>
                                <th>강의 날짜</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<tr>
                        		<td>김승수</td>
                        		<td>1</td>
                        		<td><a href="lecture.html?lectureName=c">C언어 강좌</a></td>
                        		<td>2019-04-20</td>
                        	</tr>
                        	<tr>
                        		<td>김유신</td>
                        		<td>2</td>
                        		<td><a href="lecture.html?lectureName=java">JAVA 강좌</a></td>
                        		<td>2019-03-20</td>
                        	</tr>
                        	<tr>
                        		<td>이성계</td>
                        		<td>3</td>
                        		<td><a href="lecture.html?lectureName=oracle">Oracle 강좌</a></td>
                        		<td>2019-05-20</td>
                        	</tr>
                        </tbody>
                    </table>
                    <div class="panel-footer">
                        <blockquote>I Can Do It!!!</blockquote>
                    </div>
                </div>
            </div>

        </div>
    </div>
<!-- 
======================================================================================================================
													bottom 영역 시작
======================================================================================================================
 -->
<%@ include file="bottom.jsp" %>
<!-- 
======================================================================================================================
													bottom 영역  끝
======================================================================================================================
 -->
</body>
</html>