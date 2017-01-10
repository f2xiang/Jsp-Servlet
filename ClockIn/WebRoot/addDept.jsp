<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   

  </head>
  
  <body>
  <fieldset style="width: 60%">
  		<legend>添加部门</legend>
  		<div align="center">
  			${msg }<br>
	    	<form action="dept.do?did=1" method="post">
	    		部门名称：<input type="text" name="dname" value="${param.dname }">
	    		<input type="submit" value="添加">
	    	</form>
    	</div>
   </fieldset>
  </body>
</html>
