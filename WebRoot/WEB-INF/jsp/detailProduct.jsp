<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>京华亿家--大冬瓜</title>
	<meta name="author" content="Mango Team">
	<meta name="copyright" content="Mango">
		<meta name="keywords" content="京华亿家--大冬瓜">
		<meta name="description" content="京华亿家--大冬瓜">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function changeQuantity(flag){
		var value=document.getElementById("quantity").value;
		
		if(flag==1){
			value=parseInt(value)+1;
		}else{
			value=parseInt(value)-1;
			if(parseInt(value)<=0)value=1;
		}
		document.getElementById("quantity").value=value;
	}

</script>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a>
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客">
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/header.jpg" alt="正品保障" title="正品保障" height="50" width="320">
</div>	</div>

<%@ include file="header.jsp" %>
<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="firstCty" value="%{fss}">
					<dl>
							<dt>
								<a href="${pageContext.request.contextPath}/category/categorysecond_searchSecondCategory?first_id=${firstCty.id}">${firstCty.name }</a>
							</dt>
						
							<s:iterator var="secondCty" value="%{#firstCty.csecond}">
									<dd>
										<a href="${pageContext.request.contextPath}/category/categorysecond_searchDetailSecondCategory?second_id=${secondCty.id}">
											<s:property value="%{#secondCty.name}"/>
										</a>
									</dd>
							</s:iterator>
						</dl>
				</s:iterator>
			</div>
			

		</div>
		<div class="span18 last">
			
			<div class="productImage">
					<a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg" rel="gallery">
						<div class="zoomPad"><img style="opacity: 1;" title="" class="medium" src="${pageContext.request.contextPath }/<s:property value="%{model.image}"/>"><div style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;" class="zoomPup">
						</div><div style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;" class="zoomWindow">
						<div style="width: 368px;" class="zoomWrapper"><div style="width: 100%; position: absolute; display: none;" class="zoomWrapperTitle"></div><div style="width: 0%; height: 0px;" class="zoomWrapperImage"></div></div></div><div style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;" class="zoomPreload">Loading zoom</div></div>
					</a>
				
			</div>
			
			<form action="${pageContext.request.contextPath }/cart/cart_addCart" method="post" >
			<input type="hidden" name="id" value="${model.id}"/>
			<input type="hidden" name="name" value="${model.name}"/>
			<input type="hidden" name="image" value="${model.image}"/>
			<input type="hidden" name="shop_price" value="${model.shop_price}"/>
			<div class="name" ><s:property value="%{model.name}"/></div>
			<div class="sn">
				<div>编号：<s:property value="%{model.id}"/></div>
			</div>
			<div class="info">
				<dl>
					<dt>亿家价:</dt>
					<dd>
						<strong>￥：<s:property value="%{model.shop_price}"/>元/份</strong>
							参 考 价：
							<del>￥<s:property value="%{model.market_price}"/>元/份</del>
					</dd>
				</dl>
					<dl>
						<dt>促销:</dt>
						<dd>
								<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
						</dd>
					</dl>
					<dl>
						<dt>    </dt>
						<dd>
							<span>    </span>
						</dd>
					</dl>
			</div>
				<div class="action">
					
						<dl class="quantity">
							<dt>购买数量:</dt>
							<dd>
								<input id="quantity" name="count" value="1" maxlength="4" onpaste="return false;" type="text">
								<div>
									<span id="increase" class="increase" onclick="changeQuantity(1)">&nbsp;</span>
									<span id="decrease" class="decrease"  onclick="changeQuantity(-1)">&nbsp;</span>
								</div>
							</dd>
							<dd>
								件
							</dd>
						</dl>
					<div class="buy">
							<input id="addCart" class="addCart" value="加入购物车" type="submit">
				
					</div>
				</div>
			<div id="bar" class="bar">
				<ul>
						<li id="introductionTab">
							<a href="#introduction">商品介绍</a>
						</li>
						
				</ul>
			</div>
				
				<div id="introduction" name="introduction" class="introduction">
					<div class="title">
						<strong>商品介绍</strong>
					</div>
					<div>
						<s:property value="%{model.description}"/>
					</div>
				</div>
			</form>	
				
				
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