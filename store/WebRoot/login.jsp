<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
    	
    	${msg }
    	�û�����<input type="text" name="uname"> <br>
    	���룺<input type="password" name="pwd"> <br>
    	<input type="submit" value="��¼"><br>
    </form>
  </body>
</html>
