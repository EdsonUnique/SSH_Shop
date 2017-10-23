<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function addProduct(){
				window.location.href = "${pageContext.request.contextPath}/product/product_addProductUI";
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/user_search" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="7%">
										编号
									</td>
									<td align="center" width="17%">
										商品名
									</td>
									<td align="center" width="7%">
										商城价
									</td>
									<td align="center" width="7%">
										市场价
									</td>
									<td align="center" width="15%">
										描述
									</td>
									<td align="center" width="20%">
										图片
									</td>
									<td align="center" width="10%">
										日期
									</td>
									<td align="center" width="5%">
										热门商品
									</td>
									<td align="center" width="10%">
										所属二级分类
									</td>
									<td width="10%" align="center">
										编辑
									</td>
									<td width="10%" align="center">
										删除
									</td>
								</tr>
								 <s:actionmessage theme="simple"/>
								<s:iterator value="%{product_pb.pageData}" var="product">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="%{#product.id}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:if test="%{#product.name.length()>12}">
													<s:property value="#product.name.substring(0,12)"/>......
												</s:if>
												<s:else><s:property value="#product.name"/></s:else>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="%{#product.shop_price}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="7%">
												<s:property value="%{#product.market_price}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="15%">
												<s:if test="%{#product.description.length()>10}">
													<s:property value="#product.description.substring(0,10)"/>......
												</s:if>
												<s:else><s:property value="#product.description"/></s:else>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20%">
												<s:if test="#product.image==null">无</s:if>
												<s:else>
													<a href="${pageContext.request.contextPath }/viewImage.jsp?path=<s:property value='#product.image'/>" target="_self">查看图片</a>
												</s:else>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#product.date}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5%">
												<s:if test="%{#product.is_hot==1}">是</s:if>
												<s:if test="%{#product.is_hot==0}">否</s:if>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="%{#product.csecond.name}"/>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/product/product_updateProductUI?id=<s:property value='%{#product.id}'/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/product/product_deleteProduct?id=<s:property value='%{#product.id}'/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>
									<tr>
										<td align="center" width="18%" colspan="11">
												第<s:property value="product_pb.currentPage"/>/<s:property value="product_pb.totalPage"/>页&nbsp;&nbsp;
												[<a href="${pageContext.request.contextPath }<s:property value="product_pb.path"/>">首页</a>]
												<s:if test="product_pb.currentPage<product_pb.totalPage">
												[<a href="${pageContext.request.contextPath }<s:property value="product_pb.path"/>?pagenum=${product_pb.currentPage+1}">下一页</a>]
												</s:if>
												<s:if test="product_pb.currentPage>1">
												[<a href="${pageContext.request.contextPath }<s:property value="product_pb.path"/>?pagenum=${product_pb.currentPage-1}">上一页</a>]
												</s:if>
												[<a href="${pageContext.request.contextPath }<s:property value="product_pb.path"/>?pagenum=${product_pb.totalPage}">尾页</a>]
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

