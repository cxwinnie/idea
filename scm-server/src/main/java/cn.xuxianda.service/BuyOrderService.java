package cn.xuxianda.service;

import cn.xuxianda.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder> {
	
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception; 
	
}
