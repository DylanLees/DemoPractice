<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{
            width: 100%;
            height: 100%;
            margin-top: 40px;
            background-color: orange;
        }
        #outer{
            width: 600px;
            height: 300px;
            margin: auto;
            border: solid 0px red;
            border-radius: 15px;
            text-align: center;
            margin-top: 50px;

        }
        #outer .inner{
            width: 40%;
            height: 10%;
            margin-left: 30px;
            margin-top: 30px;
            border: solid 0px red;
            border-radius: 10px;
            text-align: center;
            line-height: 15px;
        }
        #top{
            width: 98%;
            height: 15%;
            margin: auto;
            border-radius: 10px;
            border: solid 0px red;
            text-align: center;
            line-height: 40px;
            font-family: 微软雅黑;
            font-size: 32px;
            color: blue;
        }
          #outer .ver{
            width: 60%;
            height: 10%;
            margin-left: 30px;
            margin-top: 30px;
            margin-bottom:10px;
            border: solid 0px red;
            border-radius: 10px;
            text-align: left;
            line-height: 15px;
        }
	
	</style>
	<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
  </head>
  
  <body>
    <div id="outer" >
    <div id="top">欢迎来到蜗牛官方购物广场登录界面</div>
    <div class="inner">用户名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id="userName" style="width:147px;height:25px ;border-radius: 5px"/></div>
    <div class="inner">密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="password" style="width:147px;height:25px ;border-radius: 5px"/></div>
    <div class="ver">图形验证码:&nbsp;<input type="text" id="verCode" style="width:147px;height:25px ;border-radius: 5px  "/>&nbsp;&nbsp;<img id="verCodePicture" onclick="getVerCodePicture()" style="height: 21px ;margin-top: 5px"/></div>
    <div class="inner" ><button onclick="login()">登录</button></div>
</div>
  </body>
  
  <script type="text/javascript" src="js/private/user.js"></script>
</html>


