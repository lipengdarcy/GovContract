<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>
<script type="text/javascript"
	src="${ctx}/static/js/demo.formelements.js"></script>
<title>待办任务</title>
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

				<!--1.待办任务 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">待办任务<font color="red">[共:${majorTotal }项]&nbsp;&nbsp;</font>
						</span>
					</div>
					<div class="mws-panel-body">
						<table class="mws-datatable-fn mws-table">
							<thead>
								<tr>
									<th>流程名称</th>
									<th>流程编号</th>
									<th>流程启动时间</th>
									<th>任务名称</th>
									<th>任务创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${majorWorks}" var="item">
									<tr class="gradeA">
										<td>${item.processName}&nbsp;</td>
										<td>${item.orderNo}&nbsp;</td>
										<td>${item.orderCreateTime}&nbsp;</td>
										<td>${item.taskName}&nbsp;</td>
										<td>${item.taskCreateTime}&nbsp;</td>
										<td><a
											href="${ctx}/snaker/process/display?processId=${item.processId }&orderId=${item.orderId} "
											class="btnPict" title="查看流程图">查看流程图</a> <a
											href="${ctx}${empty item.instanceUrl ? item.actionUrl : item.instanceUrl }?processId=${item.processId }&taskId=${item.taskId}&orderId=${item.orderId} "
											class="btnEdit" title="处理">处理</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--1.待办任务 end -->

				<!--2.协办任务 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">协办任务<font color="red">[共:${aidantTotal }项]&nbsp;&nbsp;</font>
						</span>
					</div>
					<div class="mws-panel-body">
						<table class="mws-datatable-fn mws-table">
							<thead>
								<tr>
									<th>流程名称</th>
									<th>流程编号</th>
									<th>流程启动时间</th>
									<th>任务名称</th>
									<th>任务创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${aidantWorks}" var="item">
									<tr class="gradeA">
										<td>${item.processName}&nbsp;</td>
										<td>${item.orderNo}&nbsp;</td>
										<td>${item.orderCreateTime}&nbsp;</td>
										<td>${item.taskName}&nbsp;</td>
										<td>${item.taskCreateTime}&nbsp;</td>
										<td><a
											href="${ctx}/snaker/process/display?processId=${item.processId }&orderId=${item.orderId} "
											class="btnPict" title="查看流程图">查看流程图</a> <a
											href="${ctx}${empty item.instanceUrl ? item.actionUrl : item.instanceUrl }?processId=${item.processId }&taskId=${item.taskId}&orderId=${item.orderId} "
											class="btnEdit" title="处理">处理</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--2.协办任务 end -->

				<!--3.抄送任务 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">抄送任务<font color="red">[共:${ccorderTotal }项]&nbsp;&nbsp;</font>
						</span>
					</div>
					<div class="mws-panel-body">
						<table class="mws-datatable-fn mws-table">
							<thead>
								<tr>
									<th>流程名称</th>
									<th>流程编号</th>
									<th>流程启动时间</th>
									<th>任务名称</th>
									<th>任务创建时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${ccorderWorks}" var="item">
									<tr class="gradeA">
										<td>${item.processName}&nbsp;</td>
										<td>${item.orderNo}&nbsp;</td>
										<td>${item.orderCreateTime}&nbsp;</td>
										<td>${item.taskName}&nbsp;</td>
										<td>${item.taskCreateTime}&nbsp;</td>
										<td><a
											href="${ctx}/snaker/process/display?processId=${item.processId }&orderId=${item.orderId} "
											class="btnPict" title="查看流程图">查看流程图</a> <a
											href="${ctx}${empty item.instanceUrl ? item.actionUrl : item.instanceUrl }?processId=${item.processId }&taskId=${item.taskId}&orderId=${item.orderId} "
											class="btnEdit" title="处理">处理</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--3.抄送任务 end -->

			</div>

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
