<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>
<script src="${ctx}/static/js/table.js" type="text/javascript"></script>

<title>流程定义</title>
</head>

<body>

	<!-- 页面顶部 -->
	<%@ include file="/WEB-INF/includes/header.jsp"%>



	<div id="mws-wrapper">

		<!-- 页面左侧菜单 -->
		<%@ include file="/WEB-INF/includes/menu.jsp"%>

		<!-- 页面主体  -->
		<div id="mws-container" class="clearfix">
			<div class="container">

				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-list">流程定义查询</span>
					</div>
					<div class="mws-panel-body">


						<form class="mws-form" action="${ctx}/snaker/process/list"
							method="get">
							<input type="hidden" name="pageNo" id="pageNo"
								value="${page.pageNo}" />
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>流程名称：</label>
									<div class="mws-form-item small">
										<input type="text" class="mws-textinput" name="displayName"
											value="${param['displayName']}" />
									</div>
								</div>

							</div>
							<div class="mws-button-row">
								<shiro:hasPermission name="PROCESSDEPLOY">
									<input type="button" value="设计" class="mws-button green"
										onclick="addNew('${ctx}/snaker/process/designer')" />
									<input type="button" value="部署" class="mws-button red"
										onclick="addNew('${ctx}/snaker/process/deploy')" />
								</shiro:hasPermission>
								<input type='submit' class="mws-button black" value='查询' />
							</div>
						</form>
					</div>
				</div>




				<!--1.流程定义 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">查询结果<font color="red">[共:${page.totalCount}项]&nbsp;&nbsp;</font>
						</span>
					</div>
					<div class="mws-panel-body">
						<table class="mws-datatable-fn mws-table">
							<thead>
								<tr>
									<th>名称</th>
									<th>流程显示名称</th>
									<th>状态</th>
									<th>版本号</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${page.result}" var="process">
									<tr>
										<td class="td_list_2" align=left nowrap>
											${process.name}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${process.displayName}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>${process.state == 1 ? '启用' : '禁用'}&nbsp;
										</td>
										<td class="td_list_2" align=left nowrap>
											${process.version}&nbsp;</td>
										<td class="td_list_2" align=left nowrap><a
											href="${ctx}${process.instanceUrl }.do?processId=${process.id }&processName=${process.name }"
											class="btnStart" title="启动流程">启动流程</a> <shiro:hasPermission
												name="PROCESSDEPLOY">
												<a href="${ctx}/snaker/process/edit/${process.id }"
													class="btnEdit" title="编辑">编辑</a>
												<a
													href="${ctx}/snaker/process/designer?processId=${process.id }"
													class="btnDesigner" title="设计">设计</a>
												<a href="${ctx}/snaker/process/delete/${process.id }"
													class="btnDel" title="删除" onclick="return confirmDel();">删除</a>
											</shiro:hasPermission></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--1.流程定义 end -->

			</div>

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
