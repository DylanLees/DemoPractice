<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
        html,body{
            width: 100%;
            height: 100%;
            border: solid 1px red;
            background-color: orange;
        }
        #outer{
            width: 70%;
            height: 70%;
            border:solid 1px red;
            margin: auto;
            margin-top: 50px;
        }
        #outer .inner{
            width: 70%;
            height: 9%;
            border:solid 1px red;
            margin: auto;
            margin-top: 10px;
            line-height: 70px;
        }
    </style>
    <script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
  </head>
  
  <body>
    <div id="outer">

    <div class="inner" id="goodsname">商品名称：</div>
    <div class="inner" id="price">商品价格：</div>
    <div class="inner" id="ordernum">订单编号：</div>
    <div class="inner" id="ordertime">下单时间：</div>
    <div class="inner" id="balance">支付金额：</div>
    <div class="inner" id="contact">联系人：</div>
    <div class="inner" id="tel">联系电话：</div>
    <div class="inner" id="address">收货地址：</div>
    <div class="inner" id="mail">邮箱：</div>
</div>
  </body>
  <script type="text/javascript" src="js/private/display.js"></script>
</html>
