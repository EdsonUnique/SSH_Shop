<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>消息显示页面</title>
</head>
<body>
<div style="color: red;">
	<s:actionmessage theme="simple"/>
	请稍候访问！
	<br/>
	<input type="button" value="返回上一页" onclick="history.go(-1)">
</div>	
</body>
</html>