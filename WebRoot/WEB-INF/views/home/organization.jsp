<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>
<script type="text/javascript"
	src="${ctx}/static/js/demo.formelements.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/ztree/jquery.ztree.exedit-3.5.js"></script>



<link rel="stylesheet" href="${ctx}/static/css/ztree/demo.css"
	type="text/css">
<link rel="stylesheet"
		href="${ctx}/static/css/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
		
<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top;
	*vertical-align: middle
}
</style>

<script type="text/javascript" src="${ctx }/static/js/page/organization.js"></script>
<script type="text/javascript" >
$(document).ready(function() {	
	alert("grid page init!");
	});
</script>

<title>组织机构</title>
</head>

<body>
	<!-- 页面顶部 -->
	<%@ include file="/WEB-INF/includes/header.jsp"%>

	<div id="mws-wrapper">

		<!-- 页面左侧菜单 -->
		<%@ include file="/WEB-INF/includes/menu.jsp"%>


		<div id="mws-container" class="clearfix">
			<!-- begin页面主体  -->
			<div class="container">

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
			<!-- end页面主体  -->

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
