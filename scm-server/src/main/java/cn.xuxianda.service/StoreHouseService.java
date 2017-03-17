package cn.xuxianda.service;

import java.util.List;

import cn.xuxianda.entity.StoreHouse;

public interface StoreHouseService extends BaseService<StoreHouse> {
	public List<StoreHouse> selectAll();
}
