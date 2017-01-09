<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   

  </head>
  
  <body>
    <fieldset style="width: 60%">
    <legend>上班打卡</legend>
    <table border="1">
	   <tr>
		   <td width="40%">
		   	  <form action="check.do?cid=1" method="post">
		  		 <input type="submit" style="width:100%;height: 100%; font-size: 100; color: red;" value="上班">
		  	  </form>
		  	</td>
		   <td width="60%">这是上班打卡<br>
		    </td>
	   </tr>
    </table>
  </fieldset>
  <hr>
    <fieldset style="width: 60%">
    <legend>下班打卡</legend>
    <table border="1">
   <tr>
   <td width="40%">
   <form action="check.do?cid=2" method="post">
  		 <input type="submit" style="width:100%;height: 100%; font-size: 100; color: red;" value="下班">
   </form>
   </td>
    <td width="60%">这是下班打卡<br>
      </td>
   </tr>
    </table>
  </fieldset>
    
  </body>
</html>
