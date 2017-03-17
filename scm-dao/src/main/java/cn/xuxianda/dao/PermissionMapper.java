package cn.xuxianda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xuxianda.entity.Permission;

public interface PermissionMapper extends BaseMapper<Permission>{
	List<Permission> findPermissionByLoginId(@Param("accLoginId") Integer accLoginId, @Param("type") String type);
}