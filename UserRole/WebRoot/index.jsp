<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
   	<body style="margin-left: 350px;margin-top: 200px;">
   	<a href="/page/trole.jsp">角色管理</a><br>
   	<a href="/page/tuser.jsp">用户注册</a><br>
   	<a href="/page/torganization.jsp">部门管理</a><br>
   	<a href="/page/tauth.jsp">权限管理</a><br>
   	<a href="/page/tgroup.jsp">组管理</a><br>
	</body>
</html>
