<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport"
      content="width=device-width, initial-scale=1" />
    <title>React로 Table그리기</title>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.0/react-dom.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
  <div id="root"></div>
  <script type="text/babel">
	var TableDOM 
		= React.createClass({
	  			render: function() { 
    			return (
					<div>
					<table width="600px" border="1" borderColor="red">
					<thead>
        			<tr>
          				<th width="360px">제목</th><th width="120px">작성자</th><th width="120px">작성일</th>
        			</tr>
					</thead>
					</table>
					</div>      			
    			);
				} 
	}); 
	ReactDOM.render(<TableDOM />,document.getElementById('root')
	);  
  </script>
</body>
</html>