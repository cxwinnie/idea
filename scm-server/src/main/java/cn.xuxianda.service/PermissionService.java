package cn.xuxianda.service;

import java.util.List;

import cn.xuxianda.entity.Permission;

public interface PermissionService extends BaseService<Permission> {
	List<Permission> findPermissionByLoginId(Integer accLoginId, String type);
}
