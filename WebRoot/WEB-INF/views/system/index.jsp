<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/includes/commons/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<title>Snaker流程管理</title>
</head>
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${ctx }/home/top" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset id="myFrame" cols="230,7,*" frameborder="no" border="0" framespacing="0">
    <frame src="${ctx }/home/left" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="${ctx }/home/middle" name="midlleFrame" scrolling="no" noresize="noresize" id="midlleFrame" title="midlleFrame" />
	<frame src="${ctx }/snaker/task/active" name="mainFrame" scrolling="auto" noresize="noresize" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
</html>

