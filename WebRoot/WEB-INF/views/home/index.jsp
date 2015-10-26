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
			src="${ctx }/scripts/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="${ctx }/scripts/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="${ctx }/scripts/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript"
	src="${ctx }/scripts/ztree/jquery.ztree.exedit-3.5.js"></script>
	
<SCRIPT type="text/javascript">
	
</SCRIPT>
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
							<li class="title"><h2>
									1、beforeEditName<br />&nbsp;&nbsp;beforeRemove / onRemove<br />&nbsp;&nbsp;beforeRename
									/ onRename 事件回调函数控制
								</h2>
								<ul class="list">
									<li>此 Demo 演示合理利用自定义控件、事件回调函数配合以增强用户体验，操作时可以对比"基本 增 / 删 /
										改 节点"的 Demo</li>
									<li>此 Demo 实现增加节点按钮</li>
									<li>此 Demo 实现删除节点时进行确认</li>
									<li>此 Demo 利用 showRenameBtn 对 isLastNode = true 的节点不显示编辑按钮</li>
									<li>此 Demo 利用 showRemoveBtn 对 isFirstNode = true
										的节点不显示删除按钮</li>
									<li class="highlight_red">可以利用 beforeEditName 触发自定义的编辑操作</li>
									<li><p>
											<span class="highlight_red">在对这些灵活的配置熟悉以后，相信你能够做出更加合理的编辑界面！</span><br />
											&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="selectAll"
												checked /> 编辑名称时是否全选 text<br /> remove / rename
											log:&nbsp;&nbsp;<span style="color: red">红色</span> 表示取消编辑操作
											(v3.5.13+)<br />
											<ul id="log" class="log"></ul>
										</p></li>
								</ul></li>
							<li class="title"><h2>2、setting 配置信息说明</h2>
								<ul class="list">
									<li>同 "基本 增 / 删 / 改 节点"</li>
								</ul></li>
							<li class="title"><h2>3、treeNode 节点数据说明</h2>
								<ul class="list">
									<li>同 "基本 增 / 删 / 改 节点"</li>
								</ul></li>
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

	$(document).ready(function() {
		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		//查询机构
		
		$.ajax({
			url : 'home/queryOrg.do',
			data : {},
			type : 'post',
			dataType : 'json',

			success : function(data) {
				orgList = data;
				for(i=0;i<data.length; i++){
					var item = {id:data[i].id, pId:data[i].pid, name:data[i].name};
					orgList[i] = item;
				}
				//hsArtDialog.content("机构总数：" + data.length).showModal();
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});

		//初始化树节点
		$.fn.zTree.init($("#treeDemo"), setting, orgList);
		$("#selectAll").bind("click", selectAll);
	});

	//新增机构
	function addOrg() {
		var $form = $("#form");
		var postdata = $form.serialize();
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
			data : postdata,
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
	
	var setting = {
			view : {
				addHoverDom : addHoverDom,
				removeHoverDom : removeHoverDom,
				selectedMulti : false
			},
			edit : {
				enable : true,
				editNameSelectAll : true,
				showRemoveBtn : showRemoveBtn,
				showRenameBtn : showRenameBtn
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			callback : {
				beforeDrag : beforeDrag,
				beforeEditName : beforeEditName,
				beforeRemove : beforeRemove,
				beforeRename : beforeRename,
				onRemove : onRemove,
				onRename : onRename
			}
		};
		
		var orgList = [];

		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			className = (className === "dark" ? "" : "dark");
			showLog("[ " + getTime() + " beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; "
					+ treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "" : "dark");
			showLog("[ " + getTime() + " beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
					+ treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ " + getTime() + " onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; "
					+ treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName, isCancel) {
			className = (className === "dark" ? "" : "dark");
			showLog((isCancel ? "<span style='color:red'>" : "") + "[ " + getTime()
					+ " beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name
					+ (isCancel ? "</span>" : ""));
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
		function onRename(e, treeId, treeNode, isCancel) {
			showLog((isCancel ? "<span style='color:red'>" : "") + "[ " + getTime()
					+ " onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name
					+ (isCancel ? "</span>" : ""));
		}
		function showRemoveBtn(treeId, treeNode) {
			return !treeNode.isFirstNode;
		}
		function showRenameBtn(treeId, treeNode) {
			return !treeNode.isLastNode;
		}
		function showLog(str) {
			if (!log)
				log = $("#log");
			log.append("<li class='"+className+"'>" + str + "</li>");
			if (log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
					.getSeconds(), ms = now.getMilliseconds();
			return (h + ":" + m + ":" + s + " " + ms);
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
				return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
					+ "' title='增加子节点' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_" + treeNode.tId);
			if (btn)
				btn.bind("click", function() {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.addNodes(treeNode, {
						id : (100 + newCount),
						pId : treeNode.id,
						name : "new node" + (newCount++)
					});
					return false;
				});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_" + treeNode.tId).unbind().remove();
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll = $("#selectAll").attr("checked");
		}
</script>
</html>