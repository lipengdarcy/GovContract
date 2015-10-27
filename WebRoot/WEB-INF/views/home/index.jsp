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
								<div id="memberPager"></div>
								<input type="BUTTON" id="addAccount" value="新增组员" />
							</li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div class="main-mask" id="coor-panel-mask"></div>
	<%@ include file="/WEB-INF/includes/footer.jsp"%>

</body>

<script type="text/javascript">
	//树节点的最大id值，用于连续增加节点时候判断
	var maxid = $
	{
		maxid
	};

	$(document).ready(function() {	
		
		$("#memberTable").jqGrid({
			url : 'home/getOrgMembers.do',
			datatype : "json",
			colNames : [ '用户名', '真实姓名', '电话', '手机' ],
			colModel : [ {
				name : 'name',
				index : 'name',
				width : 80,
				editable:true,editoptions:{size:25},
				align : "left"
			}, {
				name : 'realname',
				index : 'realname',
				width : 150,
				editable:true,editoptions:{size:25},
				align : "right"
			}, {
				name : 'phone',
				index : 'phone',
				width : 150,
				editable:true,editoptions:{size:25},
				align : "right"
			},

			{
				name : 'mobile',
				index : 'mobile',
				width : 150,
				editable:true,editoptions:{size:25},
				align : "right"
			}

			],
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			height : "100%",
			ondblClickRow : function(standardno) {
				showDetails(standardno)
			},
			pager : '#memberPager',
			treeGrid: true, 
			ExpandColumn : 'name', 
			editurl:'home/addAccount.do',
			sortname : 'id',
			viewrecords : true,
			rownumbers : true, //序号显示
			sortorder : "desc",
			caption : "组织成员列表"
		});
		jQuery("#memberTable").jqGrid('navGrid', '#memberPager', {
			edit : false,
			add : false,
			del : false
		});
		
		//新增组员
		$("#addAccount").click(function(){ 
			jQuery("#memberTable").jqGrid('editGridRow',"new",{height:280,reloadAfterSubmit:false}); 
		});

		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		//查询机构
		var orgList = [];
		$.ajax({
			url : 'home/queryOrg.do',
			data : {},
			type : 'post',
			dataType : 'json',

			success : function(data) {
				var r = data.result;
				for (var i = 0; i < r.length; i++) {
					var item = {
						id : r[i].id,
						pId : r[i].pid,
						name : r[i].name
					};
					orgList[i] = item;
				}
				//初始化树节点
				$.fn.zTree.init($("#treeDemo"), setting, orgList);

				//hsArtDialog.content("机构总数：" + data.length).showModal();
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});

	});

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

	//获取组织的所有成员
	function getOrgMembers(id) {		
		//刷新数据
		$("#memberTable").jqGrid("setGridParam", { postData: {orgid:id} }).trigger("reloadGrid");
	}

	var setting = {
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			selectedMulti : false
		},
		edit : {
			enable : true,
			editNameSelectAll : true
		//showRemoveBtn : showRemoveBtn,
		//showRenameBtn : showRenameBtn
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick,
			beforeDrag : beforeDrag,
			beforeEditName : beforeEditName,
			beforeRemove : beforeRemove,
			beforeRename : beforeRename,
			onRemove : onRemove,
			onRename : onRename
		}
	};

	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	function beforeEditName(treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		return true;
		//return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
	}
	function beforeRemove(treeId, treeNode) {

		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.selectNode(treeNode);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	}

	//删除组织
	function onRemove(e, treeId, treeNode) {
		delOrg(treeNode.id);
	}
	function beforeRename(treeId, treeNode, newName, isCancel) {
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			setTimeout(function() {
				zTree.editName(treeNode)
			}, 10);
			return false;
		}
		return true;
	}

	//编辑组织名称
	function onRename(e, treeId, treeNode, isCancel) {
		editOrg(treeNode.id, treeNode.name);
	}
	function showRemoveBtn(treeId, treeNode) {
		//最后一个节点不显示删除按钮 
		return !treeNode.isFirstNode;
	}
	function showRenameBtn(treeId, treeNode) {
		//最后一个节点不显示编辑按钮 
		return !treeNode.isLastNode;
	}

	//新增下级组织
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
			return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='增加下级组织' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_" + treeNode.tId);
		if (btn)
			btn.bind("click", function() {
				var newid = maxid + 1;
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {
					id : newid,
					pId : treeNode.id,
					name : "新增下级组织"
				});

				addOrg(newid, treeNode.id, "新增下级组织");
				return false;
			});
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.tId).unbind().remove();
	};

	function beforeClick(treeId, treeNode, clickFlag) {
		return (treeNode.click != false);
	}
	//点击节点，查询该组织的人员信息
	function onClick(event, treeId, treeNode, clickFlag) {
		//alert(treeNode.id);
		getOrgMembers(treeNode.id);
	}
</script>
</html>