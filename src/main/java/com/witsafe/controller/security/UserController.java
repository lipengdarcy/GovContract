package com.witsafe.controller.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witsafe.contracts.model.security.SecRole;
import com.witsafe.contracts.model.security.SecUser;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.service.security.RoleManager;
import com.witsafe.service.security.UserManager;

/**
 * 用户管理Controller
 * @author yuqs
 * @since 0.1
 */
@Controller
@RequestMapping(value = "/security/user")
public class UserController {
	//注入用户管理对象
	@Autowired
	private UserManager userManager;
	//注入角色管理对象
	@Autowired
	private RoleManager roleManager;
	
	/**
	 * 分页查询用户，返回用户列表视图
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Page<SecUser> page, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		//page = userManager.findPage(page, filters);
		model.addAttribute("page", page);
		return "security/userList";
	}
	
	/**
	 * 新建用户时，返回用户编辑视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("user", new SecUser());
		model.addAttribute("roles", roleManager.getAll());
		return "security/userEdit";
	}

	/**
	 * 编辑用户时，返回用户编辑视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		SecUser entity = userManager.get(id);
		List<SecRole> roles = roleManager.getAll();
		/*List<SecRole> roless = entity.getRoles();
		for(SecRole role : roles) {
			for(Role selRole : roless) {
				if(role.getId().longValue() == selRole.getId().longValue())
				{
					role.setSelected(1);
				}
				if(role.getSelected() == null)
				{
					role.setSelected(0);
				}
			}
		}*/
		model.addAttribute("user", userManager.get(id));
		model.addAttribute("roles", roles);
		return "security/userEdit";
	}
	
	/**
	 * 编辑用户时，返回用户查看视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("user", userManager.get(id));
		return "security/userView";
	}
	
	/**
	 * 新增、编辑用户页面的提交处理。保存用户实体，并返回用户列表视图
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(SecUser user, Long[] orderIndexs, Long parentOrgId) {
		/*if(orderIndexs != null) {
			for(Long order : orderIndexs) {
				SecRole role = new SecRole();
				role.setId(order);
				user.getRoles().add(role);
			}
		}
		if(parentOrgId != null && parentOrgId.longValue() > 0) {
			Org parent = new Org(parentOrgId);
			user.setOrg(parent);
		}
		userManager.save(user);*/
		return "redirect:/security/user";
	}
	
	/**
	 * 根据主键ID删除用户实体，并返回用户列表视图
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		userManager.delete(id);
		return "redirect:/security/user";
	}
}
