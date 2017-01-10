<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <form action="question.do?qid=3" method="post">
  		<font color="red">${msg }</font>
	  	<c:forEach items="${requestScope.list }" var="question">
	  		问题：${question.qname } <br><br>
	  		答案：<input type="text" name="aname"> <br><br>
	  	</c:forEach>
	  	
	  	<input type="submit" value="提交">
  	</form>
  </body>
</html>
