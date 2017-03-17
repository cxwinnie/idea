<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	<script type="text/javascript">
		$(function(){
			$.ajax({
				url: '${proPath}/init/initParam'
			});
		});
	</script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/supplier/insert" method="post">
		名称：<input type="text"	name="supName"><br>
		供应商类型：
		<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
		    <c:forEach items="${applicationScope.sysParam.supType}" var="supType" >
		    	<option value="${supType.key }">${supType.value}</option>
		    </c:forEach>   
		</select>  
		<input type="submit" value="ok">
	</form>
  </body>
</html>
