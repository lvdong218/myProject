<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" scr="./js/jquery-3.3.1.min.js"></script> -->
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<title>登陆</title>
<style>
	body{
		background-image: url(./img/back-img.jpg);
	}
</style>
</head>
<body>
	<form action="" >
		<table align="center" style="padding-top:200px;">
			<tr >
				<td align="center" style="color:white;">登录名:</td>
				<td align="center"><input name="userName" style="width:160px;height:36px;" value=""></td>
			</tr>
			<tr>
				<td style="color:white;"> 密码:</td>
				<td><input type="password" name="passWord" style="width:160px;height:36px;"></td>
			</tr>
		</table>
	</form>
	<div style="padding-left:30%">
		<button id="btn-save" onclick="save();" style="background:url(./img/submit.png)  no-repeat; width:571px;height:188px;"></button>
	</div>
	
</body>
<script type="text/javascript">
	var save=function(){
		$.ajax({
			url:'http://localhost:8080/project/login.do',
			context: document.body,
			type:'post',
			success:function(data){
				console.log("data"+data.body);
				alert("登陆成功");
			}
		})
	}
</script>
</html>