<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body style="margin-left: 350px;margin-top: 200px;">
  <table>
  	<form action="tRoleAction!save.action" name="" method="post">
  	<tr>
  		<td>角色名称</td>
  		<td><input name="trole.trName" value=""/></td>
  	</tr>
  	<tr>
  		<td>父级角色ID</td>
  		<td>
  			<select name="trole.parentTrId">
  				<option value="0">默认</option>
  			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>角色描述</td>
  		<td><input name="trole.description" value=""/></td>
  	</tr>
  	<tr>
  		<td><input type="submit" value="提交"/></td>
  		<td><input type="reset" value="重置"/></td>
  	</tr>
  	</form>
  </table>
  </body>
</html>
