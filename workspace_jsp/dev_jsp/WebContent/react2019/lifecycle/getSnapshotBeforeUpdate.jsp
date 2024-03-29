<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
props및 state 이전 에도 업데이트 후, 당신은 값이 무엇인지 확인할 수 있다는 것을 의미, 업데이트를 하기 전에 업데이트.
는 IF getSnapshotBeforeUpdate()방법이 존재, 당신은 또한 포함되어야한다 componentDidUpdate()그렇지 않으면 오류가 발생합니다, 방법.
아래의 예는 복잡하게 보일 수도 있지만이하는 모든이입니다 :
구성 요소가 될 때 장착 그것은 "빨간색"좋아하는 색으로 렌더링됩니다.
컴퍼넌트 때 탑재되어, 타이머는 상태를 변경 일초 후에 원하는 색상은 "옐로우"된다.
이 작업은 트리거 업데이트 상을,이 구성 요소는 가지고 있기 때문에 getSnapshotBeforeUpdate()방법,이 방법은 실행되고, 빈 DIV1 요소에 메시지를 기록합니다.
그 다음 componentDidUpdate()방법은 실행하고 빈 DIV2 요소에 메시지를 기록합니다 :

업데이트하기 전에 좋아하는 것이 빨간색이었습니다.
업데이트 된 즐겨 찾기는 노란색입니다
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getSnapshotBeforeUpdate메소드 - 업데이트 전에도 후에도 값을 확인가능</title>
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
  getSnapshotBeforeUpdate(prevProps, prevState) {
    document.getElementById("div1").innerHTML =
    "Before the update, the favorite was " + prevState.favoritecolor;
  }
  componentDidUpdate() {
    document.getElementById("div2").innerHTML =
    "The updated favorite is " + this.state.favoritecolor;
  }
  render() {
    return (
      <div>
      <h1>My Favorite Color is {this.state.favoritecolor}</h1>
      <div id="div1"></div>
      <div id="div2"></div>
      </div>
    );
  }
}

ReactDOM.render(<Header />, document.getElementById('root'));
	</script>
</body>
</html>