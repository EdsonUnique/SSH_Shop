<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.user==null">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user/user_loginUI">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user/user_registerUI">注册</a>|
					</li>
				</s:if>
				<s:else>
					<li id="headerUsername" class="headerUsername"  style="display: list-item;">
						<s:property value="%{#session.user.username}"/>
					</li>
					<li id="headerUsername" class="headerUsername"  style="display: list-item;">
						<a href="${pageContext.request.contextPath}/order/order_showOrders">我的订单</a>
					</li>
					<li id="headerLogout" class="headerLogout"  style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user/user_logout">[退出]</a>|
					</li>
				</s:else>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath}/cart/cart_cartUI">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath }/shopIndex/shopIndex_showIndex">首页</a>
						|
					</li>
					<s:iterator var="categories"  value="%{#session.categories }">
						<li>
							<a href="${pageContext.request.contextPath }/category/categorysecond_searchSecondCategory?first_id=${categories.id}">
								<s:property value="%{#categories.name}"/>
							</a>
							|
						</li>
					
					</s:iterator>
					
		</ul>
	</div>
	