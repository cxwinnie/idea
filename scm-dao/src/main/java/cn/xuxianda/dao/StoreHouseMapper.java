package cn.xuxianda.dao;

import java.util.List;

import cn.xuxianda.entity.StoreHouse;

public interface StoreHouseMapper extends BaseMapper<StoreHouse>{
	public List<StoreHouse> selectAll();
}