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
   		<legend>员工信息</legend>
   		
   		<form action="person.do?pid=4" method="post">
   			<input type="hidden" name="p_id" value="${requestScope.map.p_id }">
   			
   			 姓名:<input type="text" name="name" value="${requestScope.map.name }"> <br><br>
   			
   			部门：<select name="d_id" onfocus="showPost(this)">
	   				<c:forEach	items="${requestScope.alldept }" var="dept">
	   					<c:if test="${dept.dname == requestScope.map.dname}">
	   						<option  value="${dept.d_id }" selected="selected">${dept.dname }</option>
	   					</c:if>
	   						<option value="${dept.d_id }" >${dept.dname }</option>
	   				</c:forEach>
   				</select>
   			<br><br>
   			
   			年纪：<input type="text" name="age" value="${requestScope.map.age } ">  <br><br>
   			生日：<input type="text" name="bir" class="Wdate" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',readOnly:true})" value="${requestScope.map.birth }">  <br><br>
   			薪水：<input type="text" name="sal" value="${requestScope.map.sal } ">  <br><br>
   			联系方式：<input type="text" name="phone" value="${requestScope.map.phone }">  <br><br>
   			地址：<input type="text" name="address" value="${requestScope.map.address }">  <br><br>
   			<input type="submit" value="提交">
   			<input type="reset" value="重置">
   		</form>
   		
   	</fieldset>
  </body>
</html>
