<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- Required Stylesheets -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/reset.css" media="screen" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/text.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/fonts/ptsans/stylesheet.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/fluid.css" media="screen" />

<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/mws.style.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/icons/icons.css" media="screen" />

<!-- Demo and Plugin Stylesheets -->
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/demo.css"
	media="screen" />

<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/colorpicker/colorpicker.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/jimgareaselect/css/imgareaselect-default.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/fullcalendar/fullcalendar.css"
	media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/fullcalendar/fullcalendar.print.css"
	media="print" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/tipsy/tipsy.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/sourcerer/Sourcerer-1.2.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/jgrowl/jquery.jgrowl.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/plugins/spinner/spinner.css" media="screen" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/jui/jquery.ui.css" media="screen" />

<!-- Theme Stylesheet -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/css/mws.theme.css" media="screen" />

<!-- JavaScript Plugins -->

<script type="text/javascript"
	src="${ctx}/static/js/jquery-1.7.1.min.js"></script>

<script type="text/javascript"
	src="${ctx}/static/plugins/jimgareaselect/jquery.imgareaselect.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.dualListBox-1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.filestyle.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/fullcalendar/fullcalendar.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.dataTables.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="plugins/flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript"
	src="${ctx}/static/plugins/flot/jquery.flot.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/flot/jquery.flot.pie.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/flot/jquery.flot.stack.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/flot/jquery.flot.resize.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/colorpicker/colorpicker.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/tipsy/jquery.tipsy.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/sourcerer/Sourcerer-1.2.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.placeholder.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.validate.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/jquery.mousewheel.js"></script>
<script type="text/javascript"
	src="${ctx}/static/plugins/spinner/ui.spinner.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery-ui.js"></script>

<script type="text/javascript" src="${ctx}/static/js/mws.js"></script>
<script type="text/javascript" src="${ctx}/static/js/demo.js"></script>
<script type="text/javascript" src="${ctx}/static/js/themer.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("div#mws-login .mws-login-back").mouseover(function(event) {
			$(this).find("a").animate({'left':0})
		}).mouseout(function(event) {
			$(this).find("a").animate({'left':70})
		});
	});
</script>

<title>用户登录</title>

</head>

<body>

	<div id="mws-login">
		<h1>用户登录</h1>
		<div class="mws-login-lock">
			<img src="${ctx}/static/css/icons/24/locked-2.png" alt="" />
		</div>
		<div id="mws-login-form">

			<form class="mws-form" action="${ctx }/login" method="post">
				<div class="mws-form-row">
					<div class="mws-form-item large">
						<input type="text" name="username" value="admin"
							class="mws-login-username mws-textinput" placeholder="用户名" />
					</div>
				</div>
				<div class="mws-form-row">
					<div class="mws-form-item large">
						<input type="password" name="password" value="123456"
							class="mws-login-password mws-textinput" placeholder="密码" />
					</div>
				</div>
				<div class="mws-form-row">
					<input type="submit" value="登录"
						class="mws-button green mws-login-button" />
				</div>
			</form>

		</div>

		<div id="mws-login-form">

			<p></p>
			<p>
				没有账号? <a href="register">注册</a>
			<p>
				忘记密码? <a href="findpwd1">找回密码</a>
			</p>

		</div>
	</div>



</body>
</html>
