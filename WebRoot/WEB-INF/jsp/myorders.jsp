<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
	
</script>
</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/logo.gif" alt="Mango商城"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	
</div>
	<%@ include file="header.jsp" %>
</div>	

<div class="container cart">

		<div class="span24">
			<s:if test="%{orders!=null && orders.size()>0}">
			<div class="step step1">
				<ul>
					<li  class="current"></li>
					<li  >我的订单</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<s:iterator value="%{orders}" var="odr"> 
					<tr>
						<th colspan="5">订单号：${odr.id }  &nbsp;&nbsp;总价：${odr.totalprice }</th>
					</tr>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<s:iterator value="%{#odr.items }" var="item">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${pageContext.request.contextPath }/${item.product.image}"/>
							</td>
							<td>
								<a target="_blank"><s:property value="%{#item.product.name }"/></a>
							</td>
							<td>
								${item.product.shop_price }
							</td>
							<td class="quantity" width="60">
								${item.count }
							</td>
							<td width="140">
								<span class="subtotal">￥${item.sum }</span>
							</td>
						</tr>
						
					</s:iterator>
					<tr>
						<td colspan="5" style="text-align: right;color: red;">
						订单状态：
							<s:if test="%{ #odr.state==0}"><a href="${pageContext.request.contextPath }/order/order_repayOrder?id=${odr.id}">未付款</a></s:if>
							<s:if test="%{ #odr.state==1}">已付款</s:if>
							<s:if test="%{ #odr.state==2}">未发货</s:if>
							<s:if test="%{ #odr.state==3}">已发货</s:if>
						</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			</s:if>
			<s:else><span style=";color: red;">*您还没有任何订单</span></s:else>
		</div>
		
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath }/image/r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body>
</html>