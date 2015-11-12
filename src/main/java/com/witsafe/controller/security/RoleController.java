package com.witsafe.controller.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.model.security.SecPermission;
import com.witsafe.model.security.SecRole;
import com.witsafe.service.security.PermissionManager;
import com.witsafe.service.security.RoleManager;

/**
 * 角色管理Controller
 * @author yuqs
 * @since 0.1
 */
@Controller
@RequestMapping(value = "/security/role")
public class RoleController {

	@Autowired
	private RoleManager roleManager;

	@Autowired
	private PermissionManager permissionManager;
	
	/**
	 * 分页查询角色，返回角色列表视图
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Page<SecRole> page, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		//page = roleManager.findPage(page, filters);
		model.addAttribute("page", page);
		return "security/roleList";
	}
	
	/**
	 * 新建角色时，返回角色编辑视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("role", new SecRole());
		model.addAttribute("authorities", permissionManager.getAll());
		return "security/roleEdit";
	}

	/**
	 * 编辑角色时，返回角色编辑视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		SecRole entity  = roleManager.getById(id);
		List<SecPermission> authorities = permissionManager.getAll();
		/*List<SecAuthority> auths = entity.getAuthorities();
		for(SecAuthority auth : authorities) {
			for(Authority selAuth : auths) {
				if(auth.getId().longValue() == selAuth.getId().longValue())
				{
					auth.setSelected(1);
				}
				if(auth.getSelected() == null)
				{
					auth.setSelected(0);
				}
			}
		}*/
		model.addAttribute("role", entity);
		model.addAttribute("authorities", authorities);
		return "security/roleEdit";
	}
	
	/**
	 * 编辑角色时，返回角色查看视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("role", roleManager.getById(id));
		return "security/roleView";
	}
	
	/**
	 * 新增、编辑角色页面的提交处理。保存角色实体，并返回角色列表视图
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(SecRole role, Long[] orderIndexs) {
		/*if(orderIndexs != null) {
			for(Long order : orderIndexs) {
				SecAuthority auth = new SecAuthority(order);
				role.getAuthorities().add(auth);
			}
		}
		roleManager.save(role);*/
		return "redirect:/security/role";
	}
	
	/**
	 * 根据主键ID删除角色实体，并返回角色列表视图
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		roleManager.delete(id);
		return "redirect:/security/role";
	}
}
