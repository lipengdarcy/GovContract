<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>

<div id="mws-sidebar-stitch"></div>
<div id="mws-sidebar-bg"></div>
<div id="mws-sidebar">
	<div id="mws-searchbox" class="mws-inset">
		<form action="">
			<input type="text" class="mws-search-input" /> <input type="submit"
				class="mws-search-submit" />
		</form>
	</div>
	<div id="mws-navigation">
		<ul>
			<li><a href="${ctx }/home" class="mws-i-24 i-home">主页</a></li>
			<li><a href="${ctx }/snaker/task/active"
				class="mws-i-24 i-day-calendar">待办任务</a></li>
			<li class="active"><a href="#" class="mws-i-24 i-list">流程管理</a>
				<ul>
					<li><a href="${ctx }/snaker/task/active">待办任务</a></li>
					<li><a href="${ctx }/snaker/flow/order">流程实例</a></li>
					<li><a href="${ctx }/snaker/task/history">历史任务</a></li>
					<li><a href="${ctx }/snaker/process/list">流程定义</a></li>
					<li><a href="${ctx }/snaker/surrogate/list">委托授权</a></li>
				</ul></li>
			<li class="active"><a href="#" class="mws-i-24 i-list">组织机构</a>
				<ul>
					<li><a href="${ctx }/home/organizationPage">组织机构</a></li>
					<li><a href="${ctx }/home/standardPage">国家标准</a></li>
				</ul></li>
			<li class="active"><a href="#" class="mws-i-24 i-list">权限管理</a>
				<ul>
					<li><a href="${ctx }/security/user">用户管理</a></li>
					<li><a href="${ctx }/security/org">部门管理</a></li>
					<li><a href="${ctx }/security/role">角色管理</a></li>
					<li><a href="${ctx }/security/authority">权限管理</a></li>
					<li><a href="${ctx }/security/resource">资源管理</a></li>
				</ul></li>



			<li><a href="${ctx }/static/icons.html"
				class="mws-i-24 i-pacman"> Icons <span class="mws-nav-tooltip">2000+</span>
			</a></li>
		</ul>
	</div>
</div>