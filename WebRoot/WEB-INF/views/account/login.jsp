<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<%@ include file="/WEB-INF/includes/home/header.jsp"%>
<link href="${ctx }/themes/default/css/account.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<input type="hidden" id="return_url_h" value="${returnUrl }" />
	<div id="loginTop" class="box">
		<a href="${ctx }/index.do" class="left"><img
			src="${ctx }/themes/default/images/logo1.png" width="186" height="42" /></a>
		<h2>欢迎登陆</h2>
		<div class="clear"></div>
	</div>
	<div class="box login">
		<a href="${ctx }/account/register.do" class="loginREG">免费注册</a> <img
			src="${ctx }/upload/advert/ad_1411271729304777423.png" width="461"
			height="355" class="left" />

		<div class="right">
			<form id="form" action="">

				<dl>
					<dt>邮箱/用户名/已验证手机</dt>
					<dd>
						<input type="text" name="name"
							class="userName text validate[required]" value="" />
					</dd>
				</dl>

				<dl>
					<dt>密码</dt>
					<dd>
						<input type="password" name="password"
							class="passWord text validate[required]" value="" />
					</dd>
				</dl>


				<dl>
					<dt>验证码</dt>
					<dd>
						<input type="text" name="verifyCode"
							class="YZM text left validate[required]" /><img id="verifyImage"
							style="cursor: hand" height="34" title="点击刷新验证码"
							onclick="this.src='${ctx}/tool/verifyimage.do?time=' + new Date()"
							src="${ctx }/tool/verifyimage.do" />
						<div class="clear"></div>
					</dd>
				</dl>

				<div class="loginBt">
					<!-- 
		        <label><input name="isRemember" type="checkbox" style="vertical-align:-2px; margin-right:3px;" value="1" />自动登陆 &nbsp; &nbsp; </label>
		         -->
					<a href="${ctx }/account/findpwd.do">忘记密码?</a> <a
						href="javascript:void(0)" class="redBT loginIn" onclick="login()">登
						&nbsp; 录</a>
				</div>

			</form>
		</div>
		<div class="clear"></div>
	</div>

</body>

<script type="text/javascript">
	$(function() {
		//回车事件检测
		document.onkeydown = function(e) {
			var ev = document.all ? window.event : e;
			if (ev.keyCode == 13) {
				login();
			}
		};
		//检查后提交
		$("#form").validationEngine({
			onValidationComplete : function(form, status) {
				if (status) {
					login();
				}
			}
		});
	});

	function login() {
		var $form = $("#form");
		var postdata = $form.serialize();
		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		$.ajax({
			url : 'account/login.do',
			data : postdata,
			type : 'post',
			dataType : 'json',
			success : function(data) {
				hsArtDialog.content(data.content).showModal();
				
				if (data.state == 'success') {					
					var returnUrl = $("#return_url_h").val();
					if (returnUrl != '') {
						returnUrl = decodeURIComponent(returnUrl);
					} else {
						returnUrl = "home.do";
					}
					location.href = returnUrl;
				} 
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});
	}
</script>
</html>
