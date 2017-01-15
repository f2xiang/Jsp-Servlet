<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <script type="text/javascript" src="My97DatePicker/WdatePicker.js">
</script> 
 
  </head>
  
  <body>
 
  <fieldset style="width: 60%">
  	<legend>出勤管理</legend>
  	
  		
  		<form action="check.do?cid=5" method="post">
  			<input type="text" name="time"  class="Wdate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',readOnly:true})">
  			<input type="submit" value="查询">
  		</form>
  		
  	
  	   <c:forEach items="${requestScope.list }" var="map">
    	
    	员工编号：${map.u_id }  
    	员工姓名：${map.uname }       <br>
    	上班时间：${map.worktime }   
    	上班类型：${map.worktype }    <br>
    	下班时间：${map.hometime }  
    	下班类型：${map.hometype }
    	
    	<a href="check.do?cid=4&c_id=${map.c_id }">删除</a>
    	<hr>
    	
    </c:forEach>
  	
  </fieldset>
  
 
    
    
    
  </body>
</html>
