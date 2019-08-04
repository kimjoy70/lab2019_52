<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
변수
ES6 이전에는 var키워드를 사용 하여 변수를 정의하는 유일한 방법이있었습니다 . 정의하지 않으면 전역 객체에 할당됩니다. 엄격 모드가 아니면 변수가 정의되지 않은 경우 오류가 발생합니다.

이제 ES6으로, 거기 변수를 정의하는 세 가지 방법은 다음과 같습니다 : var, let,와 const.

var
var x = 5.6;

var함수 외부에서 사용할 경우 전역 범위에 속합니다.

var함수 내부에서 사용할 경우 해당 함수에 속합니다.

당신이 사용하는 경우 var블록의 내부에, for 루프, 변수가 여전히 블록의 외부에서 사용할 수 있습니다 즉.

var갖는 기능 영역이 아닌 블록 범위.

방해
let x = 5.6;

let갖는 블록 범위.

let는 블록 범위 버전이며 var, 정의 된 블록 (또는 표현식)으로 제한됩니다.

당신이 사용하는 경우 letfor 루프 즉, 블록의 내부 변수는 루프의 내부에서만 사용할 수 있습니다.

const
const x = 5.6;

const 일단 만들어지면 그 값은 절대로 바뀔 수없는 변수입니다.

const갖는 블록 범위.
</p>
</body>
</html>