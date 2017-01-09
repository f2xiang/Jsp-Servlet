<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'punch_clock.jsp' starting page</title>
   

  </head>
  
  <body>
  <%
  	String excep1=(String)request.getAttribute("excep1");
  	String excep2=(String)request.getAttribute("excep2");
  	String excep3=(String)request.getAttribute("excep3");
  	String excep4=(String)request.getAttribute("excep4");
  	String excep5=(String)request.getAttribute("excep5");
   %>
    
    	<legend>上班打卡操作</legend>
    	<form action="<%=path %>/servlet/punchClockServlet/ff?methodName=up" method="post">
    		<table>
    			<tr>
    				<td rowspan="3"><input type="submit" style="background-image: url('image/4.png');width: 125px;height:125px;" value=""></td>
    				<td><span style="font-family: fantasy;font-size: 20px;">亲爱的，点击我就可以打卡上班了\(^o^)/~</span></td>
    			</tr>
    			<tr>
    				<td>
    					<%
    						if(excep1!=null){
    							out.print(excep1);
    						}
    					 %>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<%
    						if(excep2!=null){
    							out.print(excep2);
    						}
    					 %>
    				</td>
    			</tr>
    		</table>
    	</form>
    
    <fieldset>
    	<legend>下班打卡操作</legend>
    	<form action="<%=path %>/servlet/punchClockServlet/ff?methodName=down" method="post">
    		<table>
    			<tr>
    				<td rowspan="3"><input type="submit" style="background-image: url('image/0.png');width: 125px;height:125px;" value=""></td>
    				<td><span style="font-family: fantasy;font-size: 20px;">亲爱的，点击我就可以打卡下班了\(^o^)/~</span></td>
    			</tr>
    			<tr>
    				<td>
    					<%
    						if(excep3!=null){
    							out.print(excep3);
    						}
    					 %>
    				</td>
    			</tr>
    			<tr>
    				<td>
    					<%
    						if(excep4!=null){
    							out.print(excep4);
    						}
    						if(excep5!=null){
    							out.print(excep5);
    						}
    					 %>
    				</td>
    			</tr>
    		</table>
    	</form>
    </fieldset>
  </body>
</html>
