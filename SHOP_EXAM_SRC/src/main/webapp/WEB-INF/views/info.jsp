<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="exam.user.dto.UserDto" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Contact | E-Shopper</title>
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/price-range.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/animate.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/main.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath() %>/js/html5shiv.js"></script>
    <script src="<%=request.getContextPath() %>/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <style type="text/css">
    .brands-name .nav-stacked li a:hover{
    	color: #fe980f;
    	background: white;
    }
    </style>
<%
	UserDto userDto = (UserDto)session.getAttribute("userDto");
	if(userDto == null){
		userDto = new UserDto();
		%>
		<script type="text/javascript">
			alert("로그인이 필요한 서비스입니다.");
			location.href = "/exam/home.do";
		</script>
		<%
	}
	
%>    

</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href=""><i class="fa fa-envelope"></i> info@domain.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href=""><i class="fa fa-facebook"></i></a></li>
								<li><a href=""><i class="fa fa-twitter"></i></a></li>
								<li><a href=""><i class="fa fa-linkedin"></i></a></li>
								<li><a href=""><i class="fa fa-dribbble"></i></a></li>
								<li><a href=""><i class="fa fa-google-plus"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-md-4 clearfix">
						<div class="logo pull-left">
							<a href="/exam/home.do"><img src="<%=request.getContextPath() %>/images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right clearfix">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="">Canada</a></li>
									<li><a href="">UK</a></li>
								</ul>
							</div>
							
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="">Canadian Dollar</a></li>
									<li><a href="">Pound</a></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- 공통 -->
					<div class="col-md-8 clearfix">
						<div class="shop-menu clearfix pull-right">
							<ul class="nav navbar-nav">
								<li><a href="/exam/info.do"><i class="fa fa-user"></i> INFO</a></li>
								<li><a href=""><i class="fa fa-star"></i> Wish List</a></li>
								<li><a href="/cart/cartList.do"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<%if(userDto.getUser_no() == null){ %>
								<li><a href="/exam/login.do"><i class="fa fa-lock"></i> LogIn</a></li>
								<%}else {%>
								<li><a href="/exam/logout.do"><i class="fa fa-lock"></i> LogOut</a></li>
								<%} %>
							</ul>
						</div>
					</div>
					<!-- // -->
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html">Home</a></li>
								<li><a href="/exam/shop.do">Shop</a></li>
								<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="blog.html">Blog List</a></li>
										<li><a href="blog-single.html">Blog Single</a></li>
                                    </ul>
                                </li> 
								<li><a href="404.html">404</a></li>
								<li><a href="contact-us.html" class="active">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	 
	 <div id="contact-page" class="container">
    	<div class="bg">
	    	<div class="row">    		
	    		<div class="col-sm-12">    			   			
					<h2 class="title text-center">MY ACCOUNT</h2>    			    				    				
					
				</div>
			</div>			 		
		</div>    	
    	<div class="row"> 
   			<div class="col-sm-3">
				<div class="left-sidebar">
					<div class="brands_products"><!--brands_products-->
						<h2>MENU</h2>
						<div class="brands-name">
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#"> 계정 정보</a></li>
								<li><a href="#"> 포인트 정보</a></li>
								<li><a href="#"> 배송지 정보</a></li>
								<li><a href="#"> 결제 정보</a></li>
								<li><a href="#"> 주문 정보</a></li>
								<li><a href="#"> <span class="pull-right">(9)</span>Boudestijn</a></li>
								<li><a href="#"> <span class="pull-right">(4)</span>Rösch creative culture</a></li>
							</ul>
						</div>
					</div><!--/brands_products-->
					
					<div class="shipping text-center"><!--shipping-->
						<img src="images/home/shipping.jpg" alt="" />
					</div><!--/shipping-->
				
				</div>
			</div> 			
			<div class="col-sm-3">
				<h2 class="title text-center">할인 쿠폰</h2>
				<p class="text-center" style="font-size:30px; font-weight: bold;" ><a href="" style="color: black;">0</a></p>  
			</div>
			<div class="col-sm-3">
				<h2 class="title text-center">배송중</h2>
				<p class="text-center" style="font-size:30px; font-weight: bold;" ><a href="" style="color: black;">0</a></p>  
			</div>
			<div class="col-sm-3">
				<h2 class="title text-center">포인트</h2>  
				<p class="text-center" style="font-size:30px; font-weight: bold;" ><a href="" style="color: black;">0</a></p>
			</div>	
			<div class="col-sm-9">
				<h2 class="title text-center" style="margin-top: 40px;">기본 배송지 정보</h2>
				<p style="font-size: 25px;"><%=userDto.getUser_addr() %>, <%=userDto.getUser_addr_detail() %> (<%=userDto.getUser_post_code() %>)</p><a href="">수정하기</a>
			</div>
			<div class="col-sm-9">
				<h2 class="title text-center" style="margin-top: 50px;">기본 결제 정보</h2>
				
			</div>
    	</div>  
   	</div>	
    
	
	<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>e</span>-shopper</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe1.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe2.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe3.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe4.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="images/home/map.png" alt="" />
							<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Online Help</a></li>
								<li><a href="">Contact Us</a></li>
								<li><a href="">Order Status</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	

  
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script> -->
    <%-- <script type="text/javascript" src="<%=request.getContextPath() %>/js/gmaps.js"></script> --%>
	<script src="<%=request.getContextPath() %>/js/contact.js"></script>
	<script src="<%=request.getContextPath() %>/js/price-range.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.scrollUp.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.prettyPhoto.js"></script>
    <script src="<%=request.getContextPath() %>/js/main.js"></script>
</body>
</html>