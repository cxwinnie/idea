package cn.xuxianda.dao;

import java.util.List;

import cn.xuxianda.entity.DataElement;

public interface DataElementMapper extends BaseMapper<DataElement> {
	public List<DataElement> selectAll();
}