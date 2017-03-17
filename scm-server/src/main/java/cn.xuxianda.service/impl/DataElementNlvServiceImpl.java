package cn.xuxianda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.xuxianda.entity.DataElementNlv;
import cn.xuxianda.service.DataElementNlvService;

@Service
public class DataElementNlvServiceImpl extends BaseServiceImpl<DataElementNlv> implements DataElementNlvService{

	@Override
	public List<DataElementNlv> findAllByFK(Long dataElementId) {
		return dataElementNlvMapper.selectByFK(dataElementId);
	}

}
