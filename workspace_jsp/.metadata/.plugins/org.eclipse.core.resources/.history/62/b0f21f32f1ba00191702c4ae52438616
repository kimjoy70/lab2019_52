<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport"
      content="width=device-width, initial-scale=1" />
    <title>MyForm5 - 여러개 입력받기</title>
    <script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
  	<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
  	<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>
  </head>
  <body>
<!-- 
당신이 당신의 나이를 입력 할 때 세 필드가 숫자가 아닌 경우, 당신은 경고를 얻을 것이다 :
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
    if (nam === "age") {
      if (!Number(val)) {
        alert("Your age must be a number");
      }
    }
    this.setState({[nam]: val});
  }
  mySubmitHandler = (event) => {
    event.preventDefault();
    alert("You are submitting " + this.state.username +" , "+ this.state.age);
	location.href="myForm.jsp";
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