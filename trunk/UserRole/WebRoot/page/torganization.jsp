<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
var url = '/torganizationAction!get.action';
$(document).ready(function() {
	$.ajax({
	  url: url,
	  cache: false,
	  success: function(infos){
	    $.each(infos, function(i) {
			$("#torganizationID").append('<option value='+infos[i].toId+'>'+infos[i].toName+'</option>');  
		});
	  }
	}); 
});
</script>
</head>
  <body style="margin-left: 350px;margin-top: 200px;">
  	<div><a href="/">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门管理</div></br></br>
  	<form action="torganizationAction!save.action" name="" method="post">
		  <table>
		  	<tr>
		  		<td>部门名称</td>
		  		<td><input name="torganization.toName" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>父级部门ID</td>
		  		<td>
		  			<select name="torganization.toParentId" id="torganizationID">
		  				<option value="0">默认</option>
		  			</select>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td>部门描述</td>
		  		<td><input name="torganization.description" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td><input type="submit" value="提交"/></td>
		  		<td><input type="reset" value="重置"/></td>
		  	</tr>
		  </table>
  	</form>
  </body>
</html>
