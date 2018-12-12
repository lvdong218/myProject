<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% String basePath = request.getContextPath(); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<%=basePath %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/js/messages_zh.js"></script>

<title>jquery学习</title>
</head>
<body>
 <!-- jquery有校验方法，校验方法为jquery.valudate 还有中文包 -->
 	<form id="form" action="">
 		<input type="text" name="userName" value="" />
 		<input type="password" name="password" value="" />
 		<input type="submit"/>
 	</form>
</body>
<script>
	$(function(){
		$("form").validate({
			rules:{
// 				userName:"required"
				userName:{
					required:true,
					minlength:2
				}
			}
			
			
		})
	})
</script>
</html>