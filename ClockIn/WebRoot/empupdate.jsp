<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   <form action="person.do?pid=2" method="post" style="width: 60%">
   		<input type="hidden" name="p_id"  value="${sessionScope.map.p_id }">
   		姓名：<input type="text" name="name" value="${sessionScope.map.name }"> <br>
   		部门：<input type="text" name="dname" readonly="readonly" value="${sessionScope.map.dname }"> <br>
   		年纪：<input type="text" name="age" value="${sessionScope.map.age }">  <br>
   		生日：<input type="text" name="bir" value="${sessionScope.map.birth }"> <br>
   		薪水：<input type="text" name="sal" value="${sessionScope.map.sal }"> <br>
   		电话：<input type="text" name="phone" value="${sessionScope.map.phone }"> <br>
   		地址：<input type="text" name="address" value="${sessionScope.map.address }"> <br>
   		<input type="submit" value="提交">
   </form>
  </body>
</html>
