<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>
<script>
$(document).ready(function(){
	
	$("#btn1").click(function(){
		var t1 = document.getElementById("t1");
		var i1 = $("#i1").val();
		//清空表格
		for(var i=1;1<t1.rows.length;i++)
		{
			t1.deleteRow(t1.rows.length-1);
		}
		/*
		$.getJSON("showUser","uname="+i1,function(result){//[{},{},{}]
			for(var i=0;i<result.length;i++)
			{
				//alert(result[i].uName+"  "+result[i].uPass);
			
				
				//给表格输入数据
				var row =  t1.insertRow(-1);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				cell0.innerHTML=result[i].id;
				cell1.innerHTML=result[i].uName;
				cell2.innerHTML=result[i].uPass;
			}	
		});
		*/
		$.post("showUser","uname="+i1,function(text){
			var result = JSON.parse(text);
			for(var i=0;i<result.length;i++)
			{

				//给表格输入数据
				var row =  t1.insertRow(-1);
				var cell0 = row.insertCell(0);
				var cell1 = row.insertCell(1);
				var cell2 = row.insertCell(2);
				cell0.innerHTML=result[i].id;
				cell1.innerHTML=result[i].uName;
				cell2.innerHTML=result[i].uPass;
			}				
		});
		
	});
	
});
</script>
<style>
#t1{
	border:1px solid red;
	width: 500px;
}

td{
	border: 1px solid red;
	text-align: center
}
.trbg{
	background-color: yellow
}
</style>

</head>
<body>
用户名称：<input type="text" id="i1"/>----<input type="button" id="btn1" value="查询"/>
<br>
<br>
<table id ="t1" border="1" cellspacing="0px" align="center">
	<tr class="trbg" >
		<td>id</td><td>用户名</td><td>用户密码</td>
	</tr>
</table>

</body>
</html>