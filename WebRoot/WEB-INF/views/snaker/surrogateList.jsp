<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>
<script src="${ctx}/static/js/table.js" type="text/javascript"></script>

<title>委托授权管理</title>
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
						<span class="mws-i-24 i-list">委托授权查询</span>
					</div>
					<div class="mws-panel-body">


						<form class="mws-form" action="${ctx}/snaker/surrogate"
							method="get">
							<input type="hidden" name="pageNo" id="pageNo"
								value="${page.pageNo}" />
							<div class="mws-form-inline">
								<div class="mws-form-row">
									<label>资源名称：</label>
									<div class="mws-form-item small">
										<input type="text" class="mws-textinput"
											name="filter_LIKES_name"
											value="${param['filter_LIKES_name']}" />
									</div>
								</div>

							</div>
							<div class="mws-button-row">
								<shiro:hasPermission name="PROCESSDEPLOY">
									<input type="button" value="新建" class="mws-button green"
										onclick="addNew('${ctx}/snaker/surrogate/create')" />
								</shiro:hasPermission>
								<input type='submit' class="mws-button black" value='查询' />
							</div>
						</form>
					</div>
				</div>




				<!--1.委托授权管理 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">查询结果<font color="red">[共:${page.totalCount}项]&nbsp;&nbsp;</font>
						</span>
					</div>
					<div class="mws-panel-body">
						<table class="mws-datatable-fn mws-table">
							<thead>
								<tr>
									<th>流程名称</th>
									<th>授权人</th>
									<th>代理人</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${page.result}" var="surrogate">
									<tr>
										<td class="td_list_2" align=left nowrap>
											${surrogate.processName}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${surrogate.operator}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${surrogate.surrogate}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${surrogate.sdate}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${surrogate.edate}&nbsp;</td>
										<td class="td_list_2" align=left nowrap><a
											href="${ctx}/snaker/surrogate/delete/${surrogate.id }"
											class="btnDel" title="删除" onclick="return confirmDel();">删除</a>
											<a href="${ctx}/snaker/surrogate/update/${surrogate.id }"
											class="btnEdit" title="编辑">编辑</a> <a
											href="${ctx}/snaker/surrogate/view/${surrogate.id }"
											class="btnView" title="查看">查看</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--1.委托授权管理 end -->

			</div>

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
