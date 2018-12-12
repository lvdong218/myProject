<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
	.ulclass :hover{
		cursor: pointer;
		background-color: #ccc;
	}
	.divlist{
		width:150px;
	}
</style>
	<body>
	<div class="divlist">
		<ul class="ulclass">
			<li onclick="indexFunction()">首页</li>
			<li onclick="">查看数据</li>
			<li onclick="">多线程</li>
			<li onclick="">three</li>
		</ul>
	</div>
		<div>
			<a href="http://www.baidu.com" target="_blank">百度</a>
			<a href="http://www.baidu.com" target="_self">百度</a>
		</div>
	</body>
	<script type="text/javascript">
		function indexFunction(){
			alert("首页");
		}
	</script>
</html>
