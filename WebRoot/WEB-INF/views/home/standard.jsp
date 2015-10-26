<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>国家标准</title>
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

<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx }/scripts/jqgrid/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx }/scripts/jqgrid/ui.jqgrid.css" />

<script src="${ctx }/scripts/jqgrid/i18n/grid.locale-en.js"
	type="text/javascript"></script>
<script src="${ctx }/scripts/jqgrid/jquery.jqGrid.min.js"
	type="text/javascript"></script>



</head>

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
			
				<table id="list2"></table>
				<div id="pager2"></div>



			</div>
		</div>
	</div>
	<div class="main-mask" id="coor-panel-mask"></div>
	<%@ include file="/WEB-INF/includes/footer.jsp"%>

</body>

<script type="text/javascript">
	$(document).ready(function() {

		$("#list2").jqGrid({
			url : 'standard.do',
			datatype : "json",
			colNames : [ '标准号', '中文题名', '英文题名', '发布日期' ],
			colModel : [ {

				name : 'standardno',
				index : 'standardno',
				width : 80,
				align : "left"
			}, {

				name : 'nameCh',
				index : 'nameCh',
				width : 80,
				align : "right"
			}, {

				name : 'nameEn',
				index : 'nameEn',
				width : 150,
				align : "right"
			}, {
				name : 'publishDate',
				index : 'publishDate',
				width : 200,
				sortable : false
			} ],
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : '#pager2',
			sortname : 'id',
			viewrecords : true,
			sortorder : "desc",
			caption : "环境卫生国家标准文献"
		});
		jQuery("#list2").jqGrid('navGrid', '#pager2', {
			edit : false,
			add : false,
			del : false
		});
	});
</script>


<script type="text/javascript">
	//新增机构
	function addOrg(id, pid, name) {

		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		$.ajax({
			url : 'home/addOrg.do',
			data : {
				id : id,
				pid : pid,
				name : name
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				maxid = 1 + data.result;
				hsArtDialog.content(data.content).showModal();
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});
	}

	//编辑机构名称
	function editOrg(id, name) {

		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		$.ajax({
			url : 'home/editOrg.do',
			data : {
				id : id,
				name : name
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				hsArtDialog.content(data.content).showModal();
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});
	}

	//删除机构
	function delOrg(id) {
		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		$.ajax({
			url : 'home/delOrg.do',
			data : {
				orgid : id
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				hsArtDialog.content(data.content).showModal();
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});
	}
</script>
</html>