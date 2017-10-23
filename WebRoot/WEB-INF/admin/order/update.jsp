<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/order/order_updateOrder" method="post">
			&nbsp;
			
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>修改订单状态</STRONG>
						</strong>
					</td>
				</tr>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<s:actionmessage theme="simple"/>
					</td>
				
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 订单编号：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="id" value="<s:property value='%{model.id}'/>" id="logonPwd"/>
					</td>

				<tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						订单状态：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="state" >
								<option value="0" ${model.state==0?'selected':''}>未付款</option>
								<option value="1" ${model.state==1?'selected':''}>已付款</option>
								<option value="2" ${model.state==2?'selected':''}>未发货</option>
								<option value="3" ${model.state==3?'selected':''}>已发货</option>
						</select>
					</td>

				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" name="submit" value="&#30830;&#23450;" class="button_ok">
							提交
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="&#37325;&#32622;" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>