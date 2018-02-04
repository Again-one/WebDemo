<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/my-style.css" charset="utf-8" />
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" >
		var obj={};
	</script>
</head>
<body>
	<div class="my-header">
		<div class="w1200 clearfix">
			<div class="logo fl">
			
			</div>
			<div class="my-search fl ">
				
				<input type='text' class=searchInput>
				<div class="search-link fl">
				
					<span>搜索</span>
				</div>
			</div>
			<ul class="fr state">
				
				<li class="my-login fr"  >
				
				 	<a style="color: rgb(14, 197, 161)" href='${pageContext.request.contextPath}/login.jsp'>登录</a>
				 	
				 </li>
				<li class="my-register fr "  >
					<a style="color: rgb(255, 255, 255)" href='${pageContext.request.contextPath}/regist.jsp'>注册</a>
				</li>
				<li class="slider" style="left:0px"></li>
			</ul>
		</div>
	</div>
	<div class="my-nav">
		<div class="w1200 clearfix">
		</div>
	</div>
	<div class="w1200 clearfix">
		<div class="search-roda">
			<a>全部分类</a>
                    &gt;&nbsp;
			<i>PPT模板</i>
			
		</div>
		<div class="search-classify clearfix">
		
			<div class="class-title fl">分类</div>
			
			<div class="fl right-title clearfix">
				<div class="overbox">
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
					<a>
						<span>商务ppt</span>
					</a>
				</div>
			</div>
			
		</div>
	</div>
	<script type="text/javascript" src="script/my_public.js"></script>
	<script type="text/javascript" src="script/categoryAction.js"></script>
<body>
</html>