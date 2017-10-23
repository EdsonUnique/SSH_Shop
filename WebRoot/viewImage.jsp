<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
	</HEAD>
	<body>
		
		<img alt="商品图片" src="${pageContext.request.contextPath }/<%=request.getParameter("path")%>"/>
		<br/>
		<input type="button" value="返回" onclick="history.go(-1)">
	</body>
</HTML>

