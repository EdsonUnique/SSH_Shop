<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}${model.id==null?'/category/categorysecond_addCategorySecond':'/category/categorysecond_updateCategorySecond' }" method="post" >
			&nbsp;
			<input type="hidden" name="id" value="<s:property value='%{model.id}'/>">
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
&#28155;&#21152;
</button>

						</td>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>${model.id==null?'添加二级分类':'修改二级分类'}</STRONG>
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
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 二级分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="name" value="<s:property value='%{model.name}'/>" id="logonPwd"/>
					</td>

				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">
						 所属一级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="fid" >
							<s:iterator value="fss"  var="first">
								<option value="${first.id }" ${model.cfirst.id==first.id?'selected':''}>${first.name }</option>
							</s:iterator>
						</select>
					</td>
				</tr>
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