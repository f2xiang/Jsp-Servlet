<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Caprice</title>
<link rel="shortcut icon" type="image/x-icon" href="style/images/favicon.png" />
<link rel="stylesheet" type="text/css" href="style.css" media="all" />


<script type="text/javascript" src="style/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/jquery.jcarousel.js"></script>
<script type="text/javascript" src="style/js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="style/js/carousel.js"></script>
<script type="text/javascript" src="style/js/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="style/js/jquery.masonry.min.js"></script>
<script type="text/javascript" src="style/js/jquery.slickforms.js"></script>
</head>

<body>  	
	
<div id="wrapper">
	<!-- Begin Sidebar -->
	<div id="sidebar">
		 <div id="logo">  　
		 　<a href="upLogo.jsp"><img src="image/xiaoren10.png" width="120" height="143" style="cursor: pointer;"></a>
		 </div>
		 
	<!-- Begin Menu -->
    <div id="menu" class="menu-v">
      <ul>
        <li><a href="SystemFunction.jsp" target="centeriframe" class="active">首页</a>
        </li>
        <li><a>员工管理</a>
        	<ul>
        		<li><a href="addStaff.jsp" target="centeriframe">添加员工</a></li>
        		<li><a href="user.do?uid=6" target="centeriframe">员工管理</a></li>
        	</ul>
        </li>
        <li><a>考勤管理</a>
        	<ul>
        		<li><a href="user/selectAttendace.jsp"target="centeriframe">考勤信息查询</a></li>
        	</ul>
        </li>
        <li><a>信息管理</a>
        	<ul>
        		<li><a href="addDept.jsp"target="centeriframe">添加部门</a></li>
        		<li><a href="dept.do?did=2"target="centeriframe">部门管理</a></li>
        	</ul>
        </li>
      <li><a>系统管理</a>
        	<ul>
        		<li><a href="changePassword.jsp"target="centeriframe">修改密码</a></li>
        	</ul>
        	 <li><a href="user.do?uid=2" class="active">退出</a>
        </li>
        </ul>
        </li>
    </div>
    <!-- End Menu -->
   
    
    <div class="sidebox">
    <ul class="share">
    	<li><a href="#"><img src="style/images/icon-rss.png" alt="RSS" 

/></a></li>
    	<li><a href="#"><img src="style/images/icon-facebook.png" 

alt="Facebook" /></a></li>
    	<li><a href="#"><img src="style/images/icon-twitter.png" alt="Twitter" 

/></a></li>
    	<li><a href="#"><img src="style/images/icon-dribbble.png" 

alt="Dribbble" /></a></li>
    	<li><a href="#"><img src="style/images/icon-linkedin.png" 

alt="LinkedIn" /></a></li>
    </ul>
    </div>

    
	</div>
	<!-- End Sidebar -->
	
	<!-- Begin Content -->
	<div id="content">
	<h1 class="title">Welcome</h1>
	
	<!-- Begin Slider -->

		<div >
		<p align="right" >欢迎管理员:${sessionScope.user.uname }  </p> 
	<iframe style="width:970px; height:500px;"  name="centeriframe" src="SystemFunction.jsp" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>
	  </div>
	<!-- Begin Footer -->
    <!-- End Footer -->
    
    
	</div>
	<!-- End Content -->
	
</div>
<!-- End Wrapper -->
<div class="clear"></div>
<script type="text/javascript" src="style/js/scripts.js"></script>
<!--[if !IE]> -->
<script type="text/javascript" src="style/js/jquery.corner.js"></script>

</body>
</html>