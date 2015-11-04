package com.witsafe.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.witsafe.dao.security.SecMenuMapper;
import com.witsafe.model.security.SecMenu;
import com.witsafe.model.security.SecMenuExample;

/**
 * 菜单管理类
 * @author lipeng
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
	
	/**
	 * 获取菜单
	 * @return
	 */
	public SecMenu get(Integer id) {
		return secMenuMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 保存菜单
	 * @return
	 */
	public int save(SecMenu record) {
		return secMenuMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 删除菜单
	 * @return
	 */
	public int delete(Integer id) {
		return secMenuMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据用户ID查询该用户允许访问的所有菜单列表
	 * @param userId
	 * @return
	 */
	public List<SecMenu> getAllowedAccessMenu(Integer userId) {
		return secMenuMapper.getAllowedAccessMenu(userId);
	}
	
	
	
	
}
