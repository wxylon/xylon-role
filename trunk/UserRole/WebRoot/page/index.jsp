<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body style="margin-left: 200px;margin-top: 200px;">
  <table>
  	<tr>
  	<th style="width:100px; ">用户</th>
  	<th style="width:100px; ">角色</th>
  	<th style="width:100px; ">部门</th>
  	<th style="width:100px; ">权限</th>
  	<th style="width:100px; ">组</th>
  	</tr>
  </table>
  	<tr>
  		<td>
  			<select size="10" style="width:100px; "></select>
  		</td>
  		<td>
	  		<select size="10" style="width:100px; ">
		  		<c:forEach var="tRole" items="${tRoles}">
		  			<option value="${tRole.trId}">${tRole.trName}</option>
		  		</c:forEach>
	  		</select>
  		</td>
  		<td>
  			<select size="10" style="width:100px; "></select>
  		</td>
  		<td>
  			<select size="10" style="width:100px; "></select>
  		</td>
  		<td>
  			<select size="10" style="width:100px; "></select>
  		</td>
  	</tr>
  </body>
</html>
