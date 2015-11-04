package com.witsafe.model.security;

import java.util.ArrayList;
import java.util.List;

public class SecMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3488405380107404492L;
	// 菜单资源的根菜单标识为0
	public static final Integer ROOT_MENU = 0;

	private Integer id;
	// 菜单名称
	private String name;
	// 菜单描述
	private String description;
	// 排序字段
	private Integer orderby;
	// 上级菜单id
	private Integer parentMenu;
	// 上级菜单
	private SecMenu parentMenuObject;
	// 子菜单列表（多对多关联）
	private List<SecMenu> subMenus = new ArrayList<SecMenu>();

	public SecMenu() {
	}

	/**
	 * 构造函数，参数为主键ID
	 * 
	 * @param id
	 */
	public SecMenu(Integer id) {
		this.id = id;
	}

	/**
	 * 构造函数，辅助hql查询
	 * 
	 * @param id
	 * @param name
	 * @param description
	 */
	public SecMenu(Integer id, String name, String description, Integer orderby) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.orderby = orderby;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Integer parentMenu) {
		this.parentMenu = parentMenu;
	}

	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
}