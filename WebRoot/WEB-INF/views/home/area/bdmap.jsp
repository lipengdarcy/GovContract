<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/commons/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>百度地图</title>

<%@ include file="/WEB-INF/includes/header.jsp"%>
<style type="text/css">
	body, html{width: 100%;height: 100%;margin:0;}
	#allmap {height: 500px;width:100%;overflow: hidden;}
	#result {width:100%;font-size:12px;}
	dl,dt,dd,ul,li{
		margin:0;
		padding:0;
		list-style:none;
	}
	dt{
		font-size:14px;
		font-weight:bold;
		border-bottom:1px dotted #000;
		padding:5px 0 5px 5px;
		margin:5px 0;
	}
	dd{
		padding:5px 0 0 5px;
	}
	li{
		line-height:28px;
	}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=40159f4141eaaaea4163c9c998905c6b"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
<title>百度地图位置显示</title>
</head>
<body>
<ul>
<c:forEach var="areaItems" items="${saleadressList }">
	<li><span class="area-item" xy-point="${areaItems.worktime }">${areaItems.address }</span></li>
</c:forEach>
</ul>
	<div id="allmap">	
	</div>
	<div id="result">
		<input type="button" value="默认样式" onclick="searchInfoWindow.open(marker);"/>
		<input type="button" value="样式1" onclick="openInfoWindow1()"/>
		<input type="button" value="样式2" onclick="openInfoWindow2()"/>
		<input type="button" value="样式3" onclick="openInfoWindow3()"/>
	</div>
<script type="text/javascript">
 

//百度地图API功能
	var map = new BMap.Map('allmap');
	var poi = new BMap.Point(116.307852,40.057031);
	map.centerAndZoom(poi, 16);
	map.enableScrollWheelZoom();

	
	

    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="../img/baidu.jpg" alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
                    '地址：北京市海淀区上地十街10号<br/>电话：(010)59928888<br/>简介：百度大厦位于北京市海淀区西二旗地铁站附近，为百度公司综合研发及办公总部。' +
                  '</div>';

    //创建检索信息窗口对象
    var searchInfoWindow = null;
	searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
			title  : "百度大厦",      //标题
			width  : 290,             //宽度
			height : 105,              //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[
				BMAPLIB_TAB_SEARCH,   //周边检索
				BMAPLIB_TAB_TO_HERE,  //到这里去
				BMAPLIB_TAB_FROM_HERE //从这里出发
			]
		});
    var marker = new BMap.Marker(poi); //创建marker对象
    marker.enableDragging(); //marker可拖拽
    marker.addEventListener("click", function(e){
	    searchInfoWindow.open(marker);
    })
    map.addOverlay(marker); //在地图中添加marker
	//样式1
	var searchInfoWindow1 = new BMapLib.SearchInfoWindow(map, "信息框1内容", {
		title: "信息框1", //标题
		panel : "panel", //检索结果面板
		enableAutoPan : true, //自动平移
		searchTypes :[
			BMAPLIB_TAB_FROM_HERE, //从这里出发
			BMAPLIB_TAB_SEARCH   //周边检索
		]
	});
	function openInfoWindow1() {
		searchInfoWindow1.open(new BMap.Point(116.319852,40.057031));
	}
	//样式2
	var searchInfoWindow2 = new BMapLib.SearchInfoWindow(map, "信息框2内容", {
		title: "信息框2", //标题
		panel : "panel", //检索结果面板
		enableAutoPan : true, //自动平移
		searchTypes :[
			BMAPLIB_TAB_SEARCH   //周边检索
		]
	});
	function openInfoWindow2() {
		searchInfoWindow2.open(new BMap.Point(116.324852,40.057031));
	}
	//样式3
	var searchInfoWindow3 = new BMapLib.SearchInfoWindow(map, "信息框3内容", {
		title: "信息框3", //标题
		width: 290, //宽度
		height: 40, //高度
		panel : "panel", //检索结果面板
		enableAutoPan : true, //自动平移
		searchTypes :[
		]
	});
	function openInfoWindow3() {
		searchInfoWindow3.open(new BMap.Point(116.328852,40.057031)); 
	}
	
	$(".area-item").bind("click",function(e){
		var src=e.target;
		var item=$(src).closest("[xy-point]");
		var xyPoint=item.attr("xy-point");
		var xy=xyPoint.split(",");
		if(xy.length>1){
			var npoi=new BMap.Point(xy[0],xy[1]);
			 var nmarker = new BMap.Marker(npoi); //创建marker对象
			    nmarker.enableDragging(); //marker可拖拽
			    nmarker.addEventListener("click", function(e){
			    	searchInfoWindow2.open(nmarker);
			    })
			    map.addOverlay(nmarker); //在地图中添加marker
				searchInfoWindow2.open(npoi);
		}
		
	});
</script>
</body>
</html>