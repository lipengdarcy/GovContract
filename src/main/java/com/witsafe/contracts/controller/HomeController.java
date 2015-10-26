package com.witsafe.contracts.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.witsafe.contracts.common.Constant;
import com.witsafe.contracts.dao.OrganizationMapper;
import com.witsafe.contracts.entity.common.ResponseData;
import com.witsafe.contracts.model.Account;
import com.witsafe.contracts.model.Organization;
import com.witsafe.contracts.model.OrganizationExample;
import com.witsafe.contracts.service.AccountService;

/**
 * @Description 主页操作，包括查看，编辑，删除通讯录，维护组织机构等
 * @author lipeng
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	private static Logger loggerinfo = Logger.getLogger("InfoLogger");

	@Autowired
	private AccountService accountService;

	@Autowired
	private OrganizationMapper organizationMapper;

	/**
	 * 主页面
	 */
	@RequestMapping()
	public String load(ModelMap m) {
		return "home/index";
	}

	/**
	 * 新增机构
	 */
	@ResponseBody
	@RequestMapping(value = "/addOrg", method = RequestMethod.POST)
	public ResponseData addOrg(HttpSession session, Organization org, ModelMap m) {
		ResponseData data = new ResponseData();
		try {
			organizationMapper.insertSelective(org);
			data.setState("success");
			data.setContent("新增成功！");
			return data;
		} catch (Exception e) {
			data.setState("failed");
			data.setContent("新增失败！");
			return data;
		}

	}
	
	/**
	 * 删除机构
	 */
	@ResponseBody
	@RequestMapping(value = "/delOrg", method = RequestMethod.POST)
	public ResponseData delOrg(HttpSession session, int orgid, ModelMap m) {
		ResponseData data = new ResponseData();
		try {
			organizationMapper.deleteByPrimaryKey(orgid);
			data.setState("success");
			data.setContent("删除成功！");
			return data;
		} catch (Exception e) {
			data.setState("failed");
			data.setContent("删除失败！");
			return data;
		}

	}
	
	/**
	 * 编辑机构
	 */
	@ResponseBody
	@RequestMapping(value = "/editOrg", method = RequestMethod.POST)
	public ResponseData editOrg(HttpSession session, Organization org, ModelMap m) {
		ResponseData data = new ResponseData();
		try {
			organizationMapper.updateByPrimaryKeySelective(org);
			data.setState("success");
			data.setContent("编辑成功！");
			return data;
		} catch (Exception e) {
			data.setState("failed");
			data.setContent("编辑失败！");
			return data;
		}

	}
	
	/**
	 * 查询所有机构
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOrg", method = RequestMethod.POST)
	public List<Organization> queryOrg(ModelMap m) {

		try {
			List<Organization> list = organizationMapper.selectByExample(new OrganizationExample());			
			return list;
		} catch (Exception e) {
			return null;
		}

	}

}
