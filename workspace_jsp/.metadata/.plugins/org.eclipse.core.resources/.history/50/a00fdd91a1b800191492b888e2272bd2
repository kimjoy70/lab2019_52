<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
componentDidUpdate구성 요소가 DOM에 업데이트 된 후 메서드가 호출됩니다.
아래의 예는 복잡하게 보일 수도 있지만이하는 모든이입니다 :
구성 요소가 될 때 장착 그것은 "빨간색"좋아하는 색으로 렌더링됩니다.
컴퍼넌트 때 탑재되어, 타이머의 상태를 변경하고, 색상은 "옐로우"된다.
이 작업은 트리거 업데이트 상을,이 구성 요소는 가지고 있기 때문에 componentDidUpdate방법,이 방법을 실행하고 빈 DIV 요소에 메시지를 기록합니다 :

componentDidUpdate업데이트는 DOM에서 렌더링 된 후 메서드가 호출된다 :
 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>componentDidUpdate</title>
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
  componentDidMount() {
    setTimeout(() => {
      this.setState({favoritecolor: "yellow"})
    }, 1000)
  }
  componentDidUpdate() {
    document.getElementById("mydiv").innerHTML =
    "The updated favorite is " + this.state.favoritecolor;
  }
  render() {
    return (
      <div>
      <h1>My Favorite Color is {this.state.favoritecolor}</h1>
      <div id="mydiv"></div>
      </div>
    );
  }
}

ReactDOM.render(<Header />, document.getElementById('root'));
	</script>
</body>
</html>