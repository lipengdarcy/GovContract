<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<script type="text/javascript">
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}		
</script>
<!--01-->
<div class="user-menu-list">
	<div class="user-tab">功能菜单</div>
	<ul id="memberNav">
		<li navid=10><i></i><a href="${ctx }/home.do?&navid=10">组织机构</a></li>
		<li navid=11><i></i><a href="${ctx }/home/standardPage.do?&navid=11">国家标准</a></li>
		<li navid=12><i></i><a href="${ctx }/home/index.do?&navid=12">工作流</a></li>
	</ul>
</div>
<!--01-->


<script type="text/javascript">
var navid = GetQueryString('navid');		
		//菜单变红效果 
		$("[navid='"+navid+"']").addClass("active");
		</script>
<!--03-->
