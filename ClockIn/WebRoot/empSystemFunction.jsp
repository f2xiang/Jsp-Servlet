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
    		<dt  style="font-size: 28px;">ϵͳ���ܽ���</dt>
    		<dd>1.	Ա���ϰ�ǩ�������ڹ涨ʱ��7-10���ڣ���ǩ�������ظ�������</dd>
    		</br>
    		<dd>2.  Ա���°�ǩ�ˣ����ڹ涨ʱ��16-22���ڣ���ǩ�������ظ�����,</br>��û���ϰ�򿨣���ִ�д˲�����</dd>
    		</br>
    		<dd>3.  ϵͳ��������Ա��Ա�������޸����롣</dd>
    	</dl>
    	</br>
    </form>
    <div style="width: 980px;text-align: center;font-family:'����'">
    	    
    		<span>�����޸������������xxxxxxxxx@qq.com</span>
    </div>
  </body>
</html>
