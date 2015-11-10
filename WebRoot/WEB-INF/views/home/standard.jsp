<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>

<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx }/static/js/jqgrid/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${ctx }/static/js/jqgrid/ui.jqgrid.css" />
	
<script src="${ctx }/static/js/jqgrid/i18n/grid.locale-en.js"
	type="text/javascript"></script>
<script src="${ctx }/static/js/jqgrid/jquery.jqGrid.src.js"
	type="text/javascript"></script>

<title>职业卫生监测管理平台</title>
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
			
			<table id="list2"></table>
			<div id="pager2"></div>

			</div>
			<!-- end页面主体  -->
			
			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>

<script type="text/javascript">
	$(document).ready(
			function() {

				$("#list2").jqGrid(
						{
							url : 'standard.do',
							datatype : "json",
							colNames : [ '标准号', '中文题名', '英文题名', '发布日期', '实施日期',
									'中国标准分类', '国际标准分类','validRange','standardNoReplace','nameReplace','publisher' ],
							colModel : [ {
								name : 'standardno',
								index : 'standardno',
								width : 80,
								align : "left"
							}, {
								name : 'nameCh',
								index : 'nameCh',
								width : 150,
								align : "right"
							}, {
								name : 'nameEn',
								index : 'nameEn',
								width : 150,
								align : "right"
							}, {
								name : 'publishDate',
								index : 'publishDate',
								formatter : 'date',
								formatoptions : {
									srcformat : 'u',
									newformat : 'Y-m-d'
								},
								width : 60,
								sortable : false
							}, {
								name : 'effectDate',
								index : 'effectDate',
								formatter : 'date',
								formatoptions : {
									srcformat : 'u',
									newformat : 'Y-m-d'
								},
								width : 60,
								sortable : true
							},

							{
								name : 'typeCh',
								index : 'typeCh',
								width : 150,
								align : "right"
							}, {
								name : 'typeIso',
								index : 'typeIso',
								width : 150,
								align : "right"
							},
							
	
							
							{name:'validRange', index: 'validRange', hidden : true},
							{name:'standardNoReplace',hidden : true},
							{name:'nameReplace',hidden : true},
							{name:'publisher',hidden : true}

							],
							rowNum : 10,
							rowList : [ 10, 20, 30 ],
							height: "100%",
							ondblClickRow: function(standardno){ showDetails(standardno) },
							pager : '#pager2',
							sortname : 'id',
							viewrecords : true,
							rownumbers: true, //序号显示
							sortorder : "desc",
							caption : "环境卫生国家标准文献"
						});
				jQuery("#list2").jqGrid('navGrid', '#pager2', {
					view: true,
					edit : false,
					add : false,
					del : false
				});
			});
</script>


<script type="text/javascript">

function showDetails(id){
	
	 //获取选择一行的
	 var rowId=$('#list2').jqGrid('getGridParam','selrow');
	 //获取选择的行的数据，传入rowId：
	 var rowData = $('#list2').jqGrid('getRowData',rowId);
	 //alert(rowData.validRange);

	 var myDialog = dialog({
		 	id: 'standard-detail',
			title : '国家标准详情',
		    content: '标准号：' + rowData.standardno + '<br />'
		        	+ '中文题名：' + rowData.nameCh + '<br />'
		        	+ '英文题名：' + rowData.nameEn + '<br />'
		        	+ '发布日期：' + rowData.publishDate + '<br />'
		        	+ '实施日期：' + rowData.effectDate + '<br />'
		        	+ '中国标准分类：' + rowData.typeCh + '<br />'
		        	+ '国际标准分类：' + rowData.typeIso + '<br />'
		        	+ '适用范围：' + rowData.validRange + '<br />'
		        	+ '代替标准号：' + rowData.standardNoReplace + '<br />'
		        	+ '代替标准号名称：' + rowData.nameReplace + '<br />'
		        	+ '发布部门：' + rowData.publisher + '<br />'
		        	,
		        	

			fixed : true,
			width : 600,
			height : 400
		});
	 
	 myDialog.show();
		
};

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
