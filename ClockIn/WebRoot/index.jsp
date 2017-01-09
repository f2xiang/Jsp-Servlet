<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Caprice</title>
<link rel="shortcut icon" type="image/x-icon" href="style/images/favicon.png" />
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Amaranth' rel='stylesheet' 

type='text/css'>
<link href='http://fonts.googleapis.com/css?

family=Droid+Serif:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="style/css/ie7.css" media="all" />
<![endif]-->
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="style/css/ie8.css" media="all" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="style/css/ie9.css" media="all" />
<![endif]-->
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
	<%
  		String name=(String)session.getAttribute("user");
  	 %>
<!-- Begin Wrapper -->
<div id="wrapper">
	<!-- Begin Sidebar -->
	<div id="sidebar">
		 <div id="logo">  　　　<img src="image/xiaoren10.png" width="120" height="143"></div>
		 
	<!-- Begin Menu -->
    <div id="menu" class="menu-v">
      <ul>
        <li><a href="love_gy_gyal.jsp" class="active">首页</a>
        </li>
        <li><a>员工管理</a>
        	<ul>
        		<li><a href="user/insertEmp.jsp" target="centeriframe">添加员工信息</a></li>
        	</ul>
        </li>
        <li><a>考勤管理</a>
        	<ul>
        		<li><a href="user/selectAttendace.jsp"target="centeriframe">考勤信息查询</a></li>
        	</ul>
        </li>
        <li><a>信息管理</a>
        	<ul>
        		<li><a href="user/changedept.jsp"target="centeriframe">部门信息设置</a></li>
        		<li><a href="user/changeWork.jsp"target="centeriframe">职位类别设置</a></li>
        	</ul>
        </li>
      <li><a>系统管理</a>
        	<ul>
        		<li><a href="user/changePassword.jsp"target="centeriframe">修改密码</a></li>
        		<li><a href="SystemFunction.jsp"target="centeriframe">关于系统信息</a></li>
        	</ul>
        	 <li><a href="login.jsp" class="active">退出</a>
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

		<div >欢迎管理员<%=name %>
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
<!-- <![endif]-->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?

id=155540&web_id=155540' language='JavaScript' 

charset='gb2312'></script></div>
</body>
</html>