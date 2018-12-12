<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String basePath = request.getContextPath(); %>
<html>
<script type="text/javascript" src="<%=basePath %>/jquery-3.3.1.min.js"></script>
	<frameset cols="25%,*" >
		<frame src="./functionList.jsp" >
		</frame>
			<frameset rows="25%,*" >
				<frame src="./index.jsp"></frame>
				<frame src="../index.jsp" name="rightSencond"></frame>
			</frameset>
	</frameset>
</html>
