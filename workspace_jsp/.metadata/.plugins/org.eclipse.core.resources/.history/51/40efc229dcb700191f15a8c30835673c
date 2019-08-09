<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리액트 라이프사이클 - constructor</title>
	<script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
  	<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
  	<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
</head>
<body>
    <div id="root"></div>
	<script type="text/babel"> 
	class Header extends React.Component {
  		constructor(props) {
    	super(props);
    	this.state = {favoritecolor: "red"};
  		}
  		render() {
    		return (
      			<h1>My Favorite Color is {this.state.favoritecolor}</h1>
    		);
  		}
	}

	ReactDOM.render(<Header />, document.getElementById('root'));
	</script>
</body>
</html>