package com.witsafe.controller.security;

import java.awt.Menu;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witsafe.contracts.model.security.SecMenu;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.service.security.MenuManager;

/**
 * 菜单管理Controller
 * @author yuqs
 * @since 0.1
 */
@Controller
@RequestMapping(value = "/security/menu")
public class MenuController {
	//注入菜单管理对象
	@Autowired
	private MenuManager menuManager;
	
	/**
	 * 分页查询菜单，返回菜单列表视图
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Page<Menu> page, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		//page = menuManager.findPage(page, filters);
		model.addAttribute("page", page);
		model.addAttribute("lookup", request.getParameter("lookup"));
		return "security/menuList";
	}
	
	/**
	 * 新建菜单时，返回菜单编辑视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("menu", new SecMenu());
		return "security/menuEdit";
	}

	/**
	 * 编辑菜单时，返回菜单编辑视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("menu", menuManager.get(id));
		return "security/menuEdit";
	}
	
	/**
	 * 编辑菜单时，返回菜单查看视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("menu", menuManager.get(id));
		return "security/menuView";
	}
	
	/**
	 * 新增、编辑菜单页面的提交处理。保存菜单实体，并返回菜单列表视图
	 * @param Menu
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(SecMenu menu, Integer parentMenuId) {
		if(parentMenuId != null && parentMenuId.longValue() > 0) {
			menu.setParentMenu(parentMenuId);
		}
		menuManager.save(menu);
		return "redirect:/security/menu.do";
	}
	
	/**
	 * 根据主键ID删除菜单实体，并返回菜单列表视图
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		menuManager.delete(id);
		return "redirect:/security/menu.do";
	}
}
