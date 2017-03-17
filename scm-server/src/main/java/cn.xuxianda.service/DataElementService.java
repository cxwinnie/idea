package cn.xuxianda.service;

import java.util.List;

import cn.xuxianda.entity.DataElement;

public interface DataElementService extends BaseService<DataElement> {
	public List<DataElement> findAll();
}
