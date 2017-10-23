<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>蔬菜 - Powered By Mango Team</title>
		<meta name="author" content="Mango Team">
		<meta name="copyright" content="Mango">
			<meta name="keywords" content="蔬菜">
			<meta name="description" content="蔬菜">
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css">

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
</div>
<div class="container productList">
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
			
			<form id="productForm" action="${pageContext.request.contextPath}/image/蔬菜 - Powered By Mango Team.htm" method="get">
				<input type="hidden" id="brandId" name="brandId" value="">
				<input type="hidden" id="promotionId" name="promotionId" value="">
				<input type="hidden" id="orderType" name="orderType" value="">
				<input type="hidden" id="pageNumber" name="pageNumber" value="1">
				<input type="hidden" id="pageSize" name="pageSize" value="20">
					
				<div id="result" class="result table clearfix">
						<ul>
							<s:iterator var="cproducts" value="%{page.pageData}">
								<s:iterator var="cproduct" value="%{#cproducts}">
								<li>
										<a href="${pageContext.request.contextPath}/product/product_showDetail?id=${cproduct.id}">
											<img src="${pageContext.request.contextPath}/${cproduct.image}" width="170" height="170"  style="display: inline-block;">
											   
											<span style='color:green'>
											${cproduct.name }
											</span>
											 
											<span class="price">
												亿家价： ￥${cproduct.shop_price }/份
											</span>
											 
										</a>
									</li>
								</s:iterator>
							</s:iterator>			
						
									
						</ul>
				</div>
	<div class="pagination">
		共[${page.totalRecord }]条记录&nbsp;&nbsp;&nbsp;&nbsp;共[${page.totalPage }]页
			
			<a class="firstPage" href="${pageContext.request.contextPath}${page.path }?pagenum=1&first_id=${ fid}&second_id=${sid}">&nbsp;</a>
			
			<a class="previousPage" href="${pageContext.request.contextPath}${page.path}?pagenum=${page.currentPage-1 }&first_id=${fid}&second_id=${sid}">&nbsp;</a>
			
				<span class="currentPage">${page.currentPage }</span>
				
			<a class="nextPage" href="${pageContext.request.contextPath}${page.path}?pagenum=${page.currentPage+1 }&first_id=${ fid}&second_id=${sid}">&nbsp;</a>
			
			<a class="lastPage" href="${pageContext.request.contextPath}${page.path}?pagenum=${page.totalPage }&first_id=${fid}&second_id=${sid}">&nbsp;</a>
			
	</div>
			</form>
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
						<a >诚聘英才</a>
						|
					</li>
					<li>
						<a >法律声明</a>
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
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a >SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body></html>