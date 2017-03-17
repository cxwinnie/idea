package cn.xuxianda.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuxianda.service.StoreHouseService;

@Controller
@RequestMapping("/storeHouse")
public class StoreHouseAction extends BaseAction {

	@Autowired
	private StoreHouseService storeHouseService;
	
	@RequestMapping("/selectAll")
	@ResponseBody
	public Object selectAll(){
		return storeHouseService.selectAll();
	}
	
}
