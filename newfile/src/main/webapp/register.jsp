<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String basePath = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/layui/css/layui.css"/>
<script type="text/javascript" src="<%=basePath %>/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath %>/jquery-3.3.1.min.js"></script>
<title>注册界面</title>
<style>
	.divInput{
		width:50%
	}
</style>
</head>
<body>
	<form class="layui-form" action="" style="margin-top:20px;">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block divInput">
				<input type="text" maxlength="12" name="name" required  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码框</label>
			<div class="layui-input-block divInput">
				<input type="password" name="password" maxlength="32" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">重复密码</label>
			<div class="layui-input-block divInput">
				<input type="password" name="refPassword" maxlength="32" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block ">
				<input type="radio" name="sex" value="0" title="男" checked>
				<input type="radio" name="sex" value="1" title="女" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-block divInput">
				<input type="text" name="phone" required  lay-verify="required|phone" placeholder="手机号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">邮箱</label>
			<div class="layui-input-block divInput">
				<input type="text" name="email" required  lay-verify="required|email" placeholder="邮箱" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
<!-- 			<label class="layui-form-label">获取激活码</label> -->
			<span onclick="getActiveCode();" class="active layui-btn layui-btn-radius layui-btn-danger layui-form-label" style="width: 100px;margin-left: 6px;">获取激活码</span>
			<div class="layui-input-block divInput">
				<input type="text" name="activateCode" maxlength="6" oninput="value=value.replace(/[^\d]/g,'')" required  lay-verify="required" placeholder="激活码" autocomplete="off" class="layui-input">
<!-- 				<input type="text" name="activateCodeDis" style="display:none"/> -->
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="width:64%;color:#cc9228;">温馨提示：激活码通过邮箱的方式发给您</label>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script>
layui.use('form', function(){
	var form = layui.form;
// 	form.verify({
//         validateActivateCode: function (value) {
//         	var code=$('input[name="activateCode"]').val();
//         	if(!code){
//             		return "请输入正确的激活码";
//            	}
//         }
//     });
	//重置layui样式
	form.render();
	form.on('submit(formDemo)', function(data){
// 		parent().layer.closeAll();
		if($('input[name="password"]').val()!=$('input[name="refPassword"]').val()){
			layer.msg("两次输入密码不一致，请重新输入",{icon:5});
			return false;
		}
		$.ajax({
			url:"user/regiter.do",
			data:$('.layui-form').serialize(),
			type:"POST",
			success:function(data){
				if(data.flag){
					layer.msg("恭喜您注册成功",{icon:1});
					
				}else{
					layer.msg(data.result,{icon:5});
				}
			},
			error:function(){
				layer.msg("系统错误，请联系管理员",{icon:5});
			}
		})
		return false;
	});
	
});
getActiveCode=function(){
	if(!$('input[name="email"]').val()){
		layer.msg("请先输入邮箱",{icon: 5});
		return false;
	}
	$.ajax({
		url:'user/getActivateCode.do',
		type:"POST",
		data:{'email':$('input[name="email"]').val()},
		success:function(result){
// 			var activateCode=${sessionScope.activateCode}+"";
// 			console.log(activateCode);
// 			$('input[name="activateCode"]').val(result.activateCode)
		}
	})
	var time=60;
	var timeId=setInterval(function(){
		time--;
		if(time<1){
			$('.active').css("width","85px");
			$('.active').css("margin-left","18px");
			$('.active').text("重新获取");
			$('.active').css("pointer-events","");
			clearInterval(timeId);
		}else{
			$('.active').css("width","50px");
			$('.active').css("margin-left","50px");
			$('.active').css("pointer-events","none");
			$('.active').text(time+"S");
		}
	}, 1000);
}
</script>
</html>