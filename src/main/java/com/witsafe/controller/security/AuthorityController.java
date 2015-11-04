package com.witsafe.controller.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.witsafe.contracts.model.security.SecAuthority;
import com.witsafe.contracts.model.security.SecResource;
import com.witsafe.framework.orm.Page;
import com.witsafe.framework.orm.PropertyFilter;
import com.witsafe.service.security.AuthorityManager;
import com.witsafe.service.security.ResourceManager;

/**
 * 权限管理Controller
 * @author yuqs
 * @since 0.1
 */
@Controller
@RequestMapping(value = "/security/authority")
public class AuthorityController {
	//注入权限管理对象
	@Autowired
	private AuthorityManager authorityManager;
	//注入资源管理对象
	@Autowired
	private ResourceManager resourceManager;
	
	/**
	 * 分页查询权限，返回权限列表视图
	 * @param model
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, Page<SecAuthority> page, HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(request);
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		//page = authorityManager.findPage(page, filters);
		model.addAttribute("page", page);
		return "security/authorityList";
	}
	
	/**
	 * 新建权限时，返回权限编辑视图
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("authority", new SecAuthority());
		model.addAttribute("resources", resourceManager.getAll());
		return "security/authorityEdit";
	}

	/**
	 * 编辑权限时，返回权限编辑视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		SecAuthority entity = authorityManager.getById(id);
		List<SecResource> resources = resourceManager.getAll();
		/*List<SecResource> resss = entity.getResources();
		for(SecResource res : resources) {
			for(SecResource selRes : resss) {
				if(res.getId().longValue() == selRes.getId().longValue())
				{
					res.setSelected(1);
				}
				if(res.getSelected() == null)
				{
					res.setSelected(0);
				}
			}
		}*/
		model.addAttribute("authority", entity);
		model.addAttribute("resources", resources);
		return "security/authorityEdit";
	}
	
	/**
	 * 编辑权限时，返回权限查看视图
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("authority", authorityManager.getById(id));
		return "security/authorityView";
	}
	
	/**
	 * 新增、编辑权限页面的提交处理。保存权限实体，并返回权限列表视图
	 * @param Authority
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(SecAuthority authority, Long[] orderIndexs) {
		/*if(orderIndexs != null) {
			for(Long order : orderIndexs) {
				SecResource res = new SecResource(order);
				authority.getResources().add(res);
			}
		}
		authorityManager.save(authority);*/
		return "redirect:/security/authority";
	}
	
	/**
	 * 根据主键ID删除权限实体，并返回权限列表视图
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		//authorityManager.delete(id);
		return "redirect:/security/authority";
	}
}
