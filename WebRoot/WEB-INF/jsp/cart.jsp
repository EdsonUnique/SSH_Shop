<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>购物车</title>
<meta name="author" content="Mango Team">
<meta name="copyright" content="Mango">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障">
</div>	</div>
	<%@ include file="header.jsp" %>
	
</div>	<div class="container cart">
		<div class="span24">
		<s:if test="#session.cart.map.size()>0">
			<div class="step step1">
				
			</div>
			
				<table>
					<tbody><tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<s:iterator value="#session.cart.map" var="item">
					<tr>
							<td width="60">
								<input type="hidden" name="id" value="22">
								<img src="${pageContext.request.contextPath }/${item.value.product.image }">
							</td>
							<td>
								<a target="_blank" href="${pageContext.request.contextPath }/product/product_showDetail?id=${item.value.product.id}"> ${item.value.product.name }</a>
							</td>
							<td>
								￥${item.value.product.shop_price }
							</td>
							<td class="quantity" width="60">
								${item.value.count }
							</td>
							<td width="140">
								<span class="subtotal">${item.value.sum }</span>
							</td>
							<td>
								<a href="${pageContext.request.contextPath }/cart/cart_operateCart?ctId=${item.key}&method=delete" class="delete">删除</a>
							</td>
						</tr>
						</s:iterator>
				</tbody></table>
				<dl id="giftitem.values" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
							<em>
								登录后确认是否享有优惠
							</em>
					赠送积分: <em id="effectivePoint">596</em>
					商品金额: <strong id="effectivePrice">￥${cart.totalprice }元</strong>
				</div>
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/cart/cart_operateCart?&method=empty" id="clear" class="clear">清空购物车</a>
					<a href="${pageContext.request.contextPath }/order/order_saveOrder" id="submit" class="submit">提交订单</a>
				</div>
				</s:if>
				<s:else><span style="color:red;">*您还未选择任何商品，请先去购物！</span></s:else>
		</div>
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
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
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body></html>