<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPEHTMLPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<c:set var="proPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${proPath}/jquery-easyui-1.3.5/themes/default/easyui.css">
<link rel="stylesheet"type="text/css"href="${proPath}/jquery-easyui-1.3.5/themes/icon.css">
<script type="text/javascript"src="${proPath}/jquery-easyui-1.3.5/jquery.min.js"></script>
<script type="text/javascript"src="${proPath}/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${proPath}/jquery-easyui-1.3.5/local/easyui-lang-zh_CN.js"></script></head>

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma"content="no-cache">
<meta http-equiv="cache-control"content="no-cache">
<meta http-equiv="expires"content="0">
<meta http-equiv="keywords"content="keyword1,keyword2,keyword3">
<meta http-equiv="description"content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
$(function(){alert("可以使用了!");});
</script>
</head>

<body>
<div id="p" class="easyui-panel" title="My Panel"     
        style="width:500px;height:150px;padding:10px;background:#fafafa;"   
        data-options="iconCls:'icon-save',closable:true,    
                collapsible:true,minimizable:true,maximizable:true">   
    <p>panel content.</p>   
    <p>panel content.</p>   
</div>  
</body>
</html>
