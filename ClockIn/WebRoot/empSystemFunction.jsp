<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SystemFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form id="form1" style="font-size: 20px;">
    	<dl>
    		<dt  style="font-size: 28px;">系统功能介绍</dt>
    		<dd>1.	员工上班签到，需在规定时间7-10点内，若签过，则不重复操作。</dd>
    		</br>
    		<dd>2.  员工下班签退，需在规定时间16-22点内，若签过，则不重复操作,</br>若没有上班打卡，则不执行此操作。</dd>
    		</br>
    		<dd>3.  系统管理：管理员或员工可以修改密码。</dd>
    	</dl>
    	</br>
    </form>
    <div style="width: 980px;text-align: center;font-family:'黑体'">
    	    
    		<span>如有修改意见，发送至xxxxxxxxx@qq.com</span>
    </div>
  </body>
</html>
