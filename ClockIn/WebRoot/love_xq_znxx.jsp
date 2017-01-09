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
	
<!-- Begin Wrapper -->
<div id="wrapper">
	<!-- Begin Sidebar -->
	<div id="sidebar">
		 <div id="logo">  　　<img src="image/xiaoren10.png" width="120" height="143"></div>
		 
	<!-- Begin Menu -->
     <div id="menu" class="menu-v">
      <ul>
        <li><a href="empSystemFunction.jsp" target="centeriframe" class="active">首页</a>
        </li>
        <li><a>考勤登记</a>
        	<ul>
        		<li><a href="daka.jsp" target="centeriframe">打卡操作</a></li>
        	</ul>
        </li>
        <li><a>个人信息</a>
        	<ul>
        		<li><a href="person.do?pid=1" target="centeriframe">个人信息</a></li>
        	</ul>
        </li>
      <li><a>系统管理</a>
        	<ul>
        		<li><a href="changePassword.jsp"target="centeriframe">修改密码</a></li>
        		<li><a href="emp/changePassword.jsp"target="centeriframe">设置密码问题</a></li>
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

		<div >欢迎进入系统  :${sessionScope.user.uname }
	<iframe style="width:970px; height:500px;"  name="centeriframe" src="empSystemFunction.jsp" frameborder="0" scrolling="no"></iframe>
		</div>
	</div>
	  </div>
	
    
    
	</div>
	
	
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