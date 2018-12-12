<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = request.getContextPath(); %>
<% String loginStatus = request.getParameter("loginStatus"); %>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" scr="./jquery-3.3.1.min.js"></script> -->
<!-- <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script> -->

<script type="text/javascript" src="<%=basePath %>/jquery-3.3.1.min.js"></script>
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
	<div style="padding-left:47%">
<!-- 		<button id="btn-save" onclick="save();" style="background:url(./img/submit.png)  no-repeat; width:571px;height:188px;"></button> -->
		<button id="btn-save" onclick="save();" style=" width:100px;height:60px;">登陆</button>
	</div>
	
</body>
<script type="text/javascript">
	var save=function(){
		if($('input[name=userName]').val()==''&&$('input[name=passWord]').val()==''){
			alert("请输入用户名和密码");
			return;
		}else if($('input[name=userName]').val()==''){
			alert("请输入用户名");
			return;
		}else if($('input[name=passWord]').val()==''){
			alert("请输入密码");
			return;
		}
		$.ajax({
			url:'login.do',
			context: document.body,
			type:'post',
			data:{username:$('input[name=userName]').val(),password:$('input[name=passWord]').val()},
			success:function(data){
				if(typeof(data.loginUser)!='undefined'){
					window.location.href="<%=basePath %>/index/index.jsp";
				}else if(typeof(data.status)!='undefined'){
					alert("请输入正确的密码");
				}else{
					alert("请输入正确的用户名和密码");
				}
			}
		})
	}
</script>
</html>