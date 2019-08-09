<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
컴포넌트는 DOM에서 제거되는 경우, 또는주기의 다음 단계는 해제하면 호출 좋아 반응한다.
반응은 구성 요소가 마운트 해제 될 때 호출되는 하나의 내장 방법이있다 :
componentWillUnmount컴포넌트는 DOM에서 제거 될 때 메소드가 호출된다.
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
class Container extends React.Component {
  constructor(props) {
    super(props);
    this.state = {show: true};
  }
  delHeader = () => {
    this.setState({show: false});
  }
  render() {
    let myheader;
    if (this.state.show) {
      myheader = <Child />;
    };
    return (
      <div>
      {myheader}
      <button type="button" onClick={this.delHeader}>Delete Header</button>
      </div>
    );
  }
}

class Child extends React.Component {
  componentWillUnmount() {
    alert("The component named Header is about to be unmounted.");
  }
  render() {
    return (
      <h1>Hello World!</h1>
    );
  }
}

ReactDOM.render(<Container />, document.getElementById('root'));
	</script>
</body>
</html>