<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
		function changeImg(img){
			img.src = img.src+"?time="+new Date().getTime();
		}
		
		function checkForm(){
			//非空校验
			var username = document.getElementsByName("username")[0].value;
			if(username == null || username == ""){
				alert("用户名不能为空");
				return false;
			}
			
			var password = document.getElementsByName("password")[0].value;
			if(password == null || password == ""){
				alert("密码不能为空");
				return false;
			}
			
			//两次密码一致
			var password2 = document.getElementsByName("password2")[0].value;
			if(password != password2){
				alert("两次密码不一致");
				return false;
			}
			
			//邮箱格式校验
			var email = document.getElementsByName("email")[0].value;
			if(!/^\w+@\w+(\.\w+)+$/.test(email)){
				alert("邮箱格式不正确");
				return false;
			}
			
			return true;
			
		}
</script>
  </head>
  
  <body>
  
  	<h1>注册</h1>
   		<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
   			用户名：<input type="text" name="username" value="${param.username }">	<br>
   			密码：<input type="password" name="password"><br>
   			确认密码：<input type="password" name="password2"><br>
   			昵称：<input type="text" name="nickname" value="${param.nickname }"><br>
   			邮箱：<input type="text" name="email" value="${param.email }"><br>
   			验证码：<input type="text" name="valistr">${requestScope.msg }<br>
   			<img src="${pageContext.request.contextPath }/ValiImg" style="cursor: pointer" onclick="changeImg(this)"/>
   			<input type="submit" value="注册" onclick="return checkForm()">
   		</form>
  </body>
</html>
