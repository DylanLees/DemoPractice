<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品详情</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	font-family: 微软雅黑, 宋体，consalas;
	background-color: orange;
}

#outer {
	width: 100%;
	height: 100%;
	border: solid 0px red;
	margin: auto;
	margin-top: 50px;
	min-width: 1894px;
	min-height: 155px;
	position: fixed;
}

#left {
	width: 40%;
	height: 70%;
	border: solid 0px red;
	float: left;
/* 	margin-right: 120px; */
	margin-left: 130px;
	
}
#left img{
width:792px;
height:720px;
}

#right {
	width:792px;
	height:720px;
	border: solid 0px red;
	float: left;
	margin: auto;
	margin-left: 140px;
}

#right .element {
	width: 100%;
	height: 19.8%;
	border: solid 0px red;
	float: left;
	margin: auto;
	line-height: 30px;
	/* margin-left: 30px; */
	min-width: 731px;
	min-height: 135px;

}

#top {
	width: 100%;
	height: 75%;
	border: solid 0px red;
}

#bottom {
	width: 193px;
	height: 52px;
	border: solid 0px blue;
	margin-left: 1300px;
	text-align: center;
	margin-top: 15px;
	line-height: 50px;
}
</style>

</head>

<body>
	<div id="outer">
		<div id="top">
		<div id="left">
			<img id="picture_name" alt="正在加载图片">
			 <div id="goodsId" >${param.id}</div> 
			</div>
			<div id="right">
				<div class="element" id="goodsName"></div>
				<div class="element" id="price"></div>
				<div class="element" id="inventory"></div>
				<div class="element" id="feature"></div>
				<div class="element" id="product_site"></div>

			</div>
		</div>

		<div id="bottom">加入购物车</div>
	</div>

</body>
<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
<script type="text/javascript" src="js/private/goodsdetail.js"></script>
</html>

