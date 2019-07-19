<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<div id="content"></div>
	<script type="text/babel"> 
class ShoppingList extends React.Component {
	  render() {
	    return (
	      <div className="shopping-list">
	        <h1>Shopping List for {this.props.name}</h1>
	        <ul>
	          <li>Instagram</li>
	          <li>WhatsApp</li>
	          <li>Oculus</li>
	        </ul>
	      </div>
	    );
	  }//////////////end of render
}////////////////end of ShoppingList
ReactDOM.render( <ShoppingList />, document.getElementById('content') );
	//사용 예제: <ShoppingList name="Mark" />
</script>
	<!-- 
XML과 유사한 재밌는 태그를 사용할 것입니다. 우리는 컴포넌트를 사용하여 React에게 화면에 표현하고 싶은 것이 무엇인지 알려줍니다. 
데이터가 변경될 때 React는 컴포넌트를 효율적으로 업데이트하고 다시 렌더링합니다.
여기에서 ShoppingList는 React 컴포넌트 클래스 또는 React 컴포넌트 타입입니다. 
개별 컴포넌트는 props라는 매개변수를 받아오고 render 함수를 통해 표시할 뷰 계층 구조를 반환합니다.
render 함수는 화면에서 보고자 하는 내용을 반환합니다. React는 설명을 전달받고 결과를 표시합니다. 
특히 render는 렌더링할 내용을 경량화한 React 엘리먼트를 반환합니다. 
다수의 React 개발자는 “JSX”라는 특수한 문법을 사용하여 React의 구조를 보다 쉽게 작성합니다. 
<div /> 구문은 빌드하는 시점에서 React.createElement('div')로 변환됩니다. 위에서 본 예시는 아래와 같이 변화합니다.

React.createElement("div", {
  className: "shopping-list"
}, React.createElement("h1", null, "Shopping List for ", props.name), 
React.createElement("ul", null, React.createElement("li", null, "Instagram"), 
React.createElement("li", null, "WhatsApp"), 
React.createElement("li", null, "Oculus")));

createElement()에 대해 궁금한 점이 있다면 API 참조에서 자세한 설명을 확인할 수 있습니다. 하지만 자습서에서는 이 방식이 아니라 JSX를 계속 사용할 것입니다.

JSX는 JavaScript의 강력한 기능을 가지고 있습니다. JSX 내부의 중괄호 안에 어떤 JavaScript 표현식도 사용할 수 있습니다. 
React 엘리먼트는 JavaScript 객체이며 변수에 저장하거나 프로그램 여기저기에 전달할 수 있습니다.

ShoppingList 컴포넌트는 <div />와 <li /> 같은 내각 DOM 컴포넌트만을 렌더링하지만 컴포넌트를 조합하여 커스텀 React 컴포넌트를 렌더링하는 것도 
가능합니다. 예를 들어 <ShoppingList />를 작성하여 모든 쇼핑 목록을 참조할 수 있습니다. React 컴포넌트는 캡슐화되어 독립적으로 동작할 수 있습니다. 
이러한 이유로 단순한 컴포넌트를 사용하여 복잡한 UI를 구현할 수 있습니다.
 -->
</body>
</html>