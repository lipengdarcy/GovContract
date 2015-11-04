package com.witsafe.framework.taglibs.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.witsafe.contracts.model.security.SecMenu;
import com.witsafe.framework.common.util.ShiroUtils;
import com.witsafe.framework.taglibs.TagBuilder;
import com.witsafe.framework.taglibs.TagDTO;
import com.witsafe.service.security.MenuManager;

/**
 * 自定义菜单标签处理类。 根据当前认证实体获取允许访问的所有菜单，并输出特定导航菜单的html
 * @author yuqs
 * @since 0.1
 */
@Component
public class MenuTagBuilder implements TagBuilder {
	// Spring的上下文
	private WebApplicationContext springContext;
	// Servlet的上下文
	private ServletContext servletContext = null;

	@Override
	public String build(TagDTO dto) {
		this.servletContext = dto.getServletContext();
		this.springContext = dto.getSpringContext();
		StringBuffer buffer = new StringBuffer();
		// 获取所有可允许访问的菜单列表
		List<SecMenu> menus = getAllowedAccessMenu();
		// 循环迭代菜单列表，构成ID、List结构的Map
		Map<Integer, List<SecMenu>> menuMaps = buildMenuTreeMap(menus);
		// 根据Map构造符合左栏菜单显示的html
		buildMenuTreeFolder(buffer, menuMaps, SecMenu.ROOT_MENU);
		return buffer.toString();
	}

	/**
	 * 循环迭代菜单列表，构成ID、List结构的Map
	 * 
	 * @param menus
	 * @return
	 */
	private Map<Integer, List<SecMenu>> buildMenuTreeMap(List<SecMenu> menus) {
		Map<Integer, List<SecMenu>> menuMap = new TreeMap<Integer, List<SecMenu>>();
		for (SecMenu menu : menus) {
			/**
			 * 判断是否有上一级菜单，如果有，则添加到上一级菜单的Map中去 如果没有上一级菜单，把该菜单作为根节点
			 */
			Integer parentMenuId = menu.getParentMenu() == null ? SecMenu.ROOT_MENU
					: menu.getParentMenu();
			if (!menuMap.containsKey(parentMenuId)) {
				List<SecMenu> subMenus = new ArrayList<SecMenu>();
				subMenus.add(menu);
				menuMap.put(parentMenuId, subMenus);
			} else {
				List<SecMenu> subMenus = menuMap.get(parentMenuId);
				subMenus.add(menu);
				menuMap.put(parentMenuId, subMenus);
			}
		}
		return menuMap;
	}

	/**
	 * 获取当前登录账号所有允许访问的菜单列表
	 * 
	 * @return
	 */
	private List<SecMenu> getAllowedAccessMenu() {
		MenuManager menuManager = springContext.getBean(MenuManager.class);
		return menuManager.getAllowedAccessMenu(ShiroUtils.getUserId());
	}

	/**
	 * 构建菜单目录
	 * 
	 * @param buffer
	 *            html信息
	 * @param menuMap
	 * @param menuId
	 */
	private void buildMenuTreeFolder(StringBuffer buffer,
			Map<Integer, List<SecMenu>> menuMap, Integer menuId) {
		List<SecMenu> treeFolders = menuMap.get(menuId);
		if (treeFolders == null) {
			return;
		}
		for (SecMenu menu : treeFolders) {
			List<SecMenu> treeNodes = menuMap.get(menu.getId());
			if((treeNodes == null || treeNodes.isEmpty()) && StringUtils.isEmpty(menu.getDescription())) {
				continue;
			}
			buffer.append("<dl>");
			buffer.append("<dt id='sidebar_goods_manage'><i class='pngFix'></i>");
			buffer.append(menu.getName());
			buffer.append("</dt>");
			buffer.append("<dd>");
			buffer.append("<ul>");
			/**
			 * 有子菜单时，将子菜单添加到当前节点上
			 */
			buildMenuTreeNode(buffer, treeNodes);
			buffer.append("</ul>");
			buffer.append("</dd>");
			buffer.append("</dl>");
		}
	}

	/**
	 * 循环子菜单资源，并构造tree型html语句
	 * 
	 * @param buffer
	 * @param treeNodes
	 */
	private void buildMenuTreeNode(StringBuffer buffer, List<SecMenu> treeNodes) {
		if (treeNodes == null) {
			return;
		}
		for (SecMenu menu : treeNodes) {
			buffer.append("<li>");
			buffer.append("<a href='");
			buffer.append(servletContext.getContextPath());
			buffer.append(menu.getDescription());
			buffer.append("' target='mainFrame' ");
			buffer.append(">");
			buffer.append(menu.getName());
			buffer.append("</a>");
			buffer.append("</li>");
		}
	}
}
