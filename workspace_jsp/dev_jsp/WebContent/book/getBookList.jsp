<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
	List<Map<String,Object>> bookList = 
		(List<Map<String,Object>>)request.getAttribute("bookList");
	int size = 0;
	if(bookList!=null){
		size = bookList.size();
		out.print("size:"+size);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
<script type="text/javascript">
	function getBookList(){
		location.href="/book/bookCRUD.bap?gubun=sel"
	}
	function bookInsert(){
		location.href="/book/bookCRUD.bap?gubun=ins"
	}
	function bookUpdate(){
		location.href="/book/bookCRUD.bap?gubun=upd"
	}
	function bookDelete(){
		location.href="/book/bookCRUD.bap?gubun=del"
	}
</script>
</head>
<body>
<h2>도서목록 페이지</h2>
<input type="button" value="조회" onClick="getBookList()">
<input type="button" value="입력" onClick="bookInsert()">
<input type="button" value="수정" onClick="bookUpdate()">
<input type="button" value="삭제" onClick="bookDelete()">
</body>
</html>




