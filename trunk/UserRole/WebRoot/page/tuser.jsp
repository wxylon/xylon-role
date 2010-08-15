<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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


	<body style="margin-left: 350px;margin-top: 200px;">
  	<form action="tuserAction!save.action" name="" method="post">
  		<a href="/">首页</a>
		  <table>
		  	<tr>
		  		<td>用户账号</td>
		  		<td><input name="tuser.userName" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>密码</td>
		  		<td><input name="tuser.passWord" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>昵称</td>
		  		<td><input name="tuser.vserName" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>电话</td>
		  		<td><input name="tuser.mobile" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>电子邮箱</td>
		  		<td><input name="tuser.email" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>部门</td>
		  		<td>
		  			<select id="torganizationID" name="tuser.torganization.toId">
		  				<option value="0">请选择</option>
		  			</select>
		  		</td>
		  	</tr>
		  	<tr>
		  		<td><input type="submit" value="提交"/></td>
		  		<td><input type="reset" value="重置"/></td>
		  	</tr>
		  </table>
  	</form>
  </body>
</html>
