<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>

<script type="text/javascript" src="js/jquery.1.9.1.js"></script>
<script type="text/javascript" src="js/validateCode.js"></script>
<body>
	<!-- 通过form表单提交数据到servlet -->
	<form action="LoginServlet" method="post">
		<div>
			用户名：&nbsp;<input type="text" name="userName" />
		</div>
		<br />
		<div>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPass" />
		</div>
		<br />
		<div>验证码：<input type="text" name="verCode" ><img  id="validateCode" onclick="getValidateCode()"/></div><br>
		<br> <input type="submit" value="登录" />
	</form>
</body>
</html>