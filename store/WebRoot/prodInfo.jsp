<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   	
   <h1>${prod.name }</h1>
   <table width="50%" border="1">
   		<tr>
   			<th>图片 </th>
   			<th>商品名称</th>
   			<th>价格</th>
   			<th>分类</th>
   			<th>库存</th>
   			<th>商品描述</th>
   		</tr>
   		<tr>
   			<td>
   				<img  src="${prod.imgurl }" >
   			</td>
   			<td>${prod.name }</td>
   			<td>${prod.price }</td>
   			<td>${prod.category }</td>
   			<td>${prod.pnum }</td>
   			<td>${prod.description }</td>
   		</tr>
   </table>
   		<br>
   		<a href="${pageContext.request.contextPath }/AddCarServlet?id=${prod.id }">
   			<img align="right" alt="${prod.name }" src="${pageContext.request.contextPath }/img/buy.bmp" style="cursor: pointer;">
  		</a>
  </body>
</html>
