<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>政企通讯录信息管理平台</title>




<link rel="stylesheet" type="text/css"
	href="${ctx }/themes/default/css/jquery-ui.css" />
<%@ include file="/WEB-INF/includes/header.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${ctx }/themes/default/css/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx }/themes/grey/css/user.css" />
<script type="text/javascript"
	src="${ctx }/themes/admin/xheditor/xheditor-1.2.1.min.js"></script>
<script type="text/javascript"
	src="${ctx }/themes/admin/xheditor/xheditor_lang/zh-cn.js"></script>
<script type="text/javascript"
	src="${ctx }/scripts/jquery.validationEngine-zh_CN.js"></script>
<script type="text/javascript"
	src="${ctx }/scripts/jquery.validationEngine.js"></script>




<link rel="stylesheet" href="${ctx }/themes/ztree/demo.css"
	type="text/css">
	<link rel="stylesheet"
		href="${ctx }/themes/ztree/zTreeStyle/zTreeStyle.css" type="text/css">

		<script type="text/javascript"
			src="${ctx }/scripts/ztree/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript"
			src="${ctx }/scripts/ztree/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript"
			src="${ctx }/scripts/ztree/jquery.ztree.exedit-3.5.js"></script>

		<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>

		<script type="text/javascript">

	
	</script>

		<script type="text/javascript" src="${ctx }/scripts/page/index.js"></script>
</head>
<style>
.main-mask {
	position: fixed;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	display: none;
	z-index: 100;
}
</style>
<body>
	<%@ include file="/WEB-INF/includes/headerTop.jsp"%>
	<div class="user-main">
		<div class="wrap clearfix">
			<div class="crumbs">
				<strong>| <a href="${ctx }/home.do">首页</a>
				</strong>&gt; <a href="${ctx }/home.do">组织机构</a>
			</div>
			<div class="user-menu left">
				<%@ include file="/WEB-INF/includes/menu.jsp"%>
			</div>
			<div class="user-content right">

				<div class="content_wrap">
					<div class="zTreeDemoBackground left">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
					<div class="right">
						<ul class="info">

							<li class="title"><h2>组织成员：</h2>
								<table id="memberTable"></table>
								<div id="memberPager"></div></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="main-mask" id="coor-panel-mask"></div>
	<%@ include file="/WEB-INF/includes/footer.jsp"%>

</body>


</html>