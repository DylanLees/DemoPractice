<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body>
	欢迎[${sessionScope.user.user_name }]登录
	<br>
	<table border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>生日</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.users }" var="u"
			varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${u.user_name }</td>
				<td>${u.age }</td>
				<td>${u.birthday }</td>
				<td><a href="${pageContext.request.contextPath }/UserController/delete/${u.id}">删除</a>修改</td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>