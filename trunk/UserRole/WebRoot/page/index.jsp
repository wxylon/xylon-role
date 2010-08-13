<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<select size="10" style="width: 60px;">
  		<c:forEach var="tRole" items="${tRoles}">
  			<option value="${tRole.trId}">${tRole.trName}</option>
  		</c:forEach>
  	</select>
  	<select size="10"></select>
  </body>
</html>
