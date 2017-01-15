<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   	<fieldset style="width: 60%">
   		<legend>员工管理</legend>
   		
   		<form action="person.do?pid=5" method="post">
   			姓名：<input type="text" name="name" value="${param.name }">
   			部门：<select name="d_id">
   					<option value="0">--请输入--</option>
   				<c:forEach items="${sessionScope.allDept }" var="dept">
   					<c:if test="${dept.d_id == param.d_id }">
   						<option value="${dept.d_id }" selected="selected">${dept.dname }</option>
   					</c:if>
   					<c:if test="${dept.d_id != param.d_id }">
   						<option value="${dept.d_id }" >${dept.dname }</option>
   					</c:if>
   				</c:forEach>
   			</select>
   			<input type="submit" value="查询">
   		</form>
   		<hr>
   		
   		<c:forEach items="${sessionScope.ulist }" var="user">
   			员工编号：${user.u_id } <br><br>
   			员工姓名：${user.uname } <br><br>
   			员工密码：${user.pwd } <br><br>
   			<a href="user.do?uid=8&u_id=${user.u_id }">初始化密码</a>
   			<a href="user.do?uid=9&u_id=${user.u_id }">删除</a>
   			<a href="person.do?pid=3&u_id=${user.u_id }">员工信息</a>
   			<hr>
   		</c:forEach>
   		
   		<!--  
   		<div align="center">
			<c:choose>
				<c:when test="${page.hasPrePage}">
					<a href="user.do?uid=6&currentPage=1">首页</a> | 
					<a href="user.do?uid=6&currentPage=${page.currentPage -1 }">上一页</a>
				</c:when>
				<c:otherwise>
					首页 | 上一页
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage}">
					<a href="user.do?uid=6&currentPage=${page.currentPage + 1 }">下一页</a> | 
					<a href="user.do?uid=6&currentPage=${page.totalPage }">尾页</a>
				</c:when>
				<c:otherwise>
					下一页 | 尾页
				</c:otherwise>
			</c:choose>
			当前为第${page.currentPage}页,共${page.totalPage}页
  	</div>    -->
   		
   		
   		
   		<hr>
   		
   		
   		<c:forEach items="${requestScope.personlist }" var="person">
	   		 姓名:${person.name } 
	   		年纪：${person.age }   
	   		生日：${person.birth }  
	   		薪水：${person.sal }    <br>
	   		联系方式：${person.phone }  
	   		地址：${person.address } 
   			<hr>
   		</c:forEach>
   		
   	
   		
   	</fieldset>
  </body>
</html>
