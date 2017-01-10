<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 

  </head>
  
  <body>
 <h2>找回密码</h2>
   	<form action="user.do?uid=4" method="post" >
   		<font color="red"> ${msg }</font> <br>
   		请输入用户名:<input type="text" name="uname"><br>
   		<input type="submit" value="提交">
   	</form>
   	
  </body>
</html>
