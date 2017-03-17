<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <style type="text/css">
    	.searchbox{
    		margin-top: -2px;
    	}
    </style>
    <script type="text/javascript">
    	$(function(){
	    	$('#dg').datagrid({    
			    //url:'${proPath}/supplier/selectPage.action',     //通过关键字查询
			    url:'${proPath}/supplier/selectPageUseDyc',
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
								parent.$('#win').window({    
								    width:600,    
								    height:400,    
								    modal:true,
								    content:"<iframe src='${proPath}/base/goURL/supplier/supplierInsert' height='100%' width='100%' frameborder='0px' ></iframe>"  
								});
							}
				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler:function(){
								var array = $('#dg').datagrid('getSelections');
								if(array.length==0 || array.length>1){
									alert("只能选中一行");
								}else{
									var supId = array[0].supId;
									parent.$('#win').window({    
									    width:600,    
									    height:400,    
									    modal:true,
									    content:"<iframe src='${proPath}/base/goURL/supplier/supplierEdit' height='100%' width='100%' frameborder='0px' ></iframe>"  
									});
								}
							}
				},'-',{
				iconCls : 'icon-remove',
				text : '删除',
				handler : function() {
						//$("#dg").datagrid("getSelections")
						//获取选中的记录
						var array = $("#dg").datagrid("getSelections");
						//alert(array);
						//判断是否选中
						if (array.length > 0) {
						//定义数组，通过下边的用来存储选中记录的Id
							var ids = new Array();
							for (i = 0; i < array.length; i++) {
								ids[i] = array[i].supId;
								//alert(ids[i]);
							}
							//alert("ids" + ids);
							//如果需要锁整个页面，前面加parent.
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {//r（点击确定返回true，否则返回false）
								if (r) {
									alert(r);
									$.ajax({
									  url: "${proPath}/supplier/deleteList",
									  type:"POST",
									  //设置为传统方式传送参数
									  traditional:true,
									  data:{ids:ids},
									  success: function(html){
									  //重新刷新页面
									    $("#dg").datagrid("reload");
									    //请除所有勾选的行
									    $("#dg").datagrid("clearSelections");//没有此行，会把之前选过的id都记录起来，第一次删除若干个个，第二次删除其他的数据还会把第一次的的关键字带进去
									  },
									  error: function (XMLHttpRequest, textStatus, errorThrown) {
										    $.messager.alert('删除错误','请联系管理员！','error');
										},
									  dataType:'json'
									});
								}
							});
	
						} else {
							$.messager.show({
								title : '操作提示',
								msg : '请先选择要删除的记录。',
								timeout : 4000,
								showType : 'slide'
							});
	
						}
	
					}
				},'-',{
					text:"名称:<input id='supName' name='supName'></input> ",
				},'-',{
					text:"地址:<input id='supAddress' name='supAddress'></input> ",
				}],
			    fitColumns:true,  //加了这个就不会显示滚动条
			    columns:[[
			    	{checkbox:true},    
			    	{field:'supId',title:'ID',width:100,hidden:true},
			        {field:'supName',title:'供应商名称',width:100},    
			        {field:'supLinkman',title:'供应商联系人',width:100},    
			        {field:'supPhone',title:'联系电话',width:100},
			        {field:'supAddress',title:'供应商住址',width:100},
			        {field:'supRemark',title:'供应商评价',width:100},
			        {field:'supPay',title:'供应商预付',width:100},
			        {field:'supType',title:'供应商类型',width:100,
			        	formatter: function(value,row,index){
			        		var str= '${applicationScope.sysParam.supType}';//{3=普通供应商, 2=二级供应商, 1=一级供应商}
			        		return valueToText(str,value)
						}
			        }
			    ]],
			    pageSize : 5,
			     queryParams: {
					supName : "%%",
					supAddress : "%%"
				}, 
			    pagination : true,
			    striped : true,
			    pageList : [2,5,10,20,50,100],
			    rownumbers : true,
			    checkOnSelect : true,
			    idField:'supId'
			}); 
			
			$('#supAddress').searchbox({ 
				searcher:function(value,name){ 
					var supAddress = $("#supAddress").val();
					$('#dg').datagrid('load',{
						supName : "%"+$("#supName").val()+"%",
						supAddress : "%"+supAddress+"%"
					});
				}, 
				prompt:'' 
			});
			
			/*  通过关键字查询
				$('#ss').searchbox({ 
				searcher:function(value,name){ 
				alert(value + "," + name) 
				}, 
				menu:'#mm', 
				prompt:'Please Input Value' 
			});  */				    	
    	});
    </script>
    
  </head>
  
  <body>
  	<table id="dg"></table>  
  </body>
</html>
