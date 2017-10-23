<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add(0,-1,'后台管理');
		d.add(100,0,'用户管理');
		
		//子目录添加
		d.add(101,100,'查看所有用户','${pageContext.request.contextPath}/admin/user_listAdminUser','','mainFrame');
		d.add(200,0,'订单管理');
		d.add(201,200,'查看所有订单','${pageContext.request.contextPath}/order/order_viewAllOrders','','mainFrame');
		d.add(300,0,'一级分类管理');
		d.add(301,300,'查看一级分类','${pageContext.request.contextPath}/category/category_viewAllCategory','','mainFrame');
		d.add(400,0,'二级分类管理');
		d.add(401,400,'查看二级分类','${pageContext.request.contextPath}/category/categorysecond_viewAllCategorySecond','','mainFrame');
		d.add(500,0,'商品管理')
		d.add(501,500,'查看所有商品','${pageContext.request.contextPath}/product/product_viewAllProduct','','mainFrame');
		
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
