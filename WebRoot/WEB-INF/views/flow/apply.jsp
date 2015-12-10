<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>通用工作流程</title>
		<%@ include file="/WEB-INF/includes/commons/meta.jsp"%>
		<link rel="stylesheet" href="${ctx}/static/css/snaker/style.css" type="text/css" media="all" />
		<script src="${ctx}/static/js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="${ctx}/static/js/snaker/snaker.util.js" type="text/javascript"></script>
	</head>

	<body>
		<form id="inputForm" action="${ctx }/snaker/flow/process" method="post" target="mainFrame">
			<input type="hidden" name="processId" value="${processId }" />
			<input type="hidden" name="orderId" value="${orderId }" />
			<input type="hidden" name="taskId" value="${taskId }" />
			<table class="table_all" align="center" border="0" cellpadding="0"
			cellspacing="0" style="margin-top: 0px">
				<tr>
					<td class="td_table_1"><span>编写人：</span></td>
					<td class="td_table_2" colspan="3">
						<input type="text" class="input_240" readonly="readonly" name="S_apply.operator" value="${operator  }" />
					</td>
				</tr>
				<tr>
					<td class="td_table_1"><span>备注：</span></td>
					<td class="td_table_2" colspan="3">
						<textarea class="input_textarea_320" id="reason" name="remark"></textarea>
					</td>
				</tr>
				
				<tr>
					<td class="td_table_1"><span>审批人：</span></td>
					<td class="td_table_2" colspan="3">
						<input type="text" class="input_240" name="S_approve.operator" value="${operator }" />
					</td>
				</tr>
				<tr>
					<td class="td_table_1"><span>发送给：</span></td>
					<td class="td_table_2" colspan="3">
						<input type="text" class="input_240" name="S_content" value="${operator }" />
					</td>
				</tr>
				
			</table>
			<table align="center" border="0" cellpadding="0"
				cellspacing="0">
				<tr align="left">
					<td colspan="1">
						<input type="submit" class="button_70px" name="submit" value="提交">
						&nbsp;&nbsp;
						<input type="button" class="button_70px" name="reback" value="返回"
							onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
