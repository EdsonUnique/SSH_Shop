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
							<strong>订单列表</strong>
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
										订单编号
									</td>
									<td align="center" width="10%">
										所属用户
									</td>
									<td align="center" width="10%">
										地址
									</td>
									<td width="10%" align="center">
										手机号
									</td>
									<td width="10%" align="center">
										下单时间
									</td>
									<td width="10%" align="center">
										订单状态
									</td>
									<td width="8%" align="center">
										总价
									</td>
									<td width="8%" align="center">
										订单详情
									</td>
									<td width="8%" align="center">
										修改订单状态
									</td>
									<td width="8%" align="center">
										删除订单
									</td>
								</tr>
								 <s:actionmessage theme="simple"/>
								<s:iterator value="order_pb.pageData" var="order">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.id}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.user.username}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.address}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.user.phone}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.time}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:if test="%{#order.state==0}">未付款</s:if>
												<s:if test="%{#order.state==1}">已付款</s:if>
												<s:if test="%{#order.state==2}">未发货</s:if>
												<s:if test="%{#order.state==3}">已发货</s:if>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#order.totalprice}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<a href="${pageContext.request.contextPath }/order/order_viewOrderItem?id=<s:property value="%{#order.id}"/>">查看订单项</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/order/order_updateOrderUI?id=<s:property value='%{#order.id}'/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/order/order_deleteOrder?id=<s:property value='%{#order.id}'/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>
									<tr 
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: white">

									<td align="center"  colspan="10">
										第<s:property value="order_pb.currentPage"/>/<s:property value="order_pb.totalPage"/>页&nbsp;&nbsp;
										[<a href="${pageContext.request.contextPath }<s:property value="order_pb.path"/>">首页</a>]
										<s:if test="order_pb.currentPage<order_pb.totalPage">
										[<a href="${pageContext.request.contextPath }<s:property value="order_pb.path"/>?pagenum=${order_pb.currentPage+1}">下一页</a>]
										</s:if>
										<s:if test="order_pb.currentPage>1">
										[<a href="${pageContext.request.contextPath }<s:property value="order_pb.path"/>?pagenum=${order_pb.currentPage-1}">上一页</a>]
										</s:if>
										[<a href="${pageContext.request.contextPath }<s:property value="order_pb.path"/>?pagenum=${order_pb.totalPage}">尾页</a>]
									</td>
								
								</tr>	
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

