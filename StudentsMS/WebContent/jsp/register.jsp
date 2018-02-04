<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>

<script type="text/javascript" src="js/jquery.1.9.1.js"></script>

<body>
	<form action="RegisterServlet" method="post">
		<div>
			用户名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="userName" />
		</div>
		<br />
		<div>
			密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"
				name="userPass" />
		</div>
		<br />
		<div>
			密码确认：<input type="password" name="confirmPass">
		</div>
		<br />
		<div>
			验证码：<input type="text" name="verCode"><img id="validateCode"
				onclick="getValidateCode()" />
		</div>
		<br> <input type="submit" value="点击提交">
	</form>
</body>
<script type="text/javascript" src="js/validateCode.js"></script>
</html>