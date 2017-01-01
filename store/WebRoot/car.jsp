<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function changeNum(id, buynum){
  			window.location.href="ChangeCarServlet?id="+id+"&buynum="+buynum;
  		}
  	</script>
  </head>
  
  <body>
  	<h1>我的购物车</h1>
  	<div align="right">
	  	<a href="index.jsp">继续购物</a> <br>
	  	<a href="ClearCarServlet">清空购物车</a>  		
  	</div>
   	<c:if test="${empty sessionScope.carmap }">
   		<h2>
   			<a href="${pageContext.request.contextPath }/index.jsp">购物车空空如也 先去买点东西吧</a> 
   		</h2>
   	</c:if>
   	<c:if test="${not empty sessionScope.carmap }">
   		<table width="100%" border="1">
   			<tr>
   				<th>缩略图</th>
   				<th>商品名称</th>
   				<th>单价</th>
   				<th>种类</th>
   				<th>库存状态</th>
   				<th>购买数量</th>
   				<th>总价</th>
   				<th>删除</th>
   			</tr>
   			<c:set var="money" value="0"></c:set>
   			<c:forEach items="${sessionScope.carmap }" var="entry">
   				<tr>
   					<td> <img src="${entry.key.imgurl }"> </td>
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
   					<td> <input type="text" value="${entry.value }" style="width: 30px" onchange="changeNum('${entry.key.id}', this.value)">件  </td>
   					<td>${entry.value * entry.key.price }元
   						<c:set var="money" value="${money + entry.value * entry.key.price }"></c:set>
   					</td>
   					<td>
   						<a href="${pageContext.request.contextPath }/DelCarServlet?id=${entry.key.id}">删除</a>
   					</td>
   				</tr>
   			</c:forEach>
   		</table>
   		
   		<div align="right" style="font-size: 30px; color: red;">
   			总价：${money }元 <br>
   			<a href="addOrder.jsp">
   				<img  src="img/gotoorder.bmp" style="cursor: pointer;">
   			</a>
   		</div>
   		
   	</c:if>
  </body>
</html>
