<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
  </head>
  
  <body>
   	<fieldset style="width: 60%">
   		<legend>部门管理</legend>
   		
   		<c:forEach items="${requestScope.allDept }" var="dept">
   			<font style="font-size: 22px">${dept.dname }</font>	 
   			<a href="updDeptUI.jsp?dname=${dept.dname }&d_id=${dept.d_id }" >编辑</a>
   			<a href="dept.do?did=4&d_id=${dept.d_id }" >删除</a>
   			<br><br>
   		</c:forEach>
   		
   		
   	</fieldset>
  </body>
</html>
