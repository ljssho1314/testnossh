<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">

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

function checkUserExists()
{
	var uname = document.getElementById("uname").value;
	createXmlHttpRequest();
	//准备请求参数
	xmlhttprequest.open("post","checkUser");//post:请求方式  js:请求地址（servlet/jsp）
	var postStr="uname="+uname; //包装请求参数 
	xmlhttprequest.onreadystatechange = func;
	xmlhttprequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xmlhttprequest.send(postStr);//给服务器发送请求
}

function func(){//定义一个方法，供服务调用（方法回调）
	if(xmlhttprequest.readyState ==4){
		if(xmlhttprequest.status == 200)
		{
			var text = xmlhttprequest.responseText;
			alert(text);
			if(text.trim()=="no")
			{
				document.getElementById("div1").style.display = "block";
				document.getElementById("uname").value="";
				document.getElementById("uname").focus();
			}else
			{
				document.getElementById("div1").style.display = "none";
			}
			
		}
	}
}


window.onload = function(){
	document.getElementById("uname").onblur = checkUserExists;
}

</script>
</head>
<body>

<form action="regist" method="post">
	<table>
		<tr>
			<td>姓名</td><td><input type="text" name = "uname" id = "uname"/></td><td><div style="color:red;display:none;width:200px" id="div1">名字已经存在</div></td>
		</tr>
		<tr>
			<td>密码</td><td><input type="password" name = "upass"/></td>
		</tr>
		<tr>
			<td>年龄</td><td><input type="text" name ="age"/></td>
		</tr>
		<tr>
			<td>联系电话</td><td><input type = "text" name = "phone"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
		</tr>
	</table>
</form>
</body>
</html>