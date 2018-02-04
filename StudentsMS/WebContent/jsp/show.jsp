<%@page
	import="com.woniuxy.studentsms.dao.po.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息展示平台</title>
<style>
html, body {
	width: 100%;
	height: 100%;
	font-family: 微软雅黑, 宋体，consalas;
}

#content {
	width: 80%;
	height: 50%;
	margin: auto;
	border: solid 1px red;
}

#table {
	border: 1px solid red;
	width: 600px;
	height: 200px;
	margin: auto;
	margin-top: 50px;
}

.table_row {
	border: 1px solid red;
	width: 400px;
	height: 50px;
}

.table_data {
	border: 1px solid red;
	width: 100px;
	text-align: center;
	font-size: 18px;
}

#middle {
	border: 1px solid red;
	width: 400px;
	height: 50px;
	text-align: center;
	font-size: 18px;
	margin: auto;
}

#middle .opt {
	width: 30%;
	height: 50px;
	border: solid 1px red;
	float: left;
	text-align: center;
	margin: auto;
	line-height: 40px;
}

#bottom {
	border: 1px solid red;
	width: 400px;
	height: 50px;
	text-align: center;
	font-size: 18px;
	margin: auto;
}

#bottom .button {
	width: 30%;
	height: 50px;
	border: solid 1px red;
	float: left;
	text-align: center;
	margin: auto;
	line-height: 40px;
}
</style>
</head>
<body>
	<%
		//获取响应的值
		Object userName = request.getAttribute("userName");
		Object obj = session.getAttribute("studentsInfo");
	%>
	<!-- 从页面输出响应的值 -->
	尊敬的，<%=userName%>， 欢迎您！
	<br />
	<%-- sessionId:<%=session.getAttribute("session")%><br /> --%>
	<%-- <%=application.getAttribute("context")%> --%>


	<div id="content">
		<table id="table">
			<tr class="table_row">
				<td class="table_data" colspan="7"
					style="font-family: 宋体; font-size: 35px">学生信息展示平台</td>
			</tr>
			<tr class="table_row">
				<td class="table_data" style="font-weight: bold">学号</td>
				<td class="table_data" style="font-weight: bold">学生姓名</td>
				<td class="table_data" style="font-weight: bold">性别</td>
				<td class="table_data" style="font-weight: bold">年龄</td>
				<td class="table_data" style="font-weight: bold">专业</td>
				<td class="table_data" style="font-weight: bold">班级编号</td>
				<td class="table_data" style="font-weight: bold">班级名称</td>

			</tr>
			<%
				List<Vi_StudentsPO> studentsInfo = (List<Vi_StudentsPO>) obj;
				for (Vi_StudentsPO li : studentsInfo) {
			%>
			<tr class="table_row">
				<td class="table_data"><%=li.getId()%></td>
				<td class="table_data"><%=li.getSname()%></td>
				<td class="table_data"><%=li.getSex()%></td>
				<td class="table_data"><%=li.getAge()%></td>
				<td class="table_data"><%=li.getMajor()%></td>
				<td class="table_data"><%=li.getCid()%></td>
				<td class="table_data"><%=li.getCname()%></td>
			</tr>
			<%
				}
			%>


		</table>
		<div id="middle">
			<div class="opt">增加</div>
			<div class="opt">删除</div>
			<div class="opt">修改</div>
		</div>
		<div id="bottom">
			<div class="button">上一页</div>
			<div class="button">共多少页</div>
			<div class="button">下一页</div>

		</div>
	</div>


</body>
</html>