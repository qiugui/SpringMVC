<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>管理信息系统</title>
<script src="${pageContext.request.contextPath }/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/js/jquery.easyui.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/easyui.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/icon.css" rel="stylesheet" type="text/css" />

<!--JS点击事件代码-->
<script language="JavaScript" src="${pageContext.request.contextPath }/js/myjs.js"></script>


<style>
.footer {
	width: 100%;
	text-align: center;
	line-height: 35px;
}

.top-bg {
	background-color: #d8e4fe;
	height: 80px;
}
</style>

</head>

<!--#############整体布局#############-->

<body class="easyui-layout">

	<!--#############北部布局#############-->

	<div region="north" border="true" split="true"
		style="overflow: hidden; height: 80px;">
		<div class="top-bg"></div>
	</div>

	<!--#############南部布局#############-->

	<div region="south" border="true" split="true"
		style="overflow: hidden; height: 40px;">
		<div class="footer">
			登录人：<a href="#">${user.username }</a>
		</div>
	</div>

	<!--#############西部列表布局##############-->

	<div region="west" split="true" title="导航菜单" style="width: 200px;">

		<div id="aa" class="easyui-accordion"
			style="position: absolute; top: 27px; left: 0px; right: 0px; bottom: 0px;">

			<div title="博文管理" selected="true" iconcls="icon-man" 
				style="overflow: auto; padding: 10px;">
				<!--无序列表-->
				<ul class="easyui-tree">
					<li><span><a href="#">查看所有用户</a></span></li>
					<li><span><a href="#">添加新用户</a></span></li>
					<li><span>Folder</span>
						<ul>

							<li><span>Sub Folder 1</span>
								<ul>

									<li><span><a href="#">File 12</a></span></li>
									<li><span>File 13</span></li>

									<li><span><a target="mainFrame"
											href="http://www.baidu.com">百度搜索</a></span></li>
								</ul></li>

							<li><span>File 2</span></li>

							<li><span>File 3</span></li>
						</ul></li>

					<li><span><a href="#">File21</a></span></li>

				</ul>

			</div>

			<div title="新闻管理" iconcls="icon-reload" style="padding: 10px;">
				content2</div>

			<div title="资源管理" iconcls="icon-large-smartart">content3</div>
		</div>

	</div>

	<!--#############主界面#############-->

	<div id="mainPanle" region="center" style="overflow: hidden;">

		<div id="tabs" class="easyui-tabs" fit="true" border="false">

			<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">

				<h1>Welcome to jQuery UI!</h1>
				<h2>当前用户：${user.username }</h2>

			</div>

		</div>


	</div>

</body>

</html>