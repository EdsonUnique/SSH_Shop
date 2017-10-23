<%@ page language="java" import="java.util.Date" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1"
		 action="${pageContext.request.contextPath}${model.id==null?'/product/product_addProduct':'/product/product_updateProduct' }" enctype="multipart/form-data" method="post">
			&nbsp;
			<input type="hidden" name="id" value="<s:property value='%{model.id}'/>">
			<input type="hidden" name="date" value="<%=new Date().toLocaleString()%>">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>${model.id==null?'添加商品':'修改商品'}</STRONG>
						</strong>
					</td>
				</tr>
				
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<s:actionmessage theme="simple"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="name" value="<s:property value='%{model.name}'/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 商城价：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shop_price" value="<s:property value='%{model.shop_price}'/>" id="logonPwd"/>
					</td>

				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 市场价：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="market_price" value="<s:property value='%{model.market_price}'/>" id="logonPwd"/>
					</td>

				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 描述：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<textarea rows="3" cols="50" name="description">
							<s:property value="%{model.description}"/>
						</textarea>
					</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 图片：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="file" name="p_image">
					</td>

				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 是否为热门商品：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="is_hot">
							<option></option>
							<option value="0" ${model.is_hot==0?'selected':'' }>否</option>
							<option value="1" ${model.is_hot==1?'selected':'' }>是</option>
						</select>
					</td>

				<tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						所属二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="csid">
							<option></option>
							<s:iterator value="css" var="cs">
								<option value="<s:property value="#cs.id"/>" ${model.csecond.id==cs.id?'selected':'' }>
									<s:property value="#cs.name"/>
								</option>
							</s:iterator>
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