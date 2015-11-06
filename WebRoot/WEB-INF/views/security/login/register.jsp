<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<%@ include file="/WEB-INF/includes/header.jsp"%>
<link href="${ctx }/themes/default/css/account.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#registerForm").validationEngine({
			maxErrorsPerField : 1,
			onValidationComplete : function(form, status) {
				if (status) {

				}
			}
		});
	})
	var register = function() {
		var $form = $("#registerForm");
		var msg = validateForm($form);
		//弹窗提示配置
		var hsArtDialog = dialog({
			title : '提示',
			id : "hs-dialog",
			fixed : true,
			width : 300,
			height : 50
		});
		if (msg.length > 0) {
			hsArtDialog.content(msg).showModal();
			return;
		}
		var username = $.trim($form.find("#myname").val());
		var password = $.trim($form.find("#password").val());
		var mobile = $.trim($form.find("#mobile").val());
		var verifyCode = $.trim($form.find("#verifyCode").val());
		$.ajax({
			url : url + 'account.do?method=doRegister',// 跳转到 action    
			data : {
				verifyCode : verifyCode,
				username : username,
				mobile : mobile,
				password : password
			},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if (data.state == 'success') {
					location.href = url + "index.do";
				} else {
					hsArtDialog.content(data.msg).showModal();
				}
			},
			error : function() {
				hsArtDialog.content("异常！请重新尝试或者联系管理员！").showModal();
			}
		});
	}, validateForm = function($form) {
		var s = "";
		var name = $.trim($form.find("#myname").val());
		if (name == '') {
			s += "用户名不能为空！\n";
		}
		var password = $.trim($form.find("#password").val());
		var confirmPwd = $.trim($form.find("#confirmPwd").val());
		if (password == '') {
			s += "密码不能为空！\n";
		}
		if (password != confirmPwd) {
			s += "确认密码不一致！\n";
		}
		var verifyCode = $.trim($form.find("#verifyCode").val());
		if (verifyCode == '') {
			s += "验证码不能为空!";
		}
		return s;
	};
</script>
</head>
<body>
	<div id="loginTop" class="box">
		<a href="${ctx }/home" class="left"><img
			src="${ctx }/themes/default/images/logo2.png" width="186" height="42" /></a>
		<h2>用户注册</h2>
		<div class="clear"></div>
	</div>

	<div class="regTitle box">
		我已经注册，现在就 <a href="${ctx }/login" class="Fblue">登录</a>
	</div>
	<div class="reg box">
		<form id="registerForm" action="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th width="190"><em>*</em>用户名：</th>
					<td width="275"><input type="text" id="myname" value=""
						class="text userName validate[required,custom[onlyLetterNumber],minSize[6],maxSize[20]],custom[allnumber]" /></td>
					<td>用户名长度为6-20位</td>
				</tr>
				<tr class="succ_on">
					<th><em>*</em>请设置密码：</th>
					<td><input type="password" id="password" value=""
						class="text passWord validate[required]" /></td>
					<td>密码长度为6-20位</td>
				</tr>
				<tr class="succ_on">
					<th><em>*</em>请确认密码：</th>
					<td><input type="password" id="confirmPwd" value=""
						class="text passWord validate[required,confirm[#password]]" /></td>
					<td></td>
				</tr>
				<tr class="succ_on">
					<th>手机号码：</th>
					<td><input type="text" id="mobile" value=""
						class="text validate[custom[phone]]" /></td>
					<td>请输入11位有效的手机号码</td>
				</tr>
				<tr class="succ_on">
					<th width="190"><em>*</em>验证码：</th>
					<td width="275"><input type="text" id="verifyCode" value=""
						class="text userName validate[required]" /></td>
					<td><img id="verifyImage" style="cursor: hand" height="34"
						title="点击刷新验证码"
						onclick="this.src='${ctx}/tool/verifyimage.do?time=' + new Date()"
						src="${ctx }/tool/verifyimage.do" /></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td><a href="#" class="regBt redBT" onclick="register()">同意以下注册协议</a></td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
