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

<title>商品展示界面</title>

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
	font-size: 20px;
	color: black;
	min-height: 800px;
	min-width: 1000px;
	background-color: orange;
	background-size: cover;
}

a:link {
	text-decoration: none;
	color:black;
}


#top {
	width: 98%;
	height: 10%;
	border-radius: 10px;
	margin: auto;
	border: solid 0px red;
	text-align: center;
	line-height: 30px;
	position: fixed;
	min-height: 100px;
	min-width: 400px;
}

#top .menu {
	width: 10%;
	height: 70%;
	border: solid 0px blue;
	text-align: center;
	float: right;
	line-height: 65px;
	margin-top: 15px;
	min-height: 50px;
	min-width: 100px;
}

#bottom {
	width: 98%;
	height: 80%;
	margin: auto;
	margin-top: 100px;
	text-align: center;
	border: solid 0px red;
	position: fixed;
	min-height: 90%;
	min-width: 80%;
	text-align: center;
}

#bottom .goods {
	width: 100%;
	height: 42%;
	border: solid 0px red;
	min-height: 200px;
	min-width: 100px;
	text-align: center;
}

#bottom .goods .element {
	width: 19%;
	height: 100%;
	border: solid 0px red;
	float: left;
	min-height: 200px;
	min-width: 100px;
	margin-left: 180px;
	margin-right: 35px;
	text-align: center;
}

#bottom .goods .element .img {
	width: 100%;
	height: 80%;
	border: solid 0px red;
	text-align: center;
}

#bottom .goods .element .item {
	width: 100%;
	height: 15%;
	border: solid 0px red;
	margin-top: 10px;
	text-align: center;
	line-height:50px;
}

#bottom #page {
	width: 30%;
	height: 5%;
	border: solid 0px red;
	margin: auto;
	margin-top: 10px;
	text-align: center;
	
}

#bottom #page .turnPage {
	width: 20%;
	height: 80%;
	border: solid 0px red;
	margin: auto;
	text-align: center;
	float: left;
	
}

.content {
	width: 25px;
	height: 31px;
	border: solid 0px red;
	text-align: center;
	float: left;
	
}
</style>

</head>

<body>
	<div id="top">
		<div class="menu">
			<a href="jsp/orders.jsp">我的订单</a>
		</div>
		<div class="menu">
			<img src="./fruits/cart.jpg"
				style="width: 37px;height: 29px;border-radius: 15px" /><a
				href="jsp/cart.jsp">我的购物车</a>
		</div>
		<div class="menu">
			<a href="jsp/register.jsp">免费注册</a>
		</div>
		<div class="menu">
			<a href="jsp/login.jsp"> <c:if
					test="${sessionScope.userName==null }">您好，请登录！</c:if> <c:if
					test="${sessionScope.userName!=null }">欢迎您，${sessionScope.userName }</c:if>
			</a>
		</div>
	</div>
	<div id="bottom">
		<div class="goods">
			<c:forEach var="i" begin="0" end="5" varStatus="status">
				<a id="goodsdetail${status.index}">
				<div class="element">
					<img class="img" alt="正在加载图片" id="picture_name${status.index}" />
					<div class="item" id="goodsName${status.index}"></div>
				</div></a>
			</c:forEach>
		</div>
		<div id="page">
			<div class="turnPage" ><div id="previous" style="cursor: pointer">上一页</div></div>
			<div class="turnPage" ><div id="next" style="cursor: pointer">下一页</div></div>
			<div class="turnPage">
				<div class="content">第</div>
				<div class="content" id="assign">1</div>
				<div class="content">页</div>
			</div> 
			<div class="turnPage">
				<div class="content">共</div>
				<div class="content" id="total">1</div>
				<div class="content">页</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
<script type="text/javascript" src="js/private/goodsdisplay.js"></script>

</html>
