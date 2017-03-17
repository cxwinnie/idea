package cn.xuxianda.dao;

import java.util.List;

import cn.xuxianda.entity.Page;

public interface BaseMapper<T>{
	//添加单个对象
	public int insert(T entity);
	
	//修改单个对象
	public int update(T entity);
	
	//删除单个对象
	public int delete(T entity);
	
	//查询单个对象
	public T select(T entity);
	
	//通过关键字分页查询
	public List<T> selectPageList(Page<T> page);
	
	//通过关键字查询总记录数
	public Long selectPageCount(Page<T> page);
	
	//通过关键字分页查询
	public List<T> selectPageListUseDyc(Page<T> page);
		
	//通过关键字查询总记录数
	public Long selectPageCountUseDyc(Page<T> page);
	
	public int deleteByIds(Long[] ids);
}
