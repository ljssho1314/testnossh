<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录信息</title>
<script src="jquery/jquery-1.8.0.min.js"></script>
<script>
$(document).ready(function(){
	
	$("#zhuce").click(function(){
		window.location.href="regist.jsp";
	});
	
})
</script>
</head>
<body>
<form action="login" method="post">
	<table>
		<tr>
			<td>用户名</td><td><input type="text" name = "uname"/></td>
		</tr>
		<tr>
			<td>密码</td><td><input type="password" name = "upass"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="登录"/><input id="zhuce" type="button" value="注册"/></td>
		</tr>
	</table>
</form>

</body>
</html>