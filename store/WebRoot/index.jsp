<%@page import="com.tjrac.domain.Product"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   	<h1>网上商城</h1>
   	<c:if test="${sessionScope.user == null }">
   		欢迎光临， 游客 
   		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
   		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
   	</c:if>
   	<c:if test="${sessionScope.user != null }">
   		欢迎回来，${sessionScope.user.username }
   		<a href="car.jsp">我的购物车</a>
   		<a href="OrderListServlet">我的订单</a>
   		<a href="${pageContext.request.contextPath }/LogoutServlet">注销</a>
   	</c:if>
   	
   	<br><hr>
   	<!-- 展示商品 -->
   	
   <%
   		List<Product> list = (List<Product>)request.getAttribute("allProducts");
    	if(list == null){
    		response.sendRedirect(request.getContextPath()+"/ProdListServlet");
    		return;
    	}else{
    %>
   	
   	<table border="1" width="70%">
   		<tr>
   			<th>图片 </th>
   			<th>商品名称</th>
   			<th>价格</th>
   			<th>分类</th>
   			<th>库存</th>
   		</tr>
   		<c:forEach items="${requestScope.allProducts }" var="prod">
   			<tr align="center">
	   			<td><a href="${pageContext.request.contextPath }/ProdInfoServlet?id=${prod.id }"><img src="${prod.imgurl }" style="cursor: pointer;"> </a></td>
	   			<td>${prod.name }</td>
	   			<td>${prod.price } </td>
	   			<td>${prod.category } </td>
	   			<td>${prod.pnum }
		   			<c:if test="${prod.pnum > 0}">
		   				<font color="blue">有货</font> 
		   			</c:if>
		   			<c:if test="${prod.pnum <= 0}">
		   				<font color="red">缺货</font> 
		   			</c:if>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	<%} %>
  </body>
</html>
