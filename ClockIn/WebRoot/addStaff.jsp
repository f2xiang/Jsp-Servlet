<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
    <fieldset>
    	<legend>添加员工</legend>
    	<form action="user.do?uid=7" method="post">
    		${msg } <br>
    		账号：<input type="text" name="uname" > <br>
    		密码：<input type="password" name="pwd" > <br>
    		<input type="submit" value="添加">
    	</form>
    </fieldset>
  </body>
</html>
