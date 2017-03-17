package cn.xuxianda.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

import cn.xuxianda.entity.DataElement;
import cn.xuxianda.entity.DataElementNlv;
import cn.xuxianda.service.DataElementNlvService;
import cn.xuxianda.service.DataElementService;

@Controller
@RequestMapping("/init")
public class Init{

	@Autowired
	private DataElementService dataElementService;
	@Autowired
	private DataElementNlvService dataElementNlvService;
	
	@RequestMapping("/initParam")
	public void initParam(HttpServletRequest request){}
	
}
