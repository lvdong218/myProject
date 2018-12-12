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
<link rel="stylesheet" type="text/css" href="<%=basePath %>/layui/css/layui.css"/>
<script type="text/javascript" src="<%=basePath %>/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/layui/layui.all.js"></script>

<title>登陆</title>
<style>
	body{
 		background-image: url(./img/indexbackground.jpg); 
	}
	form{
		margin-top:20%;
	}
	.sub{
		margin:10px;
	}
	.loginFont{
		color:white;
		float:left;
		text-align: right;
		padding-top: 20px;
		width:60px;
	    padding-left: 15px;
	}
	.divinput{
	    display: inline-block;
	    position: relative;
	    padding:10px;
        margin-left: -63px;
	}
	.indexFont{
		padding-top: 22px;color:#fbc28d;font-size: 20px;
	}
	.bodyDiv{
		width:30%;margin-left: 39%;margin-top: 15%;background-color: #563524
	}
</style>
</head>
<body>
	<div align="center" class="bodyDiv">
		<div class="indexFont">欢迎来到科技世界</div>
		<div>
			<label class="loginFont">登陆名：</label>
			<div class="divinput">
				<input name="userName" class="layui-input" value="">
			</div>
		</div>
		<div>
			<label class="loginFont">密码：</label>
			<div class="divinput">
				<input type="password" name="passWord" class="layui-input">
			</div>
		</div>
		<div >
			<button id="btn-save" onclick="save();" class="sub layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">登陆</button>
			<button id="btn-register" onclick="register();" class="sub layui-btn layui-btn-lg layui-btn-radius layui-btn-normal">注册</button>
			<button id="btn-mir" >创建</button>
		</div>
	</div>
</body>
<script type="text/javascript">
	var array=new Array();
	//给数组设置值
	array.push('1');
	array.push('123');
	array.push('3');
	//此方法会报错因为没有length()这个方法
// 	console.log("length()"+array.length());
	//输出了array这个数组的长度
	console.log("length:value="+array.length);
	//输出了数组第一个元素的长度
	console.log("length:index=0   value="+array[0].length);
	//输出了数组第二个元素的长度
	console.log("length:index=1   value="+array[1].length);
	//输出数组第二个元素
	console.log("value="+array[1]);
	var save=function(){
		if($('input[name=userName]').val()==''&&$('input[name=passWord]').val()==''){
			layer.msg("请输入用户名和密码",{icon: 5});
			return;
		}else if($('input[name=userName]').val()==''){
			layer.msg("请输入用户名",{icon: 5});
			return;
		}else if($('input[name=passWord]').val()==''){
			layer.msg("请输入密码",{icon: 5});
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
					layer.msg("请输入正确的密码",{icon: 5});
				}else{
					layer.msg("请输入正确的用户名和密码",{icon: 5});
				}
			}
		})
	}
	register=function(){
		layer.open({
			type: 2, 
			title:'注册界面',
			area: ['500px', '540px'],
			anim: 2,
			content: './register.jsp' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
		});
	}
	$('#btn-mir').on('click',function(){
		$.ajax({
			url:'mkdirs.do',
			type:'post',
			success:function(data){
				alert("创建成功")
			}
		})
	})
</script>
</html>