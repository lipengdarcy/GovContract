<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<script type="text/javascript">
//搜索
function search(keyword) {
	if (keyword == undefined || keyword == null || keyword.length < 1) {
		alert("请输入关键词");		
	} else {
		window.location.href = "${ctx}/product/search.do?keyword=" + keyword;
	}
}
</script>

<!--bof top-line-->
<div class="top-line">
	<div class="wrap clearfix">
		<p class="left">
			您好，政企通讯录信息管理平台 ！
			<c:if test="${empty account_session_id}">
				<a href="javascript:void(1);" onclick="toLogin();" class="red">[
					请登录 ]</a>
				
			</c:if>
		</p>
		<ul class="right clearfix">
			<c:if test="${!empty account_session_id}">
				<li>${account_login_name }&nbsp;&nbsp;<a
					href="javascript:void(1);" onclick="logout();">[退出]</a>
				</li>								
			</c:if>
			
			<li class="top-phone"><a href="###">手机端下载</a></li>
			<li><a href="${ctx }/help/">帮助中心 </a></li>
		</ul>
	</div>
</div>
<!--eof top-line-->
<script type="text/javascript">
	var logout = function() {
		var $div = $("#headerLink");
		$div.empty();
		$.ajax({
			url : url + 'account.do?method=doLogout',
			data : {},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if (data.state == 'success') {
					var returnUrl = encodeURIComponent(location.href);
					location.href = url + "account/login.do?return_url="
							+ returnUrl;
				}
			},
			error : function() {
			}
		});

	}, toLogin = function() {
		var returnUrl = encodeURIComponent(location.href);
		location.href = url + "account/login.do?return_url=" + returnUrl;
	};
	
</script>

<!--bof header-->
<div class="header">
  <div class="wrap clearfix">
    <div class="logo left" title="政企通讯录信息管理平台">
    	<a href="${ctx}/index.do"  title="政企通讯录信息管理平台">政企通讯录信息管理平台</a>
    </div>
    
    <div class="search right">
      <form>
        <fieldset class="clearfix" >
          <input type="text" id="keyword" name="keyword"   autocomplete="off"  value='' placeholder="请输入您要查找的内容" class="s-input" 
         	onkeydown="javascript:if(event.keyCode==13) search(document.getElementById('keyword').value);"/>
          <input type="button" name=""  value="搜索" class="s-button" onclick="search(document.getElementById('keyword').value)"/>
        </fieldset>
      </form>
      
    </div>
  </div>
</div>
<!--eof header-->

