package com.witsafe.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.security.SecAuthorityMapper;
import com.witsafe.dao.security.SecAuthorityResourceMapper;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.model.security.SecAuthority;
import com.witsafe.model.security.SecAuthorityExample;
import com.witsafe.model.security.SecAuthorityResource;
import com.witsafe.model.security.SecAuthorityResourceExample;
import com.witsafe.model.security.SecResource;

/**
 * 权限管理类
 * @author lipeng
 */
@Component
public class AuthorityManager {
	@Autowired
	private SecAuthorityMapper secAuthorityMapper;
	@Autowired
	private SecAuthorityResourceMapper secAuthorityResourceMapper;
	
	
	@Autowired
	private RoleManager roleManager;
	
	
	/**
	 * 获取单个权限记录
	 */
	public SecAuthority getById(Integer id) {
		return secAuthorityMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取所有权限记录
	 */
	public List<SecAuthority> getAll() {
		return secAuthorityMapper.selectByExample(new SecAuthorityExample());
	}
	
	/**
	 * 根据资源获取权限
	 */
	public List<SecAuthority> getByResource(SecResource resource) {
		SecAuthorityResourceExample e =new SecAuthorityResourceExample();
		e.or().andResourceIdEqualTo(resource.getId());
		List<SecAuthorityResource> list = secAuthorityResourceMapper.selectByExample(e);		
		
		List<Integer> values = new ArrayList();
		for(SecAuthorityResource s:list)
			values.add(s.getAuthorityId());
		SecAuthorityExample e2 = new SecAuthorityExample();
		e2.or().andIdIn(values);
		return secAuthorityMapper.selectByExample(new SecAuthorityExample());
	}
	
	
}
