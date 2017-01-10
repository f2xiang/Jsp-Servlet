<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    	<fieldset>
    		<legend>设置密码问题</legend>
    		<form action="question.do?qid=2" method="post">
	    		密码问题1：	<input type="text" name="qname" > <br>	<br>
	    		问题答案1：	<input type="text" name="aname" > <br> <br>
	    		密码问题2：	<input type="text" name="qname" > <br> <br>
	    		问题答案2：	<input type="text" name="aname" > <br> <br>
	    		密码问题3：	<input type="text" name="qname" > <br> <br>
	    		问题答案3：	<input type="text" name="aname" > <br> <br>
	    		<input type="submit" value="提交">	
	    		<input type="reset" value="重置">	
    		</form>
    		
    	</fieldset>
  </body>
</html>
