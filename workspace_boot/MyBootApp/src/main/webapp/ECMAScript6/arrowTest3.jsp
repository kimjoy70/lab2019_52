<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h1>Arrow Function</h1>
<p>As you can see in this example, you can skip the parentheses when you have only one parameter.</p>
<p id="demo"></p>
<script>
hello = val => "Hello " + val;
document.getElementById("demo").innerHTML = hello("World");
</script>
</body>
</html>