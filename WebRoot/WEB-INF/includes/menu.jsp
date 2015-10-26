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
		<li navid=19><i></i><a href="user_center.html?&navid=19">个人资料</a></li>
		<li navid=18><i></i><a href="my_cart.html?&navid=18">我的购物车</a></li>
		<li navid=12><i></i><a href="${ctx }/order/queryOrder.do?&navid=12">我的订单</a>
			<ul>
				<li navid=121><a href="${ctx }/order/queryOrder.do?&navid=121">全部订单</a></li>
				<li navid=122><a href="${ctx }/order/queryOrder.do?orderstate=4&navid=122">待付款</a></li>
				<li navid=123><a href="${ctx }/order/queryOrder.do?orderstate=8&navid=123">待收货</a></li>
				<li navid=124><a href="${ctx }/order/queryOrder.do?orderstate=10&navid=124">待评价</a></li>
			</ul>
		</li>
		<li navid=14><i></i><a href="${ctx }/ucenter/favoriteproductlist.do?&navid=14">商品收藏</a></li>
		<li navid=15><i></i><a href="${ctx }/ucenter/commentlist.do?&navid=15">商品评价</a></li>
		
        <li><i></i><a href="javascript:void(0);">个人设置</a>
          <ul>
            <li navid=10><a href="${ctx }/ucenter/userinfo.do?&navid=10">个人资料</a></li>
            <li navid=13><a href="${ctx }/ucenter/shipaddresslist.do?&navid=13">管理收货地址</a></li>
            <li navid=11><a href="${ctx }/ucenter/safeinfo.do?&navid=11">安全中心</a></li>
          </ul>
        </li>

		<c:if test="${account_session_isfacuser!=1}">
			<li>
				<a href="${ctx }/business/applyFactoryUserPage.do">
					<span style="color: red">申请为工厂用户</span>
				</a>
			</li>
		</c:if>

		

	</ul>
</div>
<!--01-->


<script type="text/javascript">
var navid = GetQueryString('navid');		
		//菜单变红效果 
		$("[navid='"+navid+"']").addClass("active");
		</script>
<!--03-->
