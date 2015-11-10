<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/includes/include.jsp"%>

<title>历史完成任务</title>
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

				<!--1.历史完成任务 begin -->
				<div class="mws-panel grid_8">
					<div class="mws-panel-header">
						<span class="mws-i-24 i-table-1">历史完成任务<font color="red">[共:${page.totalCount}项]&nbsp;&nbsp;</font>
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
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${page.result}" var="item">
									<tr>
										<td class="td_list_2" align=left nowrap>
											${item.processName}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${item.orderNo}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${item.orderCreateTime}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${item.taskName}&nbsp;</td>
										<td class="td_list_2" align=left nowrap>
											${item.taskCreateTime}&nbsp;</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<!--1.历史完成任务 end -->

			</div>

			<!-- 页面底部 -->
			<%@ include file="/WEB-INF/includes/footer.jsp"%>

		</div>
	</div>

</body>
</html>
