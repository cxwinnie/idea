package cn.xuxianda.action;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.xuxianda.entity.BuyOrder;
import cn.xuxianda.entity.BuyOrderDetail;
import cn.xuxianda.service.BuyOrderService;

@Controller
@RequestMapping("/buyOrder")
public class BuyOrderAction extends BaseAction{
	
	@Autowired
	private BuyOrderService buyOrderService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(BuyOrder buyOrder,String rows){
		//rows是通过参数传进来的，也就是说是get请求，而过滤器只能过滤post请求，而不能过滤get请求，因此需要在tomcat中修改server.xml文件
		int i = 0;
		System.out.println(buyOrder);
		System.out.println(rows);
		//提供json格式数据转java对象
		ObjectMapper mapper = new ObjectMapper();
		try {
			BuyOrderDetail[] buyOrderDetails = mapper.readValue(rows, BuyOrderDetail[].class);//把json格式的数据转成对象类型
			buyOrder.setBuyOrderDetailList(Arrays.asList(buyOrderDetails));
			i = buyOrderService.insertBuyOrder(buyOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
}
