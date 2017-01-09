<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  
  	<fieldset>
  		<legend>修改部门</legend>
   		<form action="dept.do?did=3" method="post">
   			<input type="hidden" name="d_id" value="${param.d_id }">
   			<input type="text" name="dname" value="${param.dname }">
   			<input type="submit" value="修改">
   		</form>
  	</fieldset>
  </body>
</html>
