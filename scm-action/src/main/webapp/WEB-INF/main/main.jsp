<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <script type="text/javascript">
		$(function() {
			$("a[title]").click(function() {
				var text = this.href;
				if($("#tt").tabs("exists",this.title)){
					$("#tt").tabs("select",this.title);
				}else{
					$('#tt').tabs('add',{
						title: this.title,
						closable: true,
						content : "<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px'/>"
					});
				}
				return false;
			});
		});
		
		function fileUpload(a){
			if(a.value!=""){
				$.ajaxFileUpload({
					 url: '${pageContext.request.contextPath}/file/upLoadFile', //用于文件上传的服务器端请求地址
                     secureuri : false, //是否需要安全协议，一般设置为false
                     fileElementId : 'upload', //文件上传域的ID
                     dataType: 'text', //返回值类型 一般设置为json
                     success : function(data,status){
                     	var imgSrc = $("#headImage").attr("src");
                     	imgSrc = imgSrc +"?r="+Math.random();
                     	$("#headImage").attr("src",imgSrc);
                     }
				});
			}
		}
	</script>
    
  </head>
  
    <body class="easyui-layout">   
	    <div data-options="region:'north',title:'欢迎使用本系统',split:true" style="height:100px;">
	    	欢迎您：${sessionScope.account.accLogin}
	    	<img id="headImage" src="${pageContext.request.contextPath }/file/getHeadImage" style="height: 50px;width: 50px">
	    	<input id="upload" type="file" name="file" onchange="fileUpload(this)">
	    </div>   
	    
	    <div data-options="region:'west',title:'导航菜单',split:true" style="width:100px;">
	    	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">   
			    <div title="基础数据录入">   
					<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
					<ul style="list-style: none;padding: 0px;margin:0px;">
						<li style="padding: 6px;">
							<a title="供应商管理" href="${proPath}/base/goURL/supplier/supplierlist"
							style="text-decoration: none;display: block;font-weight:bold;">供应商管理</a>
						</li>
						<li style="padding: 6px;">
							<a title="商品管理" href="${proPath}/base/goURL/goods/goodslist"
							style="text-decoration: none;display: block;font-weight:bold;">商品管理</a>
						</li>
					</ul>
			    </div>   
			    <div title="采购管理">
					<!-- list-style: none去左边的点；text-decoration: none：去超链接下划线,title用来区分后继定位这里的超链接 -->
					<ul style="list-style: none;padding: 0px;margin:0px;">
						<li style="padding: 6px;"><a href="${proPath}/base/goURL/buyorder/goodsInsert" title="商品采购"
							style="text-decoration: none;display: block;font-weight:bold;">商品采购</a>
						</li>
						<li style="padding: 6px;"><a href="${proPath}/base/goURL/goods/goodslist" title="商品退货"
							style="text-decoration: none;display: block;font-weight:bold;">商品退货</a>
						</li>
					</ul>
				</div>  
			    <div title="Title3">   
			        content3    
			    </div>   
			</div>  
	    </div>   
	    
	    <div data-options="region:'center',title:'主要信息'"
					style="padding:5px;background:#eee;">
			<div id="tt" class="easyui-tabs" style="width:100%;height:100%;" data-options="fit:true">
				<div title="Tab1" style="padding:20px;display:none;">tab1</div>
			</div>
		</div>
		
		<div id ="win"></div>
		
	</body>  
</html>
