package cn.xuxianda.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuxianda.entity.Goods;
import cn.xuxianda.entity.Page;
import cn.xuxianda.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
	
	@Autowired
	private GoodsService goodsService;	
	
	//通过关键字分页查询
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Goods> page,Goods goods){
		page.setParamEntity(goods);
		System.out.println("----page:"+page);
		page = goodsService.selectPageUseDyc(page);
		return page.getMap();
	}
	
}
