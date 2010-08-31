<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
var url = '/tgroupAction!get.action';
$(document).ready(function() {
	$.ajax({
	  url: url,
	  cache: false,
	  success: function(infos){
	    $.each(infos, function(i) {
			$("#tgroupID").append('<option value='+infos[i].tgId+'>'+infos[i].tgName+'</option>');  
		});
	  }
	}); 
});
</script>
  <body style="margin-left: 350px;margin-top: 200px;">
  	<div><a href="/">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;组管理</div></br></br>
  	<form action="tgroupAction!save.action" name="" method="post">
		  <table>
		  	<tr>
		  		<td>组名称</td>
		  		<td><input name="tgroup.tgName" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td>父组</td>
		  		<td>
		  			<select name="tgroup.tgParentId" id="tgroupID">
		  				<option value="0">默认</option>
		  			</select>
		  		</td>
		  		<td><em>默认为根组</em></td>
		  	</tr>
		  	<tr>
		  		<td>组描述</td>
		  		<td><input name="tgroup.description" value=""/></td>
		  	</tr>
		  	<tr>
		  		<td><input type="submit" value="提交"/></td>
		  		<td><input type="reset" value="重置"/></td>
		  	</tr>
		  </table>
  	</form>
  </body>
</html>
