<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
<%
com.ljs.model.User user=(com.ljs.model.User)session.getAttribute("user");

%>
<form action="update" method="post">
	<input type="hidden" name = "userid" value="<%=user.getId()%>"/>
	<table>
		<tr>
			<td>姓名</td><td><input type="text" name = "uname" value="<%=user.getuName()%>"/></td>
		</tr>
		<tr>
			<td>密码</td><td><input type="text" name = "upass" value="<%=user.getuPass()%>"/></td>
		</tr>
		<tr>
			<td>年龄</td><td><input type="text" name ="age"  value="<%=user.getAge()%>"/></td>
		</tr>
		<tr>
			<td>联系电话</td><td><input type = "text" name = "phone"  value="<%=user.getPhone()%>"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>