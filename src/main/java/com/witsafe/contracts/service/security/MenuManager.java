package com.witsafe.contracts.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.contracts.dao.security.SecMenuMapper;
import com.witsafe.contracts.model.security.SecMenu;
import com.witsafe.contracts.model.security.SecMenuExample;

/**
 * 菜单管理类
 * @author yuqs
 * @since 0.1
 */
@Component
public class MenuManager {
	//注入菜单持久化对象
	@Autowired
	private SecMenuMapper secMenuMapper;
	//注入资源管理对象
	@Autowired
	private ResourceManager resourceManager;

	
	/**
	 * 获取所有菜单
	 * @return
	 */
	public List<SecMenu> getAll() {
		return secMenuMapper.selectByExample(new SecMenuExample());
	}
	
	
}
