<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/user_search" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单详情</strong>
						</TD>
					</tr>
					<tr>
						<td height="10%">&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										订单项编号
									</td>
									<td align="center" width="10%">
										商品名称
									</td>
									<td align="center" width="10%">
										商品图片
									</td>
									<td width="10%" align="center">
										商品价格
									</td>
									<td width="10%" align="center">
										商品数量
									</td>
									<td width="10%" align="center">
										小计
									</td>
								</tr>
								 <s:actionmessage theme="simple"/>
								<s:iterator value="%{model.items}" var="orderItem">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#orderItem.id}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#orderItem.product.name}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<img alt="商品图片" width="40%" height="120%"  src="${pageContext.request.contextPath }/<s:property value="%{#orderItem.product.image}"/>"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#orderItem.product.shop_price}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#orderItem.count}"/>
											</td>
									
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#orderItem.sum}"/>
											</td>
										</tr>
									</s:iterator>
									
							</table>
							</td>
					</tr>
					<tr>
						<td colspan="6" style="CURSOR: hand; HEIGHT: 22px" align="center">
							<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						</td>
					</tr>	
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

