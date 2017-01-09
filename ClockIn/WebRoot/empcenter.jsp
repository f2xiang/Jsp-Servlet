<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   <fieldset style="width: 60%; font-size: 20px" >
   		<legend>个人信息</legend>
   		 
   		 姓名:${sessionScope.map.name } <br><br>
   		 部门：${sessionScope.map.dname } <br><br>
   		年纪：${sessionScope.map.age }   <br><br>
   		生日：${sessionScope.map.birth }  <br><br>
   		薪水：${sessionScope.map.sal }    <br><br>
   		联系方式：${sessionScope.map.phone }  <br><br>
   		地址：${sessionScope.map.address }  <br><br>
   		
   		<form action="empupdate.jsp">
   			<input type="submit" value="修改个人信息">
   		</form>
   		
   </fieldset>
  </body>
</html>
