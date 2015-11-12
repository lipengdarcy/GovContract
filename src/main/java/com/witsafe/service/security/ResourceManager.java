package com.witsafe.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.security.SecResourceMapper;
import com.witsafe.model.security.SecResource;
import com.witsafe.model.security.SecResourceExample;

/**
 * 资源管理类
 */
@Component
public class ResourceManager {
	//注入资源持久化对象
	@Autowired
	private SecResourceMapper secResourceMapper;


	/**
	 * 查询所有资源记录
	 */
	public List<SecResource> getAll() {
		return secResourceMapper.selectByExample(new SecResourceExample());

	}
	
	/**
	 * 查询用户允许访问的资源
	 */
	public List<SecResource> getAllowedAccessMenu(Integer uid) {
		return secResourceMapper.selectByExample(new SecResourceExample());

	}
	
	
	
	
	
	
}
