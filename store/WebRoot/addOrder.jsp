<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
    <h1>订单页面</h1>
    <hr>
    
    <form action="AddOrderServlet" method="post">
    	收货地址:<textarea rows="5" cols="45" name="receiverinfo"></textarea><br>
    	支付方式：<input type="radio" name="typex" checked="checked">在线支付<br>
    	<input type="submit" value="生成订单">
    </form>
    	购物清单：
    	<table width="100%" border="1">
   			<tr>
   				<th>商品名称</th>
   				<th>单价</th>
   				<th>种类</th>
   				<th>库存状态</th>
   				<th>购买数量</th>
   				<th>总价</th>
   			</tr>
   			<c:set var="money" value="0"></c:set>
   			<c:forEach items="${sessionScope.carmap }" var="entry">
   				<tr>
   					<td>${entry.key.name }</td>
   					<td>${entry.key.price }</td>
   					<td>${entry.key.category }</td>
   					<td>
   						<c:if test="${entry.value <= entry.key.pnum }">
   							<font color="blue">有货</font>
   						</c:if>
   						<c:if test="${entry.value > entry.key.pnum }">
   							<font color="red">缺货</font>
   						</c:if>
   					</td>
   					<td> ${entry.value }件  </td>
   					<td>${entry.value * entry.key.price }元
   						<c:set var="money" value="${money + entry.value * entry.key.price }"></c:set>
   					</td>
   				</tr>
   			</c:forEach>
   		</table>
   		<div align="right" style="font-size: 30px; color: red;">
   			总价：${money }元 <br>
   		</div>
  </body>
</html>
