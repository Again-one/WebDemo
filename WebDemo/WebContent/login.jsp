<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/my-style.css"></link>
	<script type="text/javascript">
	
	 var host="http://47.95.234.255:8080/WebDemo"
	</script>
	
	</head>
	<body style="background:url(image/back4.png) no-repeat 0 0;background-size:cover;margin:0;padding:0;">
		<div id="wrapper">
			<div id="header">
				<div class="w1200 clearfix">
					<div class="fl logo"></div>
					<div class="fr notice-span">
						还没账号？
						<a>立即注册</a>
					</div>
				</div>
			</div>
			<div id="public-box" class="pos-r" style="margin:30px auto 0;">
				
				<div class="w400" style="padding-top:100px">
					<div class="login-state clearfix">
						<a class="on" style="width:100%">用户登陆</a>
					</div>
					<div class="title-actline"></div>
					<div class="change clearfix">
						<div class="fl">
							<div class="fill-box">
								<div class="fill-list clearfix">
									<i class="fl"></i>
									<input type="text" name="user" class="type-text fl" placeholder="输入用户名/邮箱">
								</div>
								
								<div class="fill-list clearfix">
									<i class="password-icon fl"></i>
									<input type="text" name="password1" class="type-text fl" placeholder="密码">
								</div>
								
								<div class="fill-list-none clearfix">
									<div class="fl pos-r">
										<input type="text" name="userEmail-code" class="type-text fl" placeholder="输入验证码">
										
									</div>
									<div class="fr yzm">
										<img style="width:100%,height:100%" src="http://47.95.234.255:8080/randomReg?random=0.1">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="title-actline" style="margin-bottom:5px;"></div>
					<div class="now-login">
						<input type="submit" name="mail-reg" value="立即登陆">
					</div>
				</div>
				
			</div>
			<p class="CopyRight-p" style="    display: block;-webkit-margin-before: 1em;-webkit-margin-after: 1em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;">
				如有侵权请告之 本网站会立即处理问题所在              网站建设目的是建立免费而且活跃ppt社区 
			</p>
			
		</div>
		<script type="text/javascript" src="script/jquery.js"></script>
		<script type="text/javascript" src="script/Login.js"></script>
		<script type="text/javascript" src="script/login_run.js"></script>
	</body>
</html>