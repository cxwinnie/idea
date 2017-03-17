package cn.xuxianda.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xuxianda.entity.Page;
import cn.xuxianda.entity.Supplier;
import cn.xuxianda.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierAction{
	
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Supplier supplier){
		int i = 0;
		try {
			i = supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody
	public Object  delete(Long []ids) throws Exception{
		int i = supplierService.deleteByIds(ids);
 		return i;
	}
	
	@RequestMapping("/doAjax")
	@ResponseBody//如果返回json格式，需要这个注解，这里用来测试环境
	public Object doAjax(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier);
		supplier.setSupName("supName1");
		return supplier;
	}

	/*@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<Supplier> page){//直接把页面所有的参数存入Page实体中
		page = supplierService.selectPage(page);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotalCount());
		map.put("rows", page.getList());
		return map;
	}*/
	
	@RequiresPermissions("")
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody
	public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){//直接把页面中关于分页的参数传入page中（如属性page和rows），把需要查询的条件传入supplier
		page.setParamEntity(supplier);
		page = supplierService.selectPageUseDyc(page);
		return page.getMap();
	}

	@RequestMapping("/select")
	@ResponseBody
	public Object select(Supplier supplier){
		return supplierService.select(supplier);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Supplier supplier){
		int i = 0;
		try {
			i = supplierService.update(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
