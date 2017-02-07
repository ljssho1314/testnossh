<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<%

com.ljs.service.UserService us = new com.ljs.service.impl.UserServiceImpl();
com.ljs.model.User u = new com.ljs.model.User();
u.setId(Integer.parseInt(request.getParameter("id")));
boolean bool = us.removeUser(u);
if(bool)
{
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<%
}


%>
</body>
</html>