<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   	<fieldset style="width: 60%">
   		<legend>密码问题</legend>
   		<!--  已经设置密码问题-->
   		<c:if test="${requestScope.msg == true}">
   			<p>你已经设置过了密码问题  如需修改请联系管理员</p>
   			<c:forEach items="${sessionScope.questionList }" var="question">
   				密码问题：${question.qname } <br> <br>
   				密码答案：******  <br> <br>
   				<hr>
   			</c:forEach>
   		</c:if>
   		
   		<!-- 还没设置密码问题 -->
   		<c:if test="${requestScope.msg == false}">
   			<h4>你还没有设置密码  请    <a href="pwdQues.jsp">点击这里</a>   设置密码问题</h4>
   		</c:if>
 
   	</fieldset>
  </body>
</html>
