<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="RegisterServlet" method="post">
    	  账户：<input type="text" name="account"/><br/>
		  密码：<input type="password" name="pass"/><br/>
		 确认密码：<input type="password" name="checkpass"/><br/>
		   验证码：<input type="text" name="vercode"/><img id="vercodeimg" onclick="getCode()"/><br/>
		    <input type="submit"/>
    </form>
  </body>
  <script type="text/javascript" src="JS/vercode.js"></script>
</html>
