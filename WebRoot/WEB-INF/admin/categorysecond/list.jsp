<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function addUser(){
				window.location.href = "${pageContext.request.contextPath}/category/categorysecond_addCategorySecondUI";
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
							<strong>二级分类列表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="&#28155;&#21152;" class="button_add" onclick="addUser()">
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

									<td align="center" width="18%">
										编号
									</td>
									<td align="center" width="17%">
										一级分类名称
									</td>
									<td align="center" width="17%">
										所属二级分类名称
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								 <s:actionmessage theme="simple"/>
								<s:iterator value="pb.pageData" var="categorysecond">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="%{#categorysecond.id}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="%{#categorysecond.name}"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="%{#categorysecond.cfirst.name}"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/category/categorysecond_updateCategorySecondUI?sid=${categorysecond.id}&name=<s:property value='%{#categorysecond.name}'/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/category/categorysecond_deleteCategorySecond?id=${categorysecond.id}">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>
									<tr 
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: white">

									<td align="center" width="18%" colspan="5">
										第<s:property value="pb.currentPage"/>/<s:property value="pb.totalPage"/>页&nbsp;&nbsp;
										[<a href="${pageContext.request.contextPath }<s:property value="pb.path"/>">首页</a>]
										<s:if test="pb.currentPage<pb.totalPage">
										[<a href="${pageContext.request.contextPath }<s:property value="pb.path"/>?pagenum=${pb.currentPage+1}">下一页</a>]
										</s:if>
										<s:if test="pb.currentPage>1">
										[<a href="${pageContext.request.contextPath }<s:property value="pb.path"/>?pagenum=${pb.currentPage-1}">上一页</a>]
										</s:if>
										[<a href="${pageContext.request.contextPath }<s:property value="pb.path"/>?pagenum=${pb.totalPage}">尾页</a>]
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

