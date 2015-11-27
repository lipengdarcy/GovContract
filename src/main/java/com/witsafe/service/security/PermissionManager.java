package com.witsafe.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.security.SecPermissionMapper;
import com.witsafe.model.security.SecPermission;
import com.witsafe.model.security.SecPermissionExample;

/**
 * 权限管理类
 * @author lipeng
 */
@Component
public class PermissionManager {
	@Autowired
	private SecPermissionMapper secPermissionMapper;

	
	
	@Autowired
	private RoleManager roleManager;
	
	
	/**
	 * 获取单个权限记录
	 */
	public SecPermission getById(Integer id) {
		return secPermissionMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取所有权限记录
	 */
	public List<SecPermission> getAll() {
		return secPermissionMapper.selectByExample(new SecPermissionExample());
	}
	
	
	
	
}
