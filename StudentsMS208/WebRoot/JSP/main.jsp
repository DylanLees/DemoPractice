<%@ page language="java" import="java.util.*,com.woniuxy.studentms28.dao.po.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    
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
  <%@include file="loginControl.jsp" %>
   <form action="DeleteServlet" method="post">
   <input type="hidden" id="sid" name="sid"/>
    <table border="1">
    	<thead>
    		<tr>
    			<th>学生ID</th>
    			<th>姓名</th>
    			<th>年龄</th>
    			<th>性别</th>
    			<th>班级ID</th>
    			<th>班级名称</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    
    <%
    	Object olist = request.getAttribute("students");
    	if(olist != null){
    		List<Vi_students_classPO> list = (List<Vi_students_classPO>)olist;
    		for(Vi_students_classPO po:list){
    			%>
    			<tr>
    				<td><%=po.getSid() %></td>
    				<td><%=po.getSname() %></td>
    				<td><%=po.getAge() %></td>
    				<td><%=po.getSex() %></td>
    				<td><%=po.getCid() %></td>
    				<td><%=po.getCname() %></td>
    				<td><button onclick="deleteStu(<%=po.getSid()%>)">删除</button></td>
    			</tr>
    			<%
    		}
    	}
     %>
     </table>
     </form>
     <script type="text/javascript" src="JS/delete.js"></script>
  </body>
</html>
