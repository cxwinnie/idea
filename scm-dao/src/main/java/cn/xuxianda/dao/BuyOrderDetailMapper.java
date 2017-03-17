package cn.xuxianda.dao;

import java.util.List;

import cn.xuxianda.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail>{
	public int insertList(List<BuyOrderDetail> list);
}