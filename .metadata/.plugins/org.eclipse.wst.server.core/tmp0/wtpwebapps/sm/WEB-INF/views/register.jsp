<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
<!-- 引入需要使用的日期js文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<spring:hasBindErrors name="user">
		<c:forEach items="${errors.allErrors }" var="error">
	${error.defaultMessage }
	</c:forEach>
	</spring:hasBindErrors>
	<form action="${pageContext.request.contextPath}/UserController/doRegister"
		method="post">
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
				<td>年龄</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<!-- 点击时调用产生日期的方法 -->
				<td><input name="birthday" class="Wdate" type="text"
					onClick="WdatePicker()" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="注册提交" /></td>

			</tr>

		</table>
	</form>
</body>
</html>