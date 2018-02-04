<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  	Object obj = session.getAttribute("account");
  	if(obj != null){
  		%>
  		尊敬的<%=obj %>，欢迎光临！<br/>
  		<%
  	}
%>
 
