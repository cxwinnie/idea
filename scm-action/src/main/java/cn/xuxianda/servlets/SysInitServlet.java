package cn.xuxianda.servlets;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SysInitServlet extends HttpServlet {

	public void init() throws ServletException {
		Map<String,Object> sysParam = new HashMap<String,Object>();
		Map<String,String> supType = new HashMap<String,String>();
    	supType.put("1", "普通供应商");
    	supType.put("2", "一级供应商");
    	supType.put("3", "二级供应商");
    	
    	Map<String,String> goodsColor = new HashMap<String,String>();
    	goodsColor.put("red", "红色");
    	goodsColor.put("green", "绿色");
    	goodsColor.put("blue", "蓝色");    	
    	
    	sysParam.put("goodsColor", goodsColor);
    	sysParam.put("supType", supType);
    	ServletContext application =this.getServletContext();
    	application.setAttribute("sysParam",sysParam);
    	//{supType={3=二级供应商, 2=一级供应商, 1=普通供应商}, goodsColor={red=红色, blue=蓝色, green=绿色}}
		System.out.println("=======初始化完成，已加载数据字典数据=======");
	}
	
}
