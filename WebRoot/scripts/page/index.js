

$(document).ready(function() {
	


	$("#memberTable").jqGrid({
		url : 'home/getOrgMembers.do',
		datatype : "json",
		colNames : [ 'id', 'orgid', '用户名', '真实姓名', '电话', '手机' ],
		colModel : [ {
			name : 'id',
			index : 'id',
			width : 80,
			editable : true,
			editoptions : {
				size : 25
			},
			hidden : true

		}, {
			name : 'orgid',
			index : 'orgid',
			width : 80,
			editable : true,
			editoptions : {
				size : 25
			},
			hidden : true

		}, {
			name : 'name',
			index : 'name',
			width : 80,
			editable : true,
			editoptions : {
				size : 25
			},
			align : "left"
		}, {
			name : 'realname',
			index : 'realname',
			width : 150,
			editable : true,
			editoptions : {
				size : 25
			},
			align : "right"
		}, {
			name : 'phone',
			index : 'phone',
			width : 150,
			editable : true,
			editoptions : {
				size : 25
			},
			align : "right"
		},

		{
			name : 'mobile',
			index : 'mobile',
			width : 150,
			editable : true,
			editoptions : {
				size : 25
			},
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
		ExpandColumn : 'name',
		editurl : 'home/operateAccount.do',
		sortname : 'id',
		viewrecords : true,
		rownumbers : true, //序号显示
		sortorder : "desc",
		caption : "组织成员列表"
	});

	$('#memberTable').navGrid('#memberPager',
	// the buttons to appear on the toolbar of the grid
	{
		edit : true,
		add : true,
		del : true,
		search : true,
		refresh : true,
		view : true,
		position : "left",
		cloneToTop : false
	},
	// options for the Edit Dialog
	{
		editCaption : "账户信息编辑",
		recreateForm : true,
		checkOnUpdate : true,
		checkOnSubmit : true,
		closeAfterEdit : true,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Add Dialog
	{
		closeAfterAdd : true,
		recreateForm : true,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Delete Dailog
	{
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
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
function addOrg(pid, name) {

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
			pid : pid,
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
	$("#memberTable").jqGrid("setGridParam", {
		postData : {
			orgid : id
		}
	}).trigger("reloadGrid");
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
			+ "' title='新增下级组织' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.addNodes(treeNode, {
				id : 0,
				pId : treeNode.id,
				name : "新增下级组织"
			});

			addOrg(treeNode.id, "新增下级组织");
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
