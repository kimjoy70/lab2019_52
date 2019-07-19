<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
class Car{
	constructor(name){
		this.brand = name;
	}
	present(){
		return 'I have a ' + this.brand;
	}
}

mycar = new Car("Ford");

document.write(mycar.present());
</script>
</body>
</html>