<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport"
      content="width=device-width, initial-scale=1" />
    <title>MyForm4 - 여러개 입력받기</title>
    <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
  	<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
  	<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
  </head>
  <body>
<!-- 
HTML에서, 폼 데이터는 일반적으로 DOM에 의해 처리됩니다.
반작용에서, 폼 데이터는 일반적으로 구성 요소에 의해 처리됩니다.
데이터 구성 요소에 의해 처리 될 때, 모든 데이터 요소에 저장된다 state.
당신은에 이벤트 핸들러를 추가하여 변경 제어 할 수있는 onChange속성 :
 -->  
    <div id="root"></div>
    <script type="text/babel">
class MyForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      age: null,
    };
  }
  myChangeHandler = (event) => {
    let nam = event.target.name;
    let val = event.target.value;
    this.setState({[nam]: val});
  }
  mySubmitHandler = (event) => {
    event.preventDefault();
    alert("You are submitting " + this.state.username +" , "+ this.state.age);
  }
  render() {
    return (
      <form>
      <h1>Hello {this.state.username} {this.state.age}</h1>
      <p>Enter your name:</p>
      <input
        type='text'
        name='username'
        onChange={this.myChangeHandler}
      />
      <p>Enter your age:</p>
      <input
        type='text'
        name='age'
        onChange={this.myChangeHandler}
      />
      <input
        type='submit' value='전송'/>
      </form>
    );
  }
}

ReactDOM.render(<MyForm />, document.getElementById('root'));
    </script>
  </body>
</html>