<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/LoginController/login3" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="user_name" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="user_pass" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="登录" />
					<input type="reset" value="重置" /></td>

			</tr>

		</table>
		</form>
</body>
</html>