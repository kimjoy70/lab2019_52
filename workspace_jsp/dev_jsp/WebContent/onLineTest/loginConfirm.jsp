<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
로그인 해야 이용할 수 있습니다.
<script type="text/javascript">
$.messager.confirm('Confirm','로그인 해야 이용할 수 있습니다.',function(r){
    if (r){
        alert('ok');
        
    }
});
</script>
</body>
</html>