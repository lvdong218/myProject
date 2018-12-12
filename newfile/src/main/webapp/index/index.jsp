<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String basePath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="<%=basePath %>/jquery-3.3.1.min.js"></script>
<style>
	.ulclass :hover{
		cursor: pointer;
		background-color: #c9e8eb;
	}
	.ulclass{
	}
	.divlist{
		width:150px;
		display: inline-block;
	}
</style>
	<body>
	<div class="divlist">
		<ul class="ulclass" style="">
			<li onclick="indexFunction(0)">首页</li>
			<li onclick="indexFunction(1)">查看数据</li>
			<li onclick="indexFunction(2)">多线程</li>
			<li onclick="indexFunction(3)">three</li>
		</ul>
	</div>
	<div style="display: inline-block;margin-top:20px;position: absolute;">
		<div id="div0">
			<a href="http://www.baidu.com" target="_blank">百度</a>
			<a href="http://www.baidu.com" target="_self">百度</a>
		</div>
		<div id="div1">
			<table>
				<tr>
					<td>栏目</td>
					<td><input name=""></td>
				</tr>
			</table>
		</div>
		<div id="div2">
			<label>选项</label>
			<p>1111</p>
		</div>
	</div>
	</body>
	<script type="text/javascript">
		for(var i=0;i<$("div div").length;i++){
			if(i==0){
				$('#div'+i).css("display","block");
			}else{
				$('#div'+i).css("display","none");
			}
			
		}
		function indexFunction(num){
			for(var i=0;i<$("div div").length;i++){
				if(i==num){
					$('#div'+i).css("display","block");
				}else{
					$('#div'+i).css("display","none");
				}
				
			}
		}
	</script>
</html>
