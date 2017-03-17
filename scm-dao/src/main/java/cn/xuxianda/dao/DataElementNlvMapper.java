package cn.xuxianda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xuxianda.entity.DataElementNlv;

public interface DataElementNlvMapper extends BaseMapper<DataElementNlv>{
	public List<DataElementNlv> selectByFK(@Param(value = "dataElementId") Long dataElementId);
}