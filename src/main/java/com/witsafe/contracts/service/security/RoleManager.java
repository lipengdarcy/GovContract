package com.witsafe.contracts.service.security;

import java.util.List;

import com.snakerflow.framework.orm.Page;
import com.snakerflow.framework.orm.PropertyFilter;
import com.witsafe.contracts.dao.security.SecRoleMapper;
import com.witsafe.contracts.model.security.SecRole;
import com.witsafe.contracts.model.security.SecRoleExample;

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
	 * 获取所有角色记录
	 * @return
	 */
	public List<SecRole> getAll() {
		return secRoleMapper.selectByExample(new SecRoleExample() );
	}
}
