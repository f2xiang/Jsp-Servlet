<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  </head>
  
  <body>
  
  <fieldset>
  	<legend>修改头像</legend>
  	
   	<form action="user.do?uid=10" method="post" enctype="multipart/form-data">
   		请选择头像：<input type="file" name="logo">
   		 <input type="submit" value="上传">
   	</form>
  	
  </fieldset>
  </body>
</html>
