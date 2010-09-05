<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body style="margin-left: 350px;margin-top: 200px;">
  	<div><a href="/">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户角色管理</div></br></br>
  	<select name="userid" size="10">
  		<c:forEach items="${tusers}" var="tuser">
  			<option value="${tuser.tuId}">${tuser.userName}</option>
  		</c:forEach>
  	</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<select name="roleid" size="10">
  		<option>dd</option>
  	</select>
  </body>
</html>
