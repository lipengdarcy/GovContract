<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>
<!doctype html>
<html lang="en">
<head>
<title>Top</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<link href="${ctx}/static/css/snaker/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div class="logo"><img src="${ctx }/static/css/images/snaker.png" alt="Snaker"/></div>
    <ul class="qj">
      <li style="width: 100px;"><span><shiro:principal/></span></li>
      <li></li>
      <li class="top_aqtc" ><a href="javascript:void(0)" onclick="window.parent.location.href='${ctx }/logout'">安全退出<b></b></a></li>
    </ul>
  </div>

<div id="admin-nav-wrap">
  <div class="admin-nav">
    <ul>
      <li><a href="${ctx }/home" target="_blank">回到首页</a></li>
    </ul>
  </div>
</div>

</body>
</html>