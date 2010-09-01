<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/leftmenu.css" rel="stylesheet" type="text/css" />
<!--[if IE]>
<style>
@import url(../css/ie.css); 
</style>
<![endif]-->
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<!--将jQuery引用进来-->
<script type="text/javascript">
$(document).ready(function(){
        $(".left_common > li").mousedown(function(){ 
                //如果鼠标移到class为stripe的表格的tr上时，执行函数
				$(".left_common > li").removeClass("select");
				$(".left_common > li").addClass("noselect");
				$(this).removeClass("noselect");
				$(this).addClass("select");})	
		 $("#tagtitle > #tag").mousedown(function(){ 
			 if ($("#tags").css("display") == "none") {
			        $("#tagtitle").css("background" , "url(../images/left_menu_top_1.gif) no-repeat");
			        $("body > #tags").removeClass("hide");
					$("body > #tags").addClass("left_common");
			 } else {		
	                //如果鼠标移到class为stripe的表格的tr上时，执行函数
	                $("#tagtitle").css("background" , "url(../images/left_menu_top_2.gif) no-repeat");
					$("body > #tags").removeClass("left_common");
					$("body > #tags").addClass("hide"); }
			 })
					
				
		 $("#tagclasstitle > #tagclass").mousedown(function(){ 
			 if ($("#tagsclass").css("display") == "none") {
			        $("#tagclasstitle").css("background" , "url(../images/left_menu_top_1.gif) no-repeat");
			        $("body > #tagsclass").removeClass("hide");
					$("body > #tagsclass").addClass("left_common");
			 } else {		
	                //如果鼠标移到class为stripe的表格的tr上时，执行函数
	                $("#tagclasstitle").css("background" , "url(../images/left_menu_top_2.gif) no-repeat");
					$("body > #tagsclass").removeClass("left_common");
					$("body > #tagsclass").addClass("hide"); }
			 })
		 //链接
         $("#tags > #newtag").mousedown(function(){ 
				   parent.frames["mainFrame"].location.href="/page/tgroup.jsp"; })  
	     $("#tags > #oldtag").mousedown(function(){ 
	               parent.frames["mainFrame"].location.href="/page/tgroup.jsp"; })  
});	
</script>
	</head>
	<body style="overflow-x: hidden; overflow-y: yes;">
		<div id="tagtitle" class="left_title">
			<li id="tag" class="title">
				我的我的
			</li>
		</div>
		<div id="tags" class="left_common">
			<li id="newtag" class="select">
				我的我的我的
			</li>
			<li id="oldtag" class="noselect">
				我的我的我的
			</li>
			<li class="noselect">
				我的我的我的
			</li>
			<li class="noselect">
				我的我的我的
			</li>
			<li class="noselect">
				我的我的我的
			</li>
		</div>
		<div id="tagclasstitle" class="left_title">
			<li id="tagclass" class="title">
				我的分类
			</li>
		</div>
		<div id="tagsclass" class="left_common">
			<li class="noselect">
				按类别查看
			</li>
			<li class="noselect">
				按状态查看
			</li>
			<li class="noselect">
				按等级查看
			</li>
			<li class="noselect">
				按时间查看
			</li>
		</div>
		<div class="left_bottom">
			<li class="bottom"></li>
		</div>
	</body>
</html>
