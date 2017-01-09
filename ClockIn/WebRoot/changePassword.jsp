<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type="text/javascript">
		function checkForm(){
			//非空校验
			var oldpsw = document.getElementsByName("pwd")[0].value;
			if(oldpsw == null || oldpsw == ""){
				alert("原始密码不能为空");
				return false;
			}
			
			var newpwd = document.getElementsByName("newPassword")[0].value;
			if(newpwd == null || newpwd == ""){
				alert("新密码不能为空");
				return false;
			}
			
			var cpwd = document.getElementsByName("confrimPassword")[0].value;
			if(cpwd == null || cpwd == ""){
				alert("确认密码不能为空");
				return false;
			}
			
			return true;
		}
	</script>
  </head>
  
  <body>
 
    <fieldset>
    	<legend>修改密码操作</legend>
    	<form action="user.do?uid=3" method="post" onsubmit="return checkForm()">
    		<table  bgcolor="#A6F4FD" border="1" bordercolor="#FFFFFF" >  
    			${msg }
    			<tr>
    				<td>原密码</td>
    				<td><input type="password" name="pwd"></td>
    				<td>
    					
    				</td>
    			</tr>
    			<tr>
    				<td>新密码</td>
    				<td><input type="password" name="newPassword"></td>
    			</tr>
    			<tr>
    				<td>确认密码</td>
    				<td><input type="password" name="confrimPassword"></td>
    				<td>
    					
    				</td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="submit" value="确认"><input type="reset" value="重置"></td>
    			</tr>
    		</table>
    	</form>
    </fieldset>
  </body>
</html>
