<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import= "com.ljs.service.*" import= "com.ljs.service.impl.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>



<script>

function deleteRow(t)
{
	if(confirm("确定删除吗"))
	{
		var row = t.parentNode.parentNode;
		var va = t.nextSibling;
		document.getElementById("t1").deleteRow(row.rowIndex);
		window.location.href="delete?id="+va.value; 
	}
	
}



var xmlhttprequest = null;

function createXmlHttpRequest()
{
	//创建xmlhttprequest;根据浏览器不同创建方式不同
	if(window.ActiveXObject)//ie5或者ie6
	{
		xmlhttprequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest)//其他浏览器创建方式
	{
		xmlhttprequest = new XMLHttpRequest();
	}	
}

function showUser()
{
	var t1 = document.getElementById("t1");
	if(t1.rows.length>1)
	{
		for(var i = t1.rows.length-1;i>=1;i--)
		{
			t1.deleteRow(i);
		}	
	}
	 
	var uname = "uname="+document.getElementById("uname").value;
	createXmlHttpRequest();
	//准备请求参数
	xmlhttprequest.open("post","showUser");//post:请求方式  js:请求地址（servlet/jsp）
	//var postStr="uname="+uname; //包装请求参数 
	xmlhttprequest.onreadystatechange = func;
	xmlhttprequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xmlhttprequest.send(uname);//给服务器发送请求
}

function func(){//定义一个方法，供服务调用（方法回调）
	if(xmlhttprequest.readyState ==4){
		if(xmlhttprequest.status == 200)
		{
			var text = xmlhttprequest.responseText;
			var users = window.JSON.parse(text);
			var t1 = document.getElementById("t1");
			for(var i = 0;i<users.length;i++)
			{
				var row = t1.insertRow(i+1);
				var c0 = row.insertCell(0);
				var c1 = row.insertCell(1);
				var c2 = row.insertCell(2);
				var c3 = row.insertCell(3);
				var c4 = row.insertCell(4);
				var c5 = row.insertCell(5);
				c0.innerHTML=users[i].id;
				c1.innerHTML=users[i].uName;
				c2.innerHTML=users[i].uPass;
				c3.innerHTML=users[i].age;
				c4.innerHTML=users[i].phone;
				c5.innerHTML="<a href='delete?id="+users[i].id+"'>删除</a><a href='updateUser?id="+users[i].id+"'>修改</a><input id='shanchu' type='button' value='删除' onclick='deleteRow(this)'/><input type='hidden' value='"+users[i].id+"'/>";
			}
		}
	}
}



</script>


</head>
<body>
<%
com.ljs.model.User user = (com.ljs.model.User)session.getAttribute("user"); 
%>
欢迎<%=user.getuName()%>登录,<a href="update.jsp">个人信息修改</a><a href="loginout.jsp">退出登录</a>
<br>
<br>
输入用户名<input type="text" id="uname"/> 
<input type="button" value="查询" onclick="showUser()">
----------------------------------------------------------------------

<table border="1px" id = "t1">
	<tr>
		<td style="width:60px">用户id</td><td style="width:100px">用户名称</td><td  style="width:100px">用户密码</td><td  style="width:60px">年龄</td><td  style="width:60px">电话</td><td  style="width:200px">操作</td>
	</tr>
	
</table>



</body>
</html>