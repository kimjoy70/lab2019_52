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
class Model extends Car{
	constructor(name, mod){
		super(name);
		this.model = mod;
	}
	show(){
		return this.present() + ', it is a '+this.model;
	}
}
mycar = new Model("Ford","Mustang");

document.write(mycar.show());
</script>
</body>
</html>