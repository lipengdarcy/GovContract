<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
	
<div id="mws-sidebar-stitch"></div>
<div id="mws-sidebar-bg"></div>
<div id="mws-sidebar">
	<div id="mws-searchbox" class="mws-inset">
		<form
			action="">
			<input type="text" class="mws-search-input" /> <input type="submit"
				class="mws-search-submit" />
		</form>
	</div>
	<div id="mws-navigation">
		<ul>
			<li><a href="dashboard.html" class="mws-i-24 i-home">Dashboard</a></li>
			<li><a href="charts.html" class="mws-i-24 i-chart">Charts</a></li>
			<li><a href="calendar.html" class="mws-i-24 i-day-calendar">Calendar</a></li>
			<li><a href="files.html" class="mws-i-24 i-file-cabinet">File
					Manager</a></li>
			<li><a href="table.html" class="mws-i-24 i-table-1">Table</a></li>
			<li class="active"><a href="#" class="mws-i-24 i-list">Forms</a>
				<ul>
					<li><a href="${ctx }/home">主页</a></li>
					<li><a href="form_elements.html">Elements</a></li>
				</ul></li>
			<li><a href="widgets.html" class="mws-i-24 i-cog">Widgets</a></li>
			<li><a href="typography.html" class="mws-i-24 i-text-styling">Typography</a></li>
			<li><a href="grids.html" class="mws-i-24 i-blocks-images">Grids
					&amp; Panels</a></li>
			<li><a href="gallery.html" class="mws-i-24 i-polaroids">Gallery</a></li>
			<li><a href="error.html" class="mws-i-24 i-alert-2">Error
					Page</a></li>
			<li><a href="icons.html" class="mws-i-24 i-pacman"> Icons <span
					class="mws-nav-tooltip">2000+</span>
			</a></li>
		</ul>
	</div>
</div>