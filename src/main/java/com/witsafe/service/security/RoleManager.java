package com.witsafe.service.security;

import java.util.List;

import com.witsafe.dao.security.SecRoleMapper;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.model.security.SecRole;
import com.witsafe.model.security.SecRoleExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 角色管理类
 */
@Component
public class RoleManager {
	//注入角色持久化对象
	@Autowired
	private SecRoleMapper secRoleMapper;
	//注入用户管理对象
	@Autowired
	private UserManager userManager;

	
	/**
	 * 获取单个角色
	 */
	public SecRole getById(Integer id) {
		return secRoleMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取所有角色
	 */
	public List<SecRole> getAll() {
		return secRoleMapper.selectByExample(new SecRoleExample() );
	}
	
	/**
	 * 获取单个角色
	 */
	public int delete(Integer id) {
		return secRoleMapper.deleteByPrimaryKey(id);
	}
}
