<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>考勤管理系统首页</title>
	
	<script type="text/javascript">
		function checkForm(){
			//非空校验
			var username = document.getElementsByName("uname")[0].value;
			if(username == null || username == ""){
				alert("用户名不能为空");
				return false;
			}
			
			var password = document.getElementsByName("pwd")[0].value;
			if(password == null || password == ""){
				alert("密码不能为空");
				return false;
			}
			
			return true;
		}
		
		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
	</script>
	
  	

  </head>
  
  <body style="background-image: url('image/ymbj.jpg');margin: 0px auto;text-align: center">
    <div style="width:1300px; height:100px; font-size: 56px; margin-top: 30px; font-family: '微软雅黑'; align=; font-weight: bold;"center"">
      <p>&nbsp;</p>
      <p>考　勤　管　理　系　统</p>
    </div>
    <div style="width:1300px; height: 100px; margin-top: 50px; font-family: '微软雅黑'; font-size: 28px; font-weight: bold;" align="center">
  <form name="form1" action="user.do?uid=1" method="post" onSubmit="return checkForm()">
    		<p>&nbsp;</p>
   		<font size="3px" color="red"> ${msg }</font>	
   <table  align="center">
  			  <tr>
   				<td width="50">姓 名 :</td>
    			<td width="150" height="40"><input type="text" name="uname" value="${param.uname }"></td>
	 		 </tr>
    			<tr>
   				  <td>密 码 :</td>
    				<td width="150" height="40"><input type="password" name="pwd"></td>
    			</tr>
    			<tr>
   				  <td>验证码:</td>
    				<td width="150" height="40"><input type="text" name="vali"></td>
    			<td>	<img src="${pageContext.request.contextPath }/ValiImg" style="cursor: pointer" onclick="changeImg(this)"/></td>
    			</tr>
    			<tr>
    			<td> </td>
    				<td width="150" height="40"><input type="submit" value="登陆">
    				  &nbsp;  &nbsp; &nbsp;
    				  <input type="reset" value="重置"></td>
    				<td>   <a href="pwdBack.jsp">找回密码</a></td>
    				
    			</tr>
    		</table>
    	</form>
    </div>
    <div style="width:1300px; height:50px; margin-top: 130px; font-family: '微软雅黑'; font-size: 22px;" align="center">
    	<span><b>欢 迎 登 陆  系 统， 竭 诚 为 您 服 务 ！</b></span>
</div>
</body>
</html>
