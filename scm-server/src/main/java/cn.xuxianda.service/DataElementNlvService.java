package cn.xuxianda.service;

import java.util.List;

import cn.xuxianda.entity.DataElementNlv;

public interface DataElementNlvService extends BaseService<DataElementNlv> {
	public List<DataElementNlv> findAllByFK(Long dataElementId);
}
