<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getDerivedStateFromProps메소드 - 렌더링 전에 호출됨</title>
	<script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
  	<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
  	<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
</head>
<body>
<!-- 
getDerivedStateFromProps()방법은 바로 DOM의 요소 (들)을 렌더링하기 전에 호출된다.
또한에 업데이트getDerivedStateFromProps 방법이라고합니다. 이 구성 요소가 업데이트되는 때 호출되는 첫 번째 방법이다.

이것은 여전히 설정하는 자연 장소 state초기 소품을 기준으로 개체를.

아래의 예는 파란색으로 좋아하는 색상을 변경하는 버튼이 있지만 이후 getDerivedStateFromProps()favcol 속성에서 색상과 상태를 업데이트라고 방법, 
좋아하는 색깔은 여전히 노란색으로 렌더링된다 :
 -->
    <div id="root"></div>
	<script type="text/babel"> 
class Header extends React.Component {
  constructor(props) {
    super(props);
    this.state = {favoritecolor: "red"};
  }
  static getDerivedStateFromProps(props, state) {
    return {favoritecolor: props.favcol };
  }
  changeColor = () => {
    this.setState({favoritecolor: "blue"});
  }
  render() {
    return (
      <div>
      <h1>My Favorite Color is {this.state.favoritecolor}</h1>
      <button type="button" onClick={this.changeColor}>Change color</button>
      </div>
    );
  }
}

ReactDOM.render(<Header favcol="yellow"/>, document.getElementById('root'));
	</script>
</body>
</html>